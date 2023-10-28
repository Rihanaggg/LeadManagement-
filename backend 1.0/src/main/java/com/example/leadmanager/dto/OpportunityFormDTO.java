package com.example.leadmanager.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OpportunityFormDTO {

    private int requiredQuantity;
    private double expectedRevenue;
    private double probability;
   // private int priority;
    private Date expectedClosingDate;
    private String products;
    private String status;
    private String source;
    private String accountName;

}
