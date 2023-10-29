package com.example.leadmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.leadmanager.entity.QualifiedLead;

public interface QualifiedLeadRepository extends JpaRepository<QualifiedLead, Long> {
    @Query("SELECT COUNT(ql.newLead) FROM QualifiedLead ql")
    Integer countNewLeads();
}
