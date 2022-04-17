package com.fibospiralmatrix.spiral.security.login.controller;

import javax.validation.Valid;

import com.fibospiralmatrix.spiral.security.login.dto.AuthenticateUserDTO;
import com.fibospiralmatrix.spiral.security.login.model.reponse.JwtResponse;
import com.fibospiralmatrix.spiral.security.login.model.reponse.MessageResponse;
import com.fibospiralmatrix.spiral.security.login.model.reponse.MessageResponseEnum;
import com.fibospiralmatrix.spiral.security.login.model.request.LoginRequest;
import com.fibospiralmatrix.spiral.security.login.model.request.SignupRequest;
import com.fibospiralmatrix.spiral.security.login.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController (AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        AuthenticateUserDTO authenticateUserDTO = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(new JwtResponse(authenticateUserDTO.getJwt(),
                authenticateUserDTO.getUserDetailsId(),
                authenticateUserDTO.getUserDetailsUsername(),
                authenticateUserDTO.getUserDetailsEmail(),
                authenticateUserDTO.getRoles()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        String registerUserResponse = authService.registerUser(signUpRequest);
        if (MessageResponseEnum.USERNAME_TAKEN.toString().equals(registerUserResponse)){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        } else if (MessageResponseEnum.EMAIL_TAKEN.toString().equals(registerUserResponse)){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
