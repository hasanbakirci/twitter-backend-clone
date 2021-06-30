package com.h94san.twitterbackendclone.model.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private int id;
    private String username;
    private String email;
}
