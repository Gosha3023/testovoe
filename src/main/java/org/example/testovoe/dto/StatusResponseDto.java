package org.example.testovoe.dto;

import lombok.*;

@Getter
public class StatusResponseDto {
    private final Long id;
    private final Boolean currentStatus;
    private final Boolean previousStatus;

    public StatusResponseDto(Long id, Boolean currentStatus, Boolean previousStatus) {
        this.id = id;
        this.currentStatus = currentStatus;
        this.previousStatus = previousStatus;
    }
}
