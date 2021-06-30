package com.h94san.twitterbackendclone.controller;

import com.h94san.twitterbackendclone.model.User;
import com.h94san.twitterbackendclone.model.dto.CreateUserRequest;
import com.h94san.twitterbackendclone.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> getAll(){
        return  ResponseEntity.ok(this.userService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<User> add(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(this.userService.createUser(createUserRequest));
    }

    @GetMapping("/getByUsername")
    public ResponseEntity<User> getByUsername(@RequestParam String username){
        return ResponseEntity.ok(this.userService.getByUsername(username));
    }

}
