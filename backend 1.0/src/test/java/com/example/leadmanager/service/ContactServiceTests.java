package com.example.leadmanager.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.leadmanager.dto.ContactFormDTO;
import com.example.leadmanager.entity.Contact;
import com.example.leadmanager.repository.ContactRepository;

@SpringBootTest
public class ContactServiceTests {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @Test
    public void testGetAllContacts() {
        // Create a list of sample contacts
        List<Contact> contacts = new ArrayList<>();
        // Add sample contacts to the list

        // Mock the behavior of contactRepository.findAll()
        when(contactRepository.findAll()).thenReturn(contacts);

        // Call the method
        List<Contact> result = contactService.getAllContacts();

        // Verify that the result matches the list of sample contacts
        assertEquals(contacts, result);
    }

    @Test
    public void testGetContactById() {
        // Create a sample contact
        Long contactId = 1L;
        Contact contact = new Contact();
        contact.setContact_id(contactId);

        // Mock the behavior of contactRepository.findById()
        when(contactRepository.findById(contactId)).thenReturn(Optional.of(contact));

        // Call the method
        Optional<Contact> result = contactService.getContactById(contactId);

        // Verify that the result matches the sample contact
        assertEquals(Optional.of(contact), result);
    }

    @Test
    public void testCreateContact() {
        // Create a sample ContactFormDTO
        ContactFormDTO contactFormDTO = new ContactFormDTO();
        // Set properties in contactFormDTO

        // Create a sample Contact object
        Contact contact = new Contact();
        // Set properties in contact

        // Mock the behavior of contactRepository.save()
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);

        // Call the method
        Contact result = contactService.createContact(contactFormDTO);

        // Verify that the result matches the sample contact
        assertEquals(contact, result);
    }

    @Test
    public void testDeleteContactById() {
        // Create a sample contact
        Long contactId = 1L;

        // Call the method
        contactService.deleteContactById(contactId);

        // Verify that contactRepository.deleteById() was called once with the provided contactId
        verify(contactRepository, times(1)).deleteById(contactId);
    }

    // @Test
    // public void testUpdateContact() {
    //     // Create a sample contact
    //     Long contactId = 1L;
    //     Contact contact = new Contact();
    //     contact.setContact_id(contactId);

    //     // Create a sample ContactFormDTO with updated attributes
    //     ContactFormDTO updatedFormDTO = new ContactFormDTO();
    //     updatedFormDTO.setName("John Doe");
    //     updatedFormDTO.setEmail("john.doe@example.com");
    //     updatedFormDTO.setJobTitle("engineer");
    //     updatedFormDTO.setLeadSource("web");
    //     updatedFormDTO.setPhone("6789905634");
    //     updatedFormDTO.setAccountName("zz");
    //     // Add other attributes as needed

    //     // Mock the behavior of contactRepository.findById()
    //     when(contactRepository.findById(contactId)).thenReturn(Optional.of(contact));

    //     // Call the method
    //     Contact updatedContact = contactService.updateContact(contactId, updatedFormDTO);

    //     // Verify that contactRepository.save() was called once
    //     verify(contactRepository, times(1)).save(contact);

    //     // Verify that the Contact object was updated correctly
    //     assertEquals(updatedFormDTO.getName(), updatedContact.getName());
    //     assertEquals(updatedFormDTO.getEmail(), updatedContact.getEmail());
    //     assertEquals(updatedFormDTO.getJobTitle(), updatedContact.getJobTitle());
    //     assertEquals(updatedFormDTO.getAccountName(), updatedContact.getAccountName());
    //     assertEquals(updatedFormDTO.getLeadSource(), updatedContact.getLeadSource());
    //     assertEquals(updatedFormDTO.getPhone(), updatedContact.getPhone());
    //     // Add other assertions for attributes
    // }

    // Add more test cases as needed for different scenarios

    @Test
    void testUpdateContact() {
        // Arrange
        Long contactId = 1L;
        ContactFormDTO updatedFormDTO = new ContactFormDTO();
        updatedFormDTO.setName("Updated Name");
        updatedFormDTO.setEmail("updated@example.com");
        updatedFormDTO.setPhone("1234567890");
        updatedFormDTO.setJobTitle("Updated Job Title");
        updatedFormDTO.setAccountName("Updated Account");
        updatedFormDTO.setLeadSource("Web");

        Contact existingContact = new Contact();
        existingContact.setContact_id(contactId);
        existingContact.setName("Original Name");
        existingContact.setEmail("original@example.com");
        existingContact.setPhone("9876543210");
        existingContact.setJobTitle("Original Job Title");
        existingContact.setAccountName("Original Account");
        existingContact.setLeadSource("Phone");

        when(contactRepository.findById(contactId)).thenReturn(Optional.of(existingContact));
        when(contactRepository.save(any(Contact.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Contact updatedContact = contactService.updateContact(contactId, updatedFormDTO);

        // Assert
        assertNotNull(updatedContact);
        assertEquals(contactId, updatedContact.getContact_id());
        assertEquals(updatedFormDTO.getName(), updatedContact.getName());
        assertEquals(updatedFormDTO.getEmail(), updatedContact.getEmail());
        assertEquals(updatedFormDTO.getPhone(), updatedContact.getPhone());
        assertEquals(updatedFormDTO.getJobTitle(), updatedContact.getJobTitle());
        assertEquals(updatedFormDTO.getAccountName(), updatedContact.getAccountName());
        assertEquals(updatedFormDTO.getLeadSource(), updatedContact.getLeadSource());

        // Verify that findById and save methods were called
        verify(contactRepository, times(1)).findById(contactId);

        ArgumentCaptor<Contact> contactArgumentCaptor = ArgumentCaptor.forClass(Contact.class);
        verify(contactRepository, times(1)).save(contactArgumentCaptor.capture());

        Contact capturedContact = contactArgumentCaptor.getValue();
        assertNotNull(capturedContact);
        assertEquals(contactId, capturedContact.getContact_id());
        assertEquals(updatedFormDTO.getName(), capturedContact.getName());
        assertEquals(updatedFormDTO.getEmail(), capturedContact.getEmail());
        assertEquals(updatedFormDTO.getPhone(), capturedContact.getPhone());
        assertEquals(updatedFormDTO.getJobTitle(), capturedContact.getJobTitle());
        assertEquals(updatedFormDTO.getAccountName(), capturedContact.getAccountName());
        assertEquals(updatedFormDTO.getLeadSource(), capturedContact.getLeadSource());
    }

    @Test
    void testSearchContactsByName() {
        // Arrange
        String name = "John Doe";

        // Create sample contacts
        Contact contact1 = new Contact();
        contact1.setContact_id(1L);
        contact1.setName("John Doe");
        contact1.setEmail("john.doe@example.com");

        Contact contact2 = new Contact();
        contact2.setContact_id(2L);
        contact2.setName("Jane Doe");
        contact2.setEmail("jane.doe@example.com");

        List<Contact> sampleContacts = new ArrayList<>();
        sampleContacts.add(contact1);
        sampleContacts.add(contact2);

        when(contactRepository.findByNameContaining(name)).thenReturn(sampleContacts);

        // Act
        List<Contact> foundContacts = contactService.searchContactsByName(name);

        // Assert
        assertNotNull(foundContacts);
        assertEquals(2, foundContacts.size());

        Contact foundContact1 = foundContacts.get(0);
        assertEquals(1L, foundContact1.getContact_id());
        assertEquals("John Doe", foundContact1.getName());
        assertEquals("john.doe@example.com", foundContact1.getEmail());

        Contact foundContact2 = foundContacts.get(1);
        assertEquals(2L, foundContact2.getContact_id());
        assertEquals("Jane Doe", foundContact2.getName());
        assertEquals("jane.doe@example.com", foundContact2.getEmail());

        // Verify that findByNameContaining method was called
        verify(contactRepository, times(1)).findByNameContaining(name);
    }


    @Test
    void testSearchContactsByEmail() {
        // Arrange
        String email = "john.doe@example.com";

        // Create sample contacts
        Contact contact1 = new Contact();
        contact1.setContact_id(1L);
        contact1.setName("John Doe");
        contact1.setEmail("john.doe@example.com");

        List<Contact> sampleContacts = new ArrayList<>();
        sampleContacts.add(contact1);

        when(contactRepository.findByEmailContaining(email)).thenReturn(sampleContacts);

        // Act
        List<Contact> foundContacts = contactService.searchContactsByEmail(email);

        // Assert
        assertNotNull(foundContacts);
        assertEquals(1, foundContacts.size());

        Contact foundContact = foundContacts.get(0);
        assertEquals(1L, foundContact.getContact_id());
        assertEquals("John Doe", foundContact.getName());
        assertEquals("john.doe@example.com", foundContact.getEmail());

        // Verify that findByEmailContaining method was called
        verify(contactRepository, times(1)).findByEmailContaining(email);
    }

    @Test
    void testSearchContactsByPhone() {
        // Arrange
        String phone = "555-555-5555";

        // Create sample contacts
        Contact contact1 = new Contact();
        contact1.setContact_id(1L);
        contact1.setName("John Doe");
        contact1.setPhone("555-555-5555");

        List<Contact> sampleContacts = new ArrayList<>();
        sampleContacts.add(contact1);

        when(contactRepository.findByPhoneContaining(phone)).thenReturn(sampleContacts);

        // Act
        List<Contact> foundContacts = contactService.searchContactsByPhone(phone);

        // Assert
        assertNotNull(foundContacts);
        assertEquals(1, foundContacts.size());

        Contact foundContact = foundContacts.get(0);
        assertEquals(1L, foundContact.getContact_id());
        assertEquals("John Doe", foundContact.getName());
        assertEquals("555-555-5555", foundContact.getPhone());

        // Verify that findByPhoneContaining method was called
        verify(contactRepository, times(1)).findByPhoneContaining(phone);
    }


    @Test
    void testUpdateContactByAttribute() {
        // Arrange
        Long contactId = 1L;
        ContactFormDTO updatedAttributes = new ContactFormDTO();
        updatedAttributes.setName("Updated Name");
        updatedAttributes.setEmail("updated.email@example.com");
        updatedAttributes.setPhone("555-555-5555");
        updatedAttributes.setJobTitle("Updated Job Title");
        updatedAttributes.setAccountName("Updated Account");
        updatedAttributes.setLeadSource("Updated Lead Source");

        Contact existingContact = new Contact();
        existingContact.setContact_id(contactId);
        existingContact.setName("Old Name");
        existingContact.setEmail("old.email@example.com");
        existingContact.setPhone("123-456-7890");
        existingContact.setJobTitle("Old Job Title");
        existingContact.setAccountName("Old Account");
        existingContact.setLeadSource("Old Lead Source");

        Optional<Contact> optionalContact = Optional.of(existingContact);

        when(contactRepository.findById(contactId)).thenReturn(optionalContact);
        when(contactRepository.save(any())).thenReturn(existingContact);

        // Act
        Contact updatedContact = contactService.updateContactByAttribute(contactId, updatedAttributes);

        // Assert
        assertNotNull(updatedContact);
        assertEquals(contactId, updatedContact.getContact_id());
        assertEquals("Updated Name", updatedContact.getName());
        assertEquals("updated.email@example.com", updatedContact.getEmail());
        assertEquals("555-555-5555", updatedContact.getPhone());
        assertEquals("Updated Job Title", updatedContact.getJobTitle());
        assertEquals("Updated Account", updatedContact.getAccountName());
        assertEquals("Updated Lead Source", updatedContact.getLeadSource());

        // Verify that findById and save methods were called
        verify(contactRepository, times(1)).findById(contactId);
        verify(contactRepository, times(1)).save(existingContact);
    }
}



