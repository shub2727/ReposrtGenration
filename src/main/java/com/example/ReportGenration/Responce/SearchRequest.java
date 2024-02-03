package com.example.ReportGenration.Responce;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchRequest {

    private String planName;
    private String planStatus;
    private LocalDate startDate;
    private LocalDate endDate;
}
