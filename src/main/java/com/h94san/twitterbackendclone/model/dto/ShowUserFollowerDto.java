package com.h94san.twitterbackendclone.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowUserFollowerDto {
    private int followerId;
    private String username;
    private String follower;
    private LocalDateTime followerDate;
}
