package com.jtechmind.librarymanagement.exceptions;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException(String message){
        super(message);
    }
}
