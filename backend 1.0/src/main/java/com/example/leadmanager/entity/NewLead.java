package com.example.leadmanager.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class NewLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newleadid;

    @NotBlank
    private String name;
    private String companyName;

    @Email
    private String email;

    @Size(max=10)
    private String phone;
    private String jobTitle;
    private String address;
    private String state;
    private String region;       //east,west,north,south
    private String website;
    private String typeOfBusiness;
    private int requiredQuantity;
    private double expectedRevenue;
    private double probability;
    private String products;    //Accounting software,Cloud services,Communication softwarez, Content management software, Customer service platforms,   Analytics,  Cloud storage
    private String status;    //new,qualified,proposition,negotiation,won
    private String source;       //web,phone inquiry,referral
    private Date createdDate;
    @ManyToOne
    private User owner;

}
