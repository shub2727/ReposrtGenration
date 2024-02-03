package com.example.ReportGenration.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "EligibilityReport")
public class Report {

    @Id
    private Integer id;
    private String name;
    private String emailId;

}
