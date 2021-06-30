package com.h94san.twitterbackendclone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowTwitRequestDto {
    private int id;
    private String context;
    private LocalDateTime createdDate;
    private int star;
    private String username;
}
