package com.potemkin.alfabattle.task3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BranchException extends RuntimeException {
    private static final long serialVersionUID = 7057185664051689118L;
}
