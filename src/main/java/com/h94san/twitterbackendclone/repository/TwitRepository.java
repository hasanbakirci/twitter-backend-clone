package com.h94san.twitterbackendclone.repository;

import com.h94san.twitterbackendclone.model.Twit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitRepository extends JpaRepository<Twit,Integer> {

}
