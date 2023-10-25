package com.example.leadmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leadmanager.entity.NewLead;

public interface NewLeadRepository extends JpaRepository<NewLead, Long> {
    
}

