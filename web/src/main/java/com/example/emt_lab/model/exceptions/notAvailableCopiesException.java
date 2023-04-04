package com.example.emt_lab.model.exceptions;

public class notAvailableCopiesException extends RuntimeException{
    public notAvailableCopiesException() {
        super("No more copies!");
    }
}
