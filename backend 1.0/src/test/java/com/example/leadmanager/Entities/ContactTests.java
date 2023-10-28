package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.Contact;
import com.example.leadmanager.repository.ContactRepository;

@SpringBootTest
@Transactional
public class ContactTests {

    @Autowired
    private ContactRepository contactRepository;

    // @Test
    // public void saveContactWithAllProperties() {
    //     // Create a new Contact object with all properties set
    //     Contact contact = new Contact();
    //     contact.setName("John Doe");
    //     // Set other properties as needed...

    //     // Associate the contact with an account
    //     Account account = new Account();
    //     contact.setAccount(account);

    //     // Save the Contact to the database
    //     contactRepository.save(contact);

    //     // Check if the Contact has been saved with non-null properties
    //     assertNotNull(contact.getName());
    //     // Check other properties as needed...
    //     assertNotNull(contact.getAccount());
    // }

    @Test
    public void saveContactWithNullProperties() {
        // Create a new Contact object without setting any properties
        Contact contact = new Contact();

        // Save the Contact to the database
        contactRepository.save(contact);

        // Check if the Contact has been saved with null properties
        assertNull(contact.getName());
        // Check other properties as needed...
        assertNull(contact.getAccount());
    }

    @Test
    public void updateContactProperties() {
        // Create a new Contact object and save it to the database
        Contact contact = new Contact();
        contactRepository.save(contact);

        // Update the Contact properties
        contact.setName("Updated Name");
        // Update other properties as needed...

        // Save the updated Contact to the database
        contactRepository.save(contact);

        // Retrieve the Contact from the database and check if properties have been updated
        Contact updatedContact = contactRepository.findById(contact.getContact_id()).orElse(null);
        assertNotNull(updatedContact);
        assertEquals("Updated Name", updatedContact.getName());
        // Check other updated properties as needed...
    }

    @Test
    public void deleteContact() {
        // Create a new Contact object and save it to the database
        Contact contact = new Contact();
        contactRepository.save(contact);

        // Delete the Contact from the database
        contactRepository.delete(contact);

        // Try to retrieve the Contact from the database and expect it to be null
        Contact deletedContact = contactRepository.findById(contact.getContact_id()).orElse(null);
        assertNull(deletedContact);
    }

    @Test
    public void saveContactWithAllProperties() {
        // Create a new Contact object with all properties set
        Contact contact = new Contact();
        contact.setEmail("john.doe@example.com");
        contact.setPhone("1234567890");
        contact.setJobTitle("Manager");
        contact.setAccountName("Example Account");
        contact.setLeadSource("Web");

        // Save the Contact to the database
        contactRepository.save(contact);

        // Retrieve the Contact from the database and check if properties are correct
        Contact retrievedContact = contactRepository.findById(contact.getContact_id()).orElse(null);
        assertNotNull(retrievedContact);

        assertEquals("john.doe@example.com", retrievedContact.getEmail());
        assertEquals("1234567890", retrievedContact.getPhone());
        assertEquals("Manager", retrievedContact.getJobTitle());
        assertEquals("Example Account", retrievedContact.getAccountName());
        assertEquals("Web", retrievedContact.getLeadSource());
    }

    // @Test
    // public void saveContactWithInvalidEmail() {
    //     // Create a new Contact object with an invalid email
    //     Contact contact = new Contact();
    //     contact.setEmail("invalid-email");

    //     // Attempt to save the Contact and expect a ConstraintViolationException
    //     assertThrows(ConstraintViolationException.class, () -> contactRepository.save(contact));
    // }

    // @Test
    // public void saveContactWithInvalidPhone() {
    //     // Create a new Contact object with an invalid phone number
    //     Contact contact = new Contact();
    //     contact.setPhone("12345678901");

    //     // Attempt to save the Contact and expect a ConstraintViolationException
    //     assertThrows(ConstraintViolationException.class, () -> contactRepository.save(contact));
    // }
}

