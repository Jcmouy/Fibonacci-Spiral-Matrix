package com.fibospiralmatrix.spiral.security.login.service;

import com.fibospiralmatrix.spiral.security.login.dto.AuthenticateUserDTO;
import com.fibospiralmatrix.spiral.security.login.model.request.LoginRequest;
import com.fibospiralmatrix.spiral.security.login.model.request.SignupRequest;

public interface AuthService {

    AuthenticateUserDTO authenticateUser ( LoginRequest loginRequest);

    String registerUser (SignupRequest signUpRequest);
}
