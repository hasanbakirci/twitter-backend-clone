package com.h94san.twitterbackendclone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","twits"}) // sadece mapping i getirsin diye
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="user_name")
    private String username;

    @Column(name="user_email")
    private String email;

    @Column(name="created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate = LocalDateTime.now();


    @OneToMany(mappedBy = "user")// mapped ismi diğer tablodaki değer olmalı
    private Set<Twit> twits;

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
