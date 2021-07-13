package org.example.testovoe.Exception;

public class NotSuchUserException extends RuntimeException{
    public NotSuchUserException(String message) {
        super(message);
    }
}
