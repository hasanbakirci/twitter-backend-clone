package com.h94san.twitterbackendclone.core.utilities.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class CustomBadRequestException extends RuntimeException{
    private String message;
    public CustomBadRequestException(String message){
        this.message=message;
    }
}
