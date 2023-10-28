package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.Account;
import com.example.leadmanager.entity.Opportunity;
import com.example.leadmanager.entity.User;
import com.example.leadmanager.repository.OpportunityRepository;

@SpringBootTest
@Transactional
public class OpportunityTests {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Test
    public void saveOpportunityWithAllProperties() {
        // Create a new Opportunity object with all properties set
        Opportunity opportunity = new Opportunity();
        opportunity.setRequiredQuantity(10);
        opportunity.setExpectedRevenue(1000.00);
        opportunity.setProbability(0.75);
        opportunity.setExpectedClosingDate(new Date());
        opportunity.setProducts("Table, Chairs");
        opportunity.setStatus("Qualified");
        opportunity.setSource("Web");
        opportunity.setAccountName("Example Account");

        // Set the owner
        User owner = new User();
        opportunity.setOwner(owner);

        // Set the associated account
        Account account = new Account();
        opportunity.setAccount(account);

        // Save the Opportunity to the database
        opportunityRepository.save(opportunity);

        // Check if the Opportunity has been saved with non-null properties
        assertEquals(10, opportunity.getRequiredQuantity());
        assertEquals(1000.00, opportunity.getExpectedRevenue());
        assertEquals(0.75, opportunity.getProbability());
        assertNotNull(opportunity.getExpectedClosingDate());
        assertEquals("Table, Chairs", opportunity.getProducts());
        assertEquals("Qualified", opportunity.getStatus());
        assertEquals("Web", opportunity.getSource());
        assertEquals("Example Account", opportunity.getAccountName());
        assertNotNull(opportunity.getOwner());
        assertNotNull(opportunity.getAccount());
    }

    @Test
    public void saveOpportunityWithNullProperties() {
        // Create a new Opportunity object without setting any properties
        Opportunity opportunity = new Opportunity();

        // Save the Opportunity to the database
        opportunityRepository.save(opportunity);

        // Check if the Opportunity has been saved with null properties
        assertNull(opportunity.getExpectedClosingDate());
        // Check other properties as needed...
        assertNull(opportunity.getOwner());
        assertNull(opportunity.getAccount());
    }

    @Test
    public void updateOpportunityProperties() {
        // Create a new Opportunity object and save it to the database
        Opportunity opportunity = new Opportunity();
        opportunityRepository.save(opportunity);

        // Update the Opportunity properties
        opportunity.setRequiredQuantity(20);
        opportunity.setExpectedRevenue(2000.00);
        opportunity.setProbability(0.90);
        opportunity.setExpectedClosingDate(new Date());
        opportunity.setProducts("Updated Products");
        opportunity.setStatus("Updated Status");
        opportunity.setSource("Updated Source");
        opportunity.setAccountName("Updated Account Name");
        // Update other properties as needed...

        // Save the updated Opportunity to the database
        opportunityRepository.save(opportunity);

        // Retrieve the Opportunity from the database and check if properties have been updated
        Opportunity updatedOpportunity = opportunityRepository.findById(opportunity.getId()).orElse(null);
        assertNotNull(updatedOpportunity);
        assertEquals(20, updatedOpportunity.getRequiredQuantity());
        assertEquals(2000.00, updatedOpportunity.getExpectedRevenue());
        assertEquals(0.90, updatedOpportunity.getProbability());
        assertNotNull(updatedOpportunity.getExpectedClosingDate());
        assertEquals("Updated Products", updatedOpportunity.getProducts());
        assertEquals("Updated Status", updatedOpportunity.getStatus());
        assertEquals("Updated Source", updatedOpportunity.getSource());
        assertEquals("Updated Account Name", updatedOpportunity.getAccountName());
        // Check other updated properties as needed...
    }

    @Test
    public void deleteOpportunity() {
        // Create a new Opportunity object and save it to the database
        Opportunity opportunity = new Opportunity();
        opportunityRepository.save(opportunity);

        // Delete the Opportunity from the database
        opportunityRepository.delete(opportunity);

        // Try to retrieve the Opportunity from the database and expect it to be null
        Opportunity deletedOpportunity = opportunityRepository.findById(opportunity.getId()).orElse(null);
        assertNull(deletedOpportunity);
    }
}

