package com.h94san.twitterbackendclone.controller;

import com.h94san.twitterbackendclone.model.dto.AddFollowRequest;
import com.h94san.twitterbackendclone.service.FollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/follow")
public class FollowController {
    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AddFollowRequest addFollowRequest){
        return ResponseEntity.ok(this.followService.followingAdd(addFollowRequest));
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return  ResponseEntity.ok(this.followService.findAll());
    }

    @GetMapping("/findByUserFollower")
    public ResponseEntity<?> findByUserFollower(@RequestParam String username){
        return ResponseEntity.ok(followService.findByUserFollower(username));
    }

    @GetMapping("/findByUserFollowing")
    public ResponseEntity<?> findByUserFollowing(@RequestParam String username){
        return ResponseEntity.ok(followService.findByUserFollowing(username));
    }

}
