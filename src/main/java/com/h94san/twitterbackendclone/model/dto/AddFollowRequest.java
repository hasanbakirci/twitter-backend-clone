package com.h94san.twitterbackendclone.model.dto;

import lombok.Data;

@Data
public class AddFollowRequest {
    private int id;
    private int followerUserId;
    private int followingUserId;
}
