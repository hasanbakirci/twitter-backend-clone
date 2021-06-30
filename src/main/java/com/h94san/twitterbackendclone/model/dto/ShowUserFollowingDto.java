package com.h94san.twitterbackendclone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowUserFollowingDto {
    private int id;
    private String username;
    private String following;
    private LocalDateTime followerDate;
}
