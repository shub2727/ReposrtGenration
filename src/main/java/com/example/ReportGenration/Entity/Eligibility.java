package com.example.ReportGenration.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Eligibility {

    @Id
    private Integer id;
    private String name;
    private String emailId;
    private  String mobileNo;
    private String gender;
    private String adharNo;
    private String planName;
    private String planStatus;

    private String createdBy;
    private String updatedBy;
}
