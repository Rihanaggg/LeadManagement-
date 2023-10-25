package com.example.leadmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leadmanager.entity.NewLead;

public interface NewLeadRepository extends JpaRepository<NewLead, Long> {
     // Count new leads by status
     int countNewLeadsByStatus(String status);

     // Count new leads by source
     int countNewLeadsBySource(String source);
 
     // Count new leads by region
     int countNewLeadsByRegion(String region);
}

