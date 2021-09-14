package org.example.testovoe.exception;

public class FileIncorrectFormatException extends RuntimeException {
    public FileIncorrectFormatException() {
        super("некорректный формат");
    }
}
