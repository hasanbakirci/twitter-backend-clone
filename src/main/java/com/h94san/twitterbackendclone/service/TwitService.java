package com.h94san.twitterbackendclone.service;

import com.h94san.twitterbackendclone.core.utilities.results.DataResult;
import com.h94san.twitterbackendclone.core.utilities.results.SuccessDataResult;
import com.h94san.twitterbackendclone.model.Twit;
import com.h94san.twitterbackendclone.model.User;
import com.h94san.twitterbackendclone.model.dto.CreateTwitRequest;
import com.h94san.twitterbackendclone.model.dto.ShowTwitRequestDto;
import com.h94san.twitterbackendclone.model.dto.ShowUserFollowingDto;
import com.h94san.twitterbackendclone.repository.TwitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TwitService {
    private final TwitRepository twitRepository;
    private final UserService userService;
    private final FollowService followService;

    public TwitService(TwitRepository twitRepository, UserService userService, FollowService followService) {
        this.twitRepository = twitRepository;
        this.userService = userService;
        this.followService = followService;
    }

    public DataResult<Twit> createTwit(CreateTwitRequest createTwitRequest){
        User user = userService.findUserById(createTwitRequest.getUserId());
        Twit myTwit = new Twit(
                createTwitRequest.getContext(),
                createTwitRequest.getStar(),
                user);
        return new SuccessDataResult(twitRepository.save(myTwit),"Eklendi");
    }

    public DataResult<List<ShowTwitRequestDto>> findAll(){
        List<Twit> twits = twitRepository.findAll();
        List<ShowTwitRequestDto> showTwitRequestDtos = twits.stream().map(item ->
                new ShowTwitRequestDto(item.getId(),
                        item.getContext(),
                        item.getCreatedDate(),
                        item.getStar(),
                        item.getUser().getUsername())).collect(Collectors.toList());
       return new SuccessDataResult<>(showTwitRequestDtos,"Tüm twitler listelendi");
   }

   public DataResult<List<ShowTwitRequestDto>> findByUsernameTwit(String username){
       List<ShowTwitRequestDto> showTwitRequestDtos = findAll().getData().stream().filter(item -> item.getUsername()
               .equals(username)).collect(Collectors.toList());
       return new SuccessDataResult<>(showTwitRequestDtos,"Kullanıcı twitleri listelendi");
   }
   public DataResult<List<ShowTwitRequestDto>> findByTimelineTwit(String username){
       var followings = followService.findByUserFollowing(username).getData();
       var twits = twitRepository.findAll()
               .stream().filter(f-> followings.stream()
                       .anyMatch(x -> f.getUser().getUsername()
                               .equals(x.getFollowing()))).map(item ->
                       new ShowTwitRequestDto(
                               item.getId(),
                               item.getContext(),
                               item.getCreatedDate(),
                               item.getStar(),
                               item.getUser().getUsername()
                       )).collect(Collectors.toList());
       return  new SuccessDataResult<>(twits,"Timeline");

   }

}
