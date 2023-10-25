package com.example.leadmanager.dto;

import lombok.Data;

@Data
public class AccountFormDTO {
    private String companyName;
    private String address;
    private String state;
    private String region;
    private String website;
    private String typeOfBusiness;   //education,finance
    private String phone;
    private String email;
    private String typeOfAccount;
    private String active;
}
