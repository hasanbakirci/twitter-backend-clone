package com.h94san.twitterbackendclone.service;

import com.h94san.twitterbackendclone.core.utilities.results.DataResult;
import com.h94san.twitterbackendclone.core.utilities.results.SuccessDataResult;
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

    public DataResult<Follow> followingAdd(AddFollowRequest addFollowRequest){
        User followerUser = userService.findUserById(addFollowRequest.getFollowerUserId());
        User followingUser  = userService.findUserById(addFollowRequest.getFollowingUserId());
        Follow follow = new Follow(followerUser.getId(),followingUser.getId() );
        return new SuccessDataResult(followRepository.save(follow),"Eklendi");
    }

    public DataResult<List<Follow>> findAll(){
        return new SuccessDataResult(followRepository.findAll(),"Takip, Takipçi listelendi");
    }

    public DataResult<List<ShowUserFollowingDto>> findByUserFollowing(String username){
        var user = userService.getByUsername(username).getData();
        List<Follow> followers = followRepository.findAll().stream().filter(u -> u.getFollowerUserId() == user.getId()).collect(Collectors.toList());
        List<ShowUserFollowingDto> showUserFollowingDtos = followers.stream().map(item ->
                new ShowUserFollowingDto(user.getId(),
                        user.getUsername(),
                        userService.findUserById(item.getFollowingUserId()).getUsername(),
                        item.getFollowerDate())).collect(Collectors.toList());
        return new SuccessDataResult(showUserFollowingDtos,"Takip edilenler listelendi");
    }
    public DataResult<List<ShowUserFollowerDto>> findByUserFollower(String username){
        var user = userService.getByUsername(username);
        List<Follow> followers = followRepository.findAll().stream().filter(u -> u.getFollowingUserId() == user.getData().getId()).collect(Collectors.toList());
        List<ShowUserFollowerDto> showUserFollowerDtos = followers.stream().map(item ->
                new ShowUserFollowerDto(item.getId(),
                        user.getData().getUsername(),
                        userService.findUserById(item.getFollowerUserId()).getUsername(),
                        item.getFollowerDate())).collect(Collectors.toList());
        return new SuccessDataResult(showUserFollowerDtos,"Takipçiler listelendi");
    }
}
