package org.example.testovoe.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionValidationResponse {
    private Date timestamp;
    private Map<String,String> errorMessages = new HashMap<>();
    private String details;
}
