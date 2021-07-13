package org.example.testovoe.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusResponse {
    Long id;
    Boolean currentStatus;
    Boolean previousStatus;
}
