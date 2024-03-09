package com.gestionStudent.gestionStudent.service.auth;

public class AuthenticationReponse {

    private String token;

    public AuthenticationReponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
