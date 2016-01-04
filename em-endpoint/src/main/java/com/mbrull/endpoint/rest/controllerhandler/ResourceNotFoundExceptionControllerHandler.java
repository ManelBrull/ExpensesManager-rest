package com.mbrull.endpoint.rest.controllerhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mbrull.core.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundExceptionControllerHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String processValidationError(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

}
