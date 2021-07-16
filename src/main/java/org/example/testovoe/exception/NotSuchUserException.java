package org.example.testovoe.exception;

public class NotSuchUserException extends RuntimeException{
    public NotSuchUserException() {
        super("Пользователь с указаным id не найден");
    }
}
