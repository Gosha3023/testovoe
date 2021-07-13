package org.example.testovoe.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsRequestDTO {
    private Boolean status;
    private Timestamp timestamp;
}
