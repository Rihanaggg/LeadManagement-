package com.example.leadmanager.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.leadmanager.dto.ContactFormDTO;
import com.example.leadmanager.entity.Contact;
import com.example.leadmanager.repository.ContactRepository;
import com.example.leadmanager.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{contactId}")
    public Optional<Contact> getContactById(@PathVariable Long contactId) {
        return contactService.getContactById(contactId);
    }

    @DeleteMapping("/delete/{contactId}")
    public void deleteContactById(@PathVariable Long contactId) {
        contactService.deleteContactById(contactId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContact(@RequestBody ContactFormDTO contactFormDTO) {
        try {
            Contact contact = contactService.createContact(contactFormDTO);
            return new ResponseEntity<>("Contact created successfully with ID: " + contact.getContact_id(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating contact: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long contactId, @RequestBody ContactFormDTO updatedFormDTO) {
        Contact updatedContact = contactService.updateContact(contactId, updatedFormDTO);
        return ResponseEntity.ok(updatedContact);
    }

    @PatchMapping("/updatebyid/{contactId}")
    public ResponseEntity<Contact> updateContactAttributes(@PathVariable Long contactId, @RequestBody Map<String, Object> updatedAttributes) {
        Contact updatedContact = contactService.updateContactByAttribute(contactId, updatedAttributes);
        return ResponseEntity.ok(updatedContact);
    }

    @GetMapping("/search/name")
    public List<Contact> searchContactsByName(@RequestParam String name) {
        return contactService.searchContactsByName(name);
    }

    @GetMapping("/search/email")
    public List<Contact> searchContactsByEmail(@RequestParam String email) {
        return contactService.searchContactsByEmail(email);
    }

    @GetMapping("/search/phone")
    public List<Contact> searchContactsByPhone(@RequestParam String phone) {
        return contactService.searchContactsByPhone(phone);
    }

    @GetMapping("/search")
    public List<Contact> searchContacts(
            @RequestParam String searchType,
            @RequestParam String query
    ) {
        switch (searchType) {
            case "name":
                return contactService.searchContactsByName(query);
            case "email":
                return contactService.searchContactsByEmail(query);
            case "phone":
                return contactService.searchContactsByPhone(query);
            default:
                throw new IllegalArgumentException("Invalid search type: " + searchType);
        }
    }
}

