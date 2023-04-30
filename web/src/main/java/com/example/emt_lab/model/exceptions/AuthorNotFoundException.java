package com.example.emt_lab.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with %d does not exist!", id));
    }
}
