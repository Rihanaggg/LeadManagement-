package com.example.leadmanager.dto;

import lombok.Data;

@Data
public class ContactFormDTO {
    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    //change it after won condition
    private String accountName;
    private String leadSource;
}
