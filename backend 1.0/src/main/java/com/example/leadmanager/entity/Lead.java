package com.example.leadmanager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;

    
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "newleadid")
    private NewLead newLead;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "id")
    private Opportunity opportunity;

    

}
