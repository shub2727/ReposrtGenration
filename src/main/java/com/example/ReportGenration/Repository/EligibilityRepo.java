package com.example.ReportGenration.Repository;


import com.example.ReportGenration.Entity.Eligibility;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EligibilityRepo extends JpaRepository<Eligibility,Integer> {
}
