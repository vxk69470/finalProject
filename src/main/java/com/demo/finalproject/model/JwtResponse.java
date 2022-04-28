package com.demo.finalproject.model;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
    private String username;
    private String token;
    private List<String> roles;
}
