package com.jschool.reha.model;

import lombok.Data;

public @Data class User {
    private String username;
    private String email;
    private String password;
    private String role;
}
