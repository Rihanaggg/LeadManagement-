package com.example.leadmanager.DTOs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.leadmanager.dto.FirstFormDTO;

public class FirstFormDTOTests {

    @Test
    public void createFirstFormDTO() {
        // Create a new FirstFormDTO object
        FirstFormDTO firstFormDTO = new FirstFormDTO();
        firstFormDTO.setName("John Doe");
        firstFormDTO.setCompanyName("Example Company");
        firstFormDTO.setEmail("john.doe@example.com");
        firstFormDTO.setPhone("1234567890");
        firstFormDTO.setJobTitle("Manager");
        firstFormDTO.setAddress("123 Main St");
        firstFormDTO.setState("California");
        firstFormDTO.setRegion("West");
        firstFormDTO.setWebsite("example.com");
        firstFormDTO.setTypeOfBusiness("Finance");
        firstFormDTO.setRequiredQuantity(5);
        firstFormDTO.setExpectedRevenue(1000.00);
        firstFormDTO.setProbability(0.75);
        firstFormDTO.setProducts("Product A, Product B");
        firstFormDTO.setStatus("qualified");
        firstFormDTO.setSource("web");
        firstFormDTO.setCreatedDate(new Date());

        // Check if the properties of the FirstFormDTO are set correctly
        assertEquals("John Doe", firstFormDTO.getName());
        assertEquals("Example Company", firstFormDTO.getCompanyName());
        assertEquals("john.doe@example.com", firstFormDTO.getEmail());
        assertEquals("1234567890", firstFormDTO.getPhone());
        assertEquals("Manager", firstFormDTO.getJobTitle());
        assertEquals("123 Main St", firstFormDTO.getAddress());
        assertEquals("California", firstFormDTO.getState());
        assertEquals("West", firstFormDTO.getRegion());
        assertEquals("example.com", firstFormDTO.getWebsite());
        assertEquals("Finance", firstFormDTO.getTypeOfBusiness());
        assertEquals(5, firstFormDTO.getRequiredQuantity());
        assertEquals(1000.00, firstFormDTO.getExpectedRevenue());
        assertEquals(0.75, firstFormDTO.getProbability());
        assertEquals("Product A, Product B", firstFormDTO.getProducts());
        assertEquals("qualified", firstFormDTO.getStatus());
        assertEquals("web", firstFormDTO.getSource());
        assertNotNull(firstFormDTO.getCreatedDate());
    }


}

