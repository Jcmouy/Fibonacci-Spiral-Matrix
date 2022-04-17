package com.fibospiralmatrix.spiral.security.login.service;

import com.fibospiralmatrix.spiral.security.login.dto.AuthenticateUserDTO;
import com.fibospiralmatrix.spiral.security.login.entity.Role;
import com.fibospiralmatrix.spiral.security.login.entity.URole;
import com.fibospiralmatrix.spiral.security.login.entity.User;
import com.fibospiralmatrix.spiral.security.login.model.reponse.MessageResponseEnum;
import com.fibospiralmatrix.spiral.security.login.model.request.LoginRequest;
import com.fibospiralmatrix.spiral.security.login.model.request.SignupRequest;
import com.fibospiralmatrix.spiral.security.login.repository.RoleRepository;
import com.fibospiralmatrix.spiral.security.login.repository.UserRepository;
import com.fibospiralmatrix.spiral.security.login.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthServiceImpl (AuthenticationManager authenticationManager, UserRepository userRepository,
                           RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public AuthenticateUserDTO authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return getAuthenticationDTO(jwt, userDetails, roles);
    }

    @Override
    public String registerUser(SignupRequest signUpRequest) {
        if (verifyExistsByUsername(signUpRequest)){
            return MessageResponseEnum.USERNAME_TAKEN.toString();
        } else if (verifyExistsByEmail(signUpRequest)){
            return MessageResponseEnum.EMAIL_TAKEN.toString();
        }
        return createNewUserAccount(signUpRequest);
    }

    private boolean verifyExistsByUsername(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return true;
        }
        return false;
    }

    private boolean verifyExistsByEmail(SignupRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return true;
        }
        return false;
    }

    private String createNewUserAccount(SignupRequest signUpRequest) {
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = getRoleUser();
            roles.add(userRole);
        } else {
            roles = getRequestedRole(strRoles, roles);
        }
        user.setRoles(roles);
        userRepository.save(user);
        return MessageResponseEnum.USER_REGISTERED_SUCCESSFULLY.toString();
    }

    private Set<Role> getRequestedRole(Set<String> strRoles, Set<Role> roles){
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = getRoleAdmin();
                    roles.add(adminRole);
                    break;
                default:
                    Role userRole = getRoleUser();
                    roles.add(userRole);
            }
        });
        return roles;
    }

    private Role getRoleUser(){
        return roleRepository.findByName(URole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    private Role getRoleAdmin(){
        return roleRepository.findByName(URole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    private AuthenticateUserDTO getAuthenticationDTO(String jwt, UserDetailsImpl userDetails, List<String> roles) {
        AuthenticateUserDTO authenticateUserDTO = new AuthenticateUserDTO();
        authenticateUserDTO.setJwt(jwt);
        authenticateUserDTO.setUserDetailsId(userDetails.getId());
        authenticateUserDTO.setUserDetailsUsername(userDetails.getUsername());
        authenticateUserDTO.setUserDetailsEmail(userDetails.getEmail());
        authenticateUserDTO.setRoles(roles);
        return authenticateUserDTO;
    }
}
