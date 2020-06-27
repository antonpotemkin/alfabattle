package com.potemkin.alfabattle.task3;

import com.potemkin.alfabattle.task3.exception.BranchException;
import com.potemkin.alfabattle.task3.exception.BranchExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BranchExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BranchException.class)
    public ResponseEntity<BranchExceptionEntity> customHandleNotFound(Exception ex, WebRequest request) {
        BranchExceptionEntity error = new BranchExceptionEntity("branch not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
