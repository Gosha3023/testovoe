package org.example.testovoe.exception;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ExceptionValidationResponse {
    private final LocalDateTime timestamp;
    private final Map<String,String> errorMessages;
    private final String details;

    public ExceptionValidationResponse(Map<String,String> errorMessages, String details) {
        this.timestamp = LocalDateTime.now();
        this.errorMessages = errorMessages;
        this.details = details;
    }
}
