package com.example.leadmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leadmanager.entity.UnqualifiedLead;

public interface UnqualifiedLeadRepository extends JpaRepository<UnqualifiedLead, Long> {
    
    
}
