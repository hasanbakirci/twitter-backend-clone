package com.h94san.twitterbackendclone.service;

import com.h94san.twitterbackendclone.model.Follow;
import com.h94san.twitterbackendclone.model.User;
import com.h94san.twitterbackendclone.model.dto.CreateUserRequest;
import com.h94san.twitterbackendclone.model.dto.ShowUserFollowerDto;
import com.h94san.twitterbackendclone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected User findUserById(int id){
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(CreateUserRequest createUserRequest){
        User user = new User(createUserRequest.getId(),createUserRequest.getUsername(),createUserRequest.getEmail());
        return userRepository.save(user);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }



    public User getByUsername(String username){
        return this.userRepository.findAll().stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList()).get(0);
    }
}
