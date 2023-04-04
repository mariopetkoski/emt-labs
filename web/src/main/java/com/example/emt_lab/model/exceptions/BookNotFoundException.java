package com.example.emt_lab.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book wih %d not found", id));
    }
}
