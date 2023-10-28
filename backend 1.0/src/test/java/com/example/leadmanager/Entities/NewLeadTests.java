package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.NewLead;
import com.example.leadmanager.entity.User;
import com.example.leadmanager.repository.NewLeadRepository;

import jakarta.validation.ConstraintViolationException;

@SpringBootTest
@Transactional
public class NewLeadTests {

    @Autowired
    private NewLeadRepository newLeadRepository;

    @Test
    public void saveNewLeadWithAllProperties() {
        // Create a new NewLead object with all properties set
        NewLead newLead = new NewLead();
        newLead.setName("John Doe");
        newLead.setCompanyName("Example Company");
        newLead.setEmail("john.doe@example.com");
        // Set other properties as needed...

        // Set the owner
        User owner = new User();
        newLead.setOwner(owner);

        // Save the NewLead to the database
        newLeadRepository.save(newLead);

        // Check if the NewLead has been saved with non-null properties
        assertNotNull(newLead.getName());
        // Check other properties as needed...
        assertNotNull(newLead.getOwner());
    }

    @Test
    public void saveNewLeadWithNullProperties() {
        // Create a new NewLead object without setting any properties
        NewLead newLead = new NewLead();
       
        // Save the NewLead to the database
        newLeadRepository.save(newLead);

        // Check if the NewLead has been saved with null properties
        assertNull(newLead.getName());
        // Check other properties as needed...
        assertNull(newLead.getOwner());
    }

    @Test
    public void updateNewLeadProperties() {
        // Create a new NewLead object and save it to the database
        NewLead newLead = new NewLead();
        newLeadRepository.save(newLead);

        // Update the NewLead properties
        newLead.setName("Updated Name");
        newLead.setCompanyName("Updated Company Name");
        newLead.setEmail("updated.email@example.com");
        // Update other properties as needed...

        // Save the updated NewLead to the database
        newLeadRepository.save(newLead);

        // Retrieve the NewLead from the database and check if properties have been updated
        NewLead updatedNewLead = newLeadRepository.findById(newLead.getNewleadid()).orElse(null);
        assertNotNull(updatedNewLead);
        assertEquals("Updated Name", updatedNewLead.getName());
        assertEquals("Updated Company Name", updatedNewLead.getCompanyName());
        assertEquals("updated.email@example.com", updatedNewLead.getEmail());
        // Check other updated properties as needed...
    }

    @Test
    public void deleteNewLead() {
        // Create a new NewLead object and save it to the database
        NewLead newLead = new NewLead();
        newLeadRepository.save(newLead);

        // Delete the NewLead from the database
        newLeadRepository.delete(newLead);

        // Try to retrieve the NewLead from the database and expect it to be null
        NewLead deletedNewLead = newLeadRepository.findById(newLead.getNewleadid()).orElse(null);
        assertNull(deletedNewLead);
    }

    @Test
    public void saveNewLeadWithAllPropertiesWithinLimits() {
        // Create a new NewLead object with properties within limits
        NewLead newLead = new NewLead();
        newLead.setPhone("1234567890");
        newLead.setJobTitle("Manager");
        newLead.setAddress("123 Main St");
        newLead.setState("California");
        newLead.setRegion("West");
        newLead.setWebsite("example.com");
        newLead.setTypeOfBusiness("Finance");
        newLead.setRequiredQuantity(5);
        newLead.setExpectedRevenue(1000.00);
        newLead.setProbability(0.75);
        newLead.setProducts("Accounting software,Cloud services");
        newLead.setStatus("qualified");
        newLead.setSource("web");
        newLead.setCreatedDate(new Date());

        // Save the NewLead to the database
        newLeadRepository.save(newLead);

        // Retrieve the NewLead from the database and check if properties are correct
        NewLead retrievedNewLead = newLeadRepository.findById(newLead.getNewleadid()).orElse(null);
        assertNotNull(retrievedNewLead);

        assertEquals("1234567890", retrievedNewLead.getPhone());
        assertEquals("Manager", retrievedNewLead.getJobTitle());
        assertEquals("123 Main St", retrievedNewLead.getAddress());
        assertEquals("California", retrievedNewLead.getState());
        assertEquals("West", retrievedNewLead.getRegion());
        assertEquals("example.com", retrievedNewLead.getWebsite());
        assertEquals("Finance", retrievedNewLead.getTypeOfBusiness());
        assertEquals(5, retrievedNewLead.getRequiredQuantity());
        assertEquals(1000.00, retrievedNewLead.getExpectedRevenue());
        assertEquals(0.75, retrievedNewLead.getProbability());
        assertEquals("Accounting software,Cloud services", retrievedNewLead.getProducts());
        assertEquals("qualified", retrievedNewLead.getStatus());
        assertEquals("web", retrievedNewLead.getSource());
        assertNotNull(retrievedNewLead.getCreatedDate());
    }

    @Test
    public void saveNewLeadWithInvalidPhone() {
        // Create a new NewLead object with an invalid phone number (exceeds max size)
        NewLead newLead = new NewLead();
        newLead.setPhone("12345678901");

        // Attempt to save the NewLead and expect a ConstraintViolationException
        assertThrows(ConstraintViolationException.class, () -> newLeadRepository.save(newLead));
    }
}

