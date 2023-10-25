package com.example.leadmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.leadmanager.entity.Opportunity;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    Optional<Opportunity> findById(Long id);
    List<Opportunity> findAll();
    List<Opportunity> findByStatus(String status);
    
}
