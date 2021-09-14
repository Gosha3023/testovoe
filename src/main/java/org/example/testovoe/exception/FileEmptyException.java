package org.example.testovoe.exception;

public class FileEmptyException extends RuntimeException {
    public FileEmptyException() {
        super("Пустой файл");
    }
}
