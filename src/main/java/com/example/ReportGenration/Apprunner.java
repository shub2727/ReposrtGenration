package com.example.ReportGenration;

import com.example.ReportGenration.Entity.Eligibility;
import com.example.ReportGenration.Repository.EligibilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class Apprunner implements ApplicationRunner {

    @Autowired
    EligibilityRepo eligibilityRepo;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        Eligibility eligibility = new Eligibility();
        eligibility.setId(1);
        eligibility.setName("shubham");
        eligibility.setAdharNo("123-156-965");
        eligibility.setEmailId("shubham@gmail.com");
        eligibility.setGender("Male");
        eligibility.setMobileNo("778965989");




        Eligibility eligibility1 = new Eligibility();
        eligibility1.setId(2);
        eligibility1.setName("Kartik");
        eligibility1.setAdharNo("1234-1536-9365");
        eligibility1.setEmailId("kartik@gmail.com");
        eligibility1.setGender("Male");
        eligibility1.setMobileNo("99678965989");

        Eligibility eligibility2 = new Eligibility();
        eligibility2.setId(3);
        eligibility2.setName("yogesh");
        eligibility2.setAdharNo("1213-156-965");
        eligibility2.setEmailId("yogesh@gmail.com");
        eligibility2.setGender("Male");
        eligibility2.setMobileNo("8778965989");

        eligibilityRepo.save(eligibility);
        eligibilityRepo.save(eligibility1);
        eligibilityRepo.save(eligibility2);
    }
}
