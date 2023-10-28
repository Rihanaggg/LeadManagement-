package com.example.leadmanager.DTOs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.leadmanager.dto.OpportunityFormDTO;

public class OpportunityFormDTOTests {

    @Test
    public void createOpportunityFormDTO() {
        // Create a new OpportunityFormDTO object
        OpportunityFormDTO opportunityFormDTO = new OpportunityFormDTO();
        opportunityFormDTO.setRequiredQuantity(5);
        opportunityFormDTO.setExpectedRevenue(1000.00);
        opportunityFormDTO.setProbability(0.75);
        opportunityFormDTO.setExpectedClosingDate(new Date());
        opportunityFormDTO.setProducts("Product A, Product B");
        opportunityFormDTO.setStatus("qualified");
        opportunityFormDTO.setSource("web");
        opportunityFormDTO.setAccountName("Example Account");

        // Check if the properties of the OpportunityFormDTO are set correctly
        assertEquals(5, opportunityFormDTO.getRequiredQuantity());
        assertEquals(1000.00, opportunityFormDTO.getExpectedRevenue());
        assertEquals(0.75, opportunityFormDTO.getProbability());
        assertNotNull(opportunityFormDTO.getExpectedClosingDate());
        assertEquals("Product A, Product B", opportunityFormDTO.getProducts());
        assertEquals("qualified", opportunityFormDTO.getStatus());
        assertEquals("web", opportunityFormDTO.getSource());
        assertEquals("Example Account", opportunityFormDTO.getAccountName());
    }

    // Add more tests as needed...
}

