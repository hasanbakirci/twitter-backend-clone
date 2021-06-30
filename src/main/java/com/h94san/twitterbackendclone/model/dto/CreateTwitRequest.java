package com.h94san.twitterbackendclone.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class CreateTwitRequest {
    private int id;
    @NotBlank
    private String context;
    private int star;
    private int userId;
}
