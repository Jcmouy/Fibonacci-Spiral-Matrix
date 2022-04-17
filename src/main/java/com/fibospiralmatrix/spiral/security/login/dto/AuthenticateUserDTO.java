package com.fibospiralmatrix.spiral.security.login.dto;

import java.util.List;

public class AuthenticateUserDTO {

    private String jwt;
    private Long userDetailsId;
    private String userDetailsUsername;
    private String userDetailsEmail;
    private List<String> roles;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public String getUserDetailsUsername() {
        return userDetailsUsername;
    }

    public void setUserDetailsUsername(String userDetailsUsername) {
        this.userDetailsUsername = userDetailsUsername;
    }

    public String getUserDetailsEmail() {
        return userDetailsEmail;
    }

    public void setUserDetailsEmail(String userDetailsEmail) {
        this.userDetailsEmail = userDetailsEmail;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
