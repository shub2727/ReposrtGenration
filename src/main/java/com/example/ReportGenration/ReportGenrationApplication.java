package com.example.ReportGenration;


import com.example.ReportGenration.Repository.EligibilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportGenrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportGenrationApplication.class, args);
	}


}
