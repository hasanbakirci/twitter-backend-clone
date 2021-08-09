package com.h94san.twitterbackendclone.service;

import com.h94san.twitterbackendclone.core.utilities.exception.CustomBadRequestException;
import com.h94san.twitterbackendclone.core.utilities.exception.CustomNotFoundException;
import com.h94san.twitterbackendclone.core.utilities.results.DataResult;
import com.h94san.twitterbackendclone.core.utilities.results.ErrorDataResult;
import com.h94san.twitterbackendclone.core.utilities.results.SuccessDataResult;
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
        return userRepository.findById(id)
                .orElseThrow(()-> new CustomNotFoundException("Kayıt bulunamadı"));
    }

    public DataResult<User> createUser(CreateUserRequest createUserRequest){
        if(getByUsername(createUserRequest.getUsername()).isSuccess())
            throw new CustomBadRequestException("Bu kullanıcı adı kullanılmakta");
        User newUser = new User(createUserRequest.getId(), createUserRequest.getUsername(), createUserRequest.getEmail());
        return new SuccessDataResult(userRepository.save(newUser), "Kullanıcı eklendi");
    }

    public DataResult<List<User>> findAll(){
        return new SuccessDataResult(this.userRepository.findAll(),"Kullanıcılar listelendi.");
    }

    public DataResult<User> getByUsername(String username){
        var user = this.userRepository.getByUsername(username)
                .orElseThrow(()-> new CustomNotFoundException("Kayıt bulunamadı"));
        return new SuccessDataResult(this.userRepository.getByUsername(username).get(),"Kayıt bulundu");
    }
}
