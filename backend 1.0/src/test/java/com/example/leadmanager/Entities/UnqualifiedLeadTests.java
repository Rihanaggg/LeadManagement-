package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.NewLead;
import com.example.leadmanager.entity.UnqualifiedLead;
import com.example.leadmanager.repository.UnqualifiedLeadRepository;

@SpringBootTest
@Transactional
public class UnqualifiedLeadTests {

    @Autowired
    private UnqualifiedLeadRepository unqualifiedLeadRepository;

    @Test
    public void saveUnqualifiedLeadWithNewLead() {
        // Create a new UnqualifiedLead object
        UnqualifiedLead unqualifiedLead = new UnqualifiedLead();
        // Create a new NewLead object and associate it with the unqualifiedLead
        NewLead newLead = new NewLead();
        unqualifiedLead.setNewLead(newLead);

        // Save the UnqualifiedLead to the database
        unqualifiedLeadRepository.save(unqualifiedLead);

        // Check if the UnqualifiedLead has been saved with a non-null newLead
        assertNotNull(unqualifiedLead.getNewLead());
    }

    @Test
    public void saveUnqualifiedLeadWithNullNewLead() {
        // Create a new UnqualifiedLead object without setting the newLead
        UnqualifiedLead unqualifiedLead = new UnqualifiedLead();

        // Save the UnqualifiedLead to the database
        unqualifiedLeadRepository.save(unqualifiedLead);

        // Check if the UnqualifiedLead has been saved with a null newLead
        assertNull(unqualifiedLead.getNewLead());
    }

    @Test
    public void updateUnqualifiedLeadNewLead() {
        // Create a new UnqualifiedLead object and save it to the database
        UnqualifiedLead unqualifiedLead = new UnqualifiedLead();
        unqualifiedLeadRepository.save(unqualifiedLead);

        // Create a new NewLead object and associate it with the unqualifiedLead
        NewLead newLead = new NewLead();
        unqualifiedLead.setNewLead(newLead);

        // Save the updated UnqualifiedLead to the database
        unqualifiedLeadRepository.save(unqualifiedLead);

        // Retrieve the UnqualifiedLead from the database and check if newLead has been updated
        UnqualifiedLead updatedUnqualifiedLead = unqualifiedLeadRepository.findById(unqualifiedLead.getId()).orElse(null);
        assertNotNull(updatedUnqualifiedLead);
        assertNotNull(updatedUnqualifiedLead.getNewLead());
    }

    @Test
    public void deleteUnqualifiedLead() {
        // Create a new UnqualifiedLead object and save it to the database
        UnqualifiedLead unqualifiedLead = new UnqualifiedLead();
        unqualifiedLeadRepository.save(unqualifiedLead);

        // Delete the UnqualifiedLead from the database
        unqualifiedLeadRepository.delete(unqualifiedLead);

        // Try to retrieve the UnqualifiedLead from the database and expect it to be null
        UnqualifiedLead deletedUnqualifiedLead = unqualifiedLeadRepository.findById(unqualifiedLead.getId()).orElse(null);
        assertNull(deletedUnqualifiedLead);
    }
}

