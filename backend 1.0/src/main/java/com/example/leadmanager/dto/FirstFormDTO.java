package com.example.leadmanager.dto;

import java.util.Date;

import lombok.Data;

@Data
public class FirstFormDTO {
    
    private String name;
    private String companyName;
    private String email;
    private String phone;
    private String jobTitle;
    private String address;
    private String state;
    private String region;
    private String website;
    private String typeOfBusiness;
    private int requiredQuantity;
    private double expectedRevenue;
    private double probability;
    private String products;
    private String status;
    private String source;
    private Date createdDate;
    
}

