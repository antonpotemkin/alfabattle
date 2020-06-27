package com.potemkin.alfabattle.task2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {
    private static final long serialVersionUID = 7057185664051689118L;
}
