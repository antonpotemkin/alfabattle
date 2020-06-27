package com.potemkin.alfabattle.task2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserExceptionEntity> customHandleNotFound(Exception ex, WebRequest request) {
        UserExceptionEntity error = new UserExceptionEntity("user not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
