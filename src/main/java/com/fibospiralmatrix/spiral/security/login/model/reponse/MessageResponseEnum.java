package com.fibospiralmatrix.spiral.security.login.model.reponse;

public enum MessageResponseEnum {
    USERNAME_TAKEN("Error: Username is already taken!"),
    EMAIL_TAKEN("Error: Username is already taken!"),
    USER_REGISTERED_SUCCESSFULLY("Error: Username is already taken!");

    private String message;

    public String getMessageResponseEnum()
    {
        return this.message;
    }

    private MessageResponseEnum(String message)
    {
        this.message = message;
    }

}
