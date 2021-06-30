package com.h94san.twitterbackendclone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="followings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="following_id")
    private int id;

    @Column(name="follower_user")
    private int followerUserId;

    @Column(name="following_user")
    private int followingUserId;

    @Column(name="following_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime followerDate = LocalDateTime.now();

    public Follow(int followerUser, int followingUser) {
        this.followerUserId = followerUser;
        this.followingUserId = followingUser;
    }
}
