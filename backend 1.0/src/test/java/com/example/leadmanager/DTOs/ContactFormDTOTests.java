package com.example.leadmanager.DTOs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.leadmanager.dto.ContactFormDTO;

public class ContactFormDTOTests {

    @Test
    public void createContactFormDTO() {
        // Create a new ContactFormDTO object
        ContactFormDTO contactFormDTO = new ContactFormDTO();
        contactFormDTO.setName("John Doe");
        contactFormDTO.setEmail("john.doe@example.com");
        contactFormDTO.setPhone("1234567890");
        contactFormDTO.setJobTitle("Manager");
        contactFormDTO.setAccountName("Example Account");
        contactFormDTO.setLeadSource("Web");

        // Check if the properties of the ContactFormDTO are set correctly
        assertEquals("John Doe", contactFormDTO.getName());
        assertEquals("john.doe@example.com", contactFormDTO.getEmail());
        assertEquals("1234567890", contactFormDTO.getPhone());
        assertEquals("Manager", contactFormDTO.getJobTitle());
        assertEquals("Example Account", contactFormDTO.getAccountName());
        assertEquals("Web", contactFormDTO.getLeadSource());
    }

    // Add more tests as needed...
}

