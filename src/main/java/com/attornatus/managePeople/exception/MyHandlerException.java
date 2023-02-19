package com.attornatus.managePeople.exception;

import com.attornatus.managePeople.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandlerException {

    @ExceptionHandler(value = EntityException.class)
    public ResponseEntity<Object> exception(EntityException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(exception.getMessage(),HttpStatus.NOT_FOUND.name()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException  exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(exception.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST.name(),exception.getFieldError().getField()));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.name()));
    }
}
