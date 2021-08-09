package com.h94san.twitterbackendclone.controller;

import com.h94san.twitterbackendclone.model.Twit;
import com.h94san.twitterbackendclone.model.dto.CreateTwitRequest;
import com.h94san.twitterbackendclone.model.dto.ShowTwitRequestDto;
import com.h94san.twitterbackendclone.service.TwitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/twits")
public class TwitController {
    private final TwitService twitService;

    public TwitController(TwitService twitService) {
        this.twitService = twitService;
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return  ResponseEntity.ok(this.twitService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> add(@Valid @RequestBody CreateTwitRequest createTwitRequest){
        return ResponseEntity.ok(this.twitService.createTwit(createTwitRequest));
    }

    // http://localhost:8080/api/twits/findByUsernameTwit?username=hasan
    @GetMapping("/findByUsernameTwit")
    public ResponseEntity<?> findByUsernameTwit(@RequestParam String username){
        return ResponseEntity.ok(this.twitService.findByUsernameTwit(username));
    }
    @GetMapping("/findByTimelineTwit")
    public ResponseEntity<?> findByTimelineTwit(@RequestParam String username){
        return ResponseEntity.ok(this.twitService.findByTimelineTwit(username));
    }


}
