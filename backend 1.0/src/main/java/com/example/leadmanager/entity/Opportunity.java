package com.example.leadmanager.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int requiredQuantity;
    private double expectedRevenue;
    private double probability;
    private Date expectedClosingDate;
    private String products;    //table,chairs....oppo name
    private String status;    //qualified,proposal,negotiation,closed won,closed lost
    private String source;    //web,phone inquiry,referral
    private String accountName;

    @ManyToOne
    private User owner;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;

}

