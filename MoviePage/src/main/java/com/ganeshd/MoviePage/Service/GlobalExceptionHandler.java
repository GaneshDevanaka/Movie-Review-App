package com.ganeshd.MoviePage.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateImdbIdException.class)
    public ResponseEntity<String> handleDuplicateImdbIdException(DuplicateImdbIdException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
