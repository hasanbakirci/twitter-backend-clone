package com.h94san.twitterbackendclone.core.utilities.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class CustomNotFoundException extends RuntimeException{
    private String message;
    public CustomNotFoundException(String message){
        this.message = message;
    }
}
