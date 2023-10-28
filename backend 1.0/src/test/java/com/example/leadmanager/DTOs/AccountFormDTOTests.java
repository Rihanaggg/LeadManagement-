package com.example.leadmanager.DTOs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.leadmanager.dto.AccountFormDTO;

public class AccountFormDTOTests {

    @Test
    public void createAccountFormDTO() {
        // Create a new AccountFormDTO object
        AccountFormDTO accountFormDTO = new AccountFormDTO();
        accountFormDTO.setCompanyName("Example Company");
        accountFormDTO.setAddress("123 Main St");
        accountFormDTO.setState("California");
        accountFormDTO.setRegion("West");
        accountFormDTO.setWebsite("example.com");
        accountFormDTO.setTypeOfBusiness("Finance");
        accountFormDTO.setPhone("1234567890");
        accountFormDTO.setEmail("info@example.com");
        accountFormDTO.setTypeOfAccount("Customer");
        accountFormDTO.setActive("Yes");

        // Check if the properties of the AccountFormDTO are set correctly
        assertEquals("Example Company", accountFormDTO.getCompanyName());
        assertEquals("123 Main St", accountFormDTO.getAddress());
        assertEquals("California", accountFormDTO.getState());
        assertEquals("West", accountFormDTO.getRegion());
        assertEquals("example.com", accountFormDTO.getWebsite());
        assertEquals("Finance", accountFormDTO.getTypeOfBusiness());
        assertEquals("1234567890", accountFormDTO.getPhone());
        assertEquals("info@example.com", accountFormDTO.getEmail());
        assertEquals("Customer", accountFormDTO.getTypeOfAccount());
        assertEquals("Yes", accountFormDTO.getActive());
    }

    // Add more tests as needed...
}

