package com.example.leadmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
}

