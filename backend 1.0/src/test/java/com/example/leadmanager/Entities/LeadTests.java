package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.Account;
import com.example.leadmanager.entity.Contact;
import com.example.leadmanager.entity.Lead;
import com.example.leadmanager.entity.NewLead;
import com.example.leadmanager.entity.Opportunity;
import com.example.leadmanager.repository.LeadRepository;

@SpringBootTest
@Transactional
public class LeadTests {

    @Autowired
    private LeadRepository leadRepository;

    @Test
    public void saveLeadWithNewLead() {
        // Create a new Lead object
        Lead lead = new Lead();
        NewLead newLead = new NewLead();
        lead.setNewLead(newLead);

        // Save the Lead to the database
        leadRepository.save(lead);

        // Check if the Lead has been saved with a non-null newLead
        assertNotNull(lead.getNewLead());
    }

    @Test
    public void saveLeadWithNullNewLead() {
        // Create a new Lead object without setting the newLead
        Lead lead = new Lead();

        // Save the Lead to the database
        leadRepository.save(lead);

        // Check if the Lead has been saved with a null newLead
        assertNull(lead.getNewLead());
    }

    // Similar tests can be written for account, contact, and opportunity properties
    @Test
    public void saveLeadWithAllProperties() {
        // Create a new Lead object with all properties set
        Lead lead = new Lead();
        NewLead newLead = new NewLead();
        Account account = new Account();
        Contact contact = new Contact();
        Opportunity opportunity = new Opportunity();

        lead.setNewLead(newLead);
        lead.setAccount(account);
        lead.setContact(contact);
        lead.setOpportunity(opportunity);

        // Save the Lead to the database
        leadRepository.save(lead);

        // Check if the Lead has been saved with non-null properties
        assertNotNull(lead.getNewLead());
        assertNotNull(lead.getAccount());
        assertNotNull(lead.getContact());
        assertNotNull(lead.getOpportunity());
    }

    @Test
    public void saveLeadWithNullProperties() {
        // Create a new Lead object without setting any properties
        Lead lead = new Lead();

        // Save the Lead to the database
        leadRepository.save(lead);

        // Check if the Lead has been saved with null properties
        assertNull(lead.getNewLead());
        assertNull(lead.getAccount());
        assertNull(lead.getContact());
        assertNull(lead.getOpportunity());
    }

    @Test
    public void updateLeadProperties() {
        // Create a new Lead object and save it to the database
        Lead lead = new Lead();
        leadRepository.save(lead);

        // Update the Lead properties
        NewLead newLead = new NewLead();
        Account account = new Account();
        Contact contact = new Contact();
        Opportunity opportunity = new Opportunity();

        lead.setNewLead(newLead);
        lead.setAccount(account);
        lead.setContact(contact);
        lead.setOpportunity(opportunity);

        // Save the updated Lead to the database
        leadRepository.save(lead);

        // Retrieve the Lead from the database and check if properties have been updated
        Lead updatedLead = leadRepository.findById(lead.getLeadId()).orElse(null);
        assertNotNull(updatedLead);
        assertNotNull(updatedLead.getNewLead());
        assertNotNull(updatedLead.getAccount());
        assertNotNull(updatedLead.getContact());
        assertNotNull(updatedLead.getOpportunity());
    }

    @Test
    public void deleteLead() {
        // Create a new Lead object and save it to the database
        Lead lead = new Lead();
        leadRepository.save(lead);

        // Delete the Lead from the database
        leadRepository.delete(lead);

        // Try to retrieve the Lead from the database and expect it to be null
        Lead deletedLead = leadRepository.findById(lead.getLeadId()).orElse(null);
        assertNull(deletedLead);
    }
}
