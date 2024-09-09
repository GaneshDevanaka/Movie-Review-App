package com.ganeshd.MoviePage.Service;

public class DuplicateImdbIdException extends RuntimeException {
    public DuplicateImdbIdException(String message) {
        super(message);
    }
}
