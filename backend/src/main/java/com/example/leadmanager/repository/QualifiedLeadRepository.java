package com.example.leadmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leadmanager.entity.QualifiedLead;

public interface QualifiedLeadRepository extends JpaRepository<QualifiedLead, Long> {
    
}
