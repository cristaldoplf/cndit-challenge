package com.example.testcandoit.model.dto;


public class AuthenticationRequestDto {

    private String email;
    private String password;

    public AuthenticationRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticationRequestDto() {
        //no args constructor
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}