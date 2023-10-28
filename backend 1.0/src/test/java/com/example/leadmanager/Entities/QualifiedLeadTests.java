package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.NewLead;
import com.example.leadmanager.entity.QualifiedLead;
import com.example.leadmanager.repository.QualifiedLeadRepository;

@SpringBootTest
@Transactional
public class QualifiedLeadTests {

    @Autowired
    private QualifiedLeadRepository qualifiedLeadRepository;

    @Test
    public void saveQualifiedLeadWithNewLead() {
        // Create a new QualifiedLead object
        QualifiedLead qualifiedLead = new QualifiedLead();
        // Create a new NewLead object and associate it with the qualifiedLead
        NewLead newLead = new NewLead();
        qualifiedLead.setNewLead(newLead);

        // Save the QualifiedLead to the database
        qualifiedLeadRepository.save(qualifiedLead);

        // Check if the QualifiedLead has been saved with a non-null newLead
        assertNotNull(qualifiedLead.getNewLead());
    }

    @Test
    public void saveQualifiedLeadWithNullNewLead() {
        // Create a new QualifiedLead object without setting the newLead
        QualifiedLead qualifiedLead = new QualifiedLead();

        // Save the QualifiedLead to the database
        qualifiedLeadRepository.save(qualifiedLead);

        // Check if the QualifiedLead has been saved with a null newLead
        assertNull(qualifiedLead.getNewLead());
    }

    @Test
    public void updateQualifiedLeadNewLead() {
        // Create a new QualifiedLead object and save it to the database
        QualifiedLead qualifiedLead = new QualifiedLead();
        qualifiedLeadRepository.save(qualifiedLead);

        // Create a new NewLead object and associate it with the qualifiedLead
        NewLead newLead = new NewLead();
        qualifiedLead.setNewLead(newLead);

        // Save the updated QualifiedLead to the database
        qualifiedLeadRepository.save(qualifiedLead);

        // Retrieve the QualifiedLead from the database and check if newLead has been updated
        QualifiedLead updatedQualifiedLead = qualifiedLeadRepository.findById(qualifiedLead.getId()).orElse(null);
        assertNotNull(updatedQualifiedLead);
        assertNotNull(updatedQualifiedLead.getNewLead());
    }

    @Test
    public void deleteQualifiedLead() {
        // Create a new QualifiedLead object and save it to the database
        QualifiedLead qualifiedLead = new QualifiedLead();
        qualifiedLeadRepository.save(qualifiedLead);

        // Delete the QualifiedLead from the database
        qualifiedLeadRepository.delete(qualifiedLead);

        // Try to retrieve the QualifiedLead from the database and expect it to be null
        QualifiedLead deletedQualifiedLead = qualifiedLeadRepository.findById(qualifiedLead.getId()).orElse(null);
        assertNull(deletedQualifiedLead);
    }
}

