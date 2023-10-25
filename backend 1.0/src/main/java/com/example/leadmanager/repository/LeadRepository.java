package com.example.leadmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.leadmanager.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    Optional<Lead> findById(Long id);
    List<Lead> findAll();

    @Query("SELECT l FROM Lead l WHERE l.newLead.name LIKE %?1%")
    List<Lead> searchByName(String name);


    List<Lead> findByNewLeadCompanyNameContaining(String companyName);
    
    List<Lead> findByNewLeadStateContaining(String state);
    
    List<Lead> findByNewLeadStatusContaining(String status);
    
    List<Lead> findByNewLeadEmailContaining(String email);

    // Method to count leads by status
    @Query("SELECT COUNT(l) FROM Lead l WHERE l.newLead.status = :status")
    int countLeadsByStatus(@Param("status") String status);

    // Method to count leads by source
    @Query("SELECT COUNT(l) FROM Lead l WHERE l.newLead.source = :source")
    int countLeadsBySource(@Param("source") String source);

    // Method to count leads by region
    @Query("SELECT COUNT(l) FROM Lead l WHERE l.newLead.region = :region")
    int countLeadsByRegion(@Param("region") String region);

    @Query("SELECT COUNT(l) FROM Lead l WHERE l.newLead.products = :product")
    int countLeadsByProducts(@Param("product") String product);
}

