package com.example.leadmanager.entity;

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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;

    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    //change it after won condition
    private String accountName;
    private String leadSource;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;
}

