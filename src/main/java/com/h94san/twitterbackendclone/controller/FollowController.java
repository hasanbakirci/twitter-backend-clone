package com.h94san.twitterbackendclone.controller;

import com.h94san.twitterbackendclone.model.Follow;
import com.h94san.twitterbackendclone.model.dto.AddFollowRequest;
import com.h94san.twitterbackendclone.model.dto.ShowUserFollowerDto;
import com.h94san.twitterbackendclone.model.dto.ShowUserFollowingDto;
import com.h94san.twitterbackendclone.service.FollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
public class FollowController {
    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }
    @PostMapping("/save")
    public ResponseEntity<Follow> save(@RequestBody AddFollowRequest addFollowRequest){
        return ResponseEntity.ok(this.followService.followingAdd(addFollowRequest));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Follow>> findAll(){
        return  ResponseEntity.ok(this.followService.findAll());
    }

    @GetMapping("/findByFollowerUserId")
    public ResponseEntity<List<Follow>> findByFollowerUserId(@RequestParam int followerUserId){
        return ResponseEntity.ok(this.followService.findByFollowerUserId(followerUserId));
    }

    @GetMapping("/findByUserFollower")
    public ResponseEntity<List<ShowUserFollowerDto>> findByUserFollower(@RequestParam String username){
        return ResponseEntity.ok(followService.findByUserFollower(username));
    }

    @GetMapping("/findByUserFollowing")
    public ResponseEntity<List<ShowUserFollowingDto>> findByUserFollowing(@RequestParam String username){
        return ResponseEntity.ok(followService.findByUserFollowing(username));
    }

}
