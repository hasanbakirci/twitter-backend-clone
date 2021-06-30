package com.h94san.twitterbackendclone.service;

import com.h94san.twitterbackendclone.model.Follow;
import com.h94san.twitterbackendclone.model.User;
import com.h94san.twitterbackendclone.model.dto.AddFollowRequest;
import com.h94san.twitterbackendclone.model.dto.ShowUserFollowerDto;
import com.h94san.twitterbackendclone.model.dto.ShowUserFollowingDto;
import com.h94san.twitterbackendclone.repository.FollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final UserService userService;

    public FollowService(FollowRepository followRepository, UserService userService) {
        this.followRepository = followRepository;
        this.userService = userService;
    }

    public Follow followingAdd(AddFollowRequest addFollowRequest){
        User followerUser = userService.findUserById(addFollowRequest.getFollowerUserId());
        User followingUser  = userService.findUserById(addFollowRequest.getFollowingUserId());
        Follow follow = new Follow(followerUser.getId(),followingUser.getId() );
        return followRepository.save(follow);
    }

    public List<Follow> findAll(){
        return followRepository.findAll();
    }

    public List<Follow> findByFollowerUserId(int followerUserId){
        return followRepository.findByFollowerUserId(followerUserId);
    }
    public List<ShowUserFollowingDto> findByUserFollowing(String username){
        User user = userService.getByUsername(username);
        List<Follow> followers = followRepository.findAll().stream().filter(u -> u.getFollowerUserId() == user.getId()).collect(Collectors.toList());
        List<ShowUserFollowingDto> showUserFollowingDtos = followers.stream().map(item ->
                new ShowUserFollowingDto(user.getId(),
                        user.getUsername(),
                        userService.findUserById(item.getFollowingUserId()).getUsername(),
                        item.getFollowerDate())).collect(Collectors.toList());
        return showUserFollowingDtos;
    }
    public List<ShowUserFollowerDto> findByUserFollower(String username){
        User user = userService.getByUsername(username);
        List<Follow> followers = followRepository.findAll().stream().filter(u -> u.getFollowingUserId() == user.getId()).collect(Collectors.toList());
        List<ShowUserFollowerDto> showUserFollowerDtos = followers.stream().map(item ->
                new ShowUserFollowerDto(item.getId(),
                        user.getUsername(),
                        userService.findUserById(item.getFollowerUserId()).getUsername(),
                        item.getFollowerDate())).collect(Collectors.toList());
        return showUserFollowerDtos;
    }
}
