package org.example.testovoe.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class CsvImport {

    @CsvBindByName(column = "data")
    String data;


}
