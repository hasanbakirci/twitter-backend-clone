package com.h94san.twitterbackendclone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="twits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Twit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="twit_id")
    private int id;

    @Column(name="twit_context")
    private String context;

    @Column(name="created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name="twit_star")
    private int star;

    @ManyToOne()
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    public Twit(String context, int star, User user) {
        this.context = context;
        this.star = star;
        this.user = user;
    }
}
