package com.example.leadmanager.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leadmanager.dto.ContactFormDTO;
import com.example.leadmanager.entity.Contact;
import com.example.leadmanager.exception.ContactNotFoundException;
import com.example.leadmanager.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long contactId) {
        return contactRepository.findById(contactId);
    }

    public Contact createContact(ContactFormDTO contactFormDTO) {
        Contact contact = new Contact();
        // Set properties from contactFormDTO
        contact.setName(contactFormDTO.getName());
        contact.setEmail(contactFormDTO.getEmail());
        contact.setPhone(contactFormDTO.getPhone());
        contact.setJobTitle(contactFormDTO.getJobTitle());
        contact.setAccountName(contactFormDTO.getAccountName());
        contact.setLeadSource(contactFormDTO.getLeadSource());
        return contactRepository.save(contact);
    }

    public void deleteContactById(Long contactId) {
        contactRepository.deleteById(contactId);
    }

    public Contact updateContact(Long contactId, ContactFormDTO updatedFormDTO) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);

        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            contact.setName(updatedFormDTO.getName());
            contact.setEmail(updatedFormDTO.getEmail());
            contact.setPhone(updatedFormDTO.getPhone());
            contact.setJobTitle(updatedFormDTO.getJobTitle());
            contact.setAccountName(updatedFormDTO.getAccountName());
            contact.setLeadSource(updatedFormDTO.getLeadSource());

            return contactRepository.save(contact);
        }

        throw new ContactNotFoundException("Contact with ID " + contactId + " not found");
    }

    public Contact updateContactByAttribute(Long contactId, Map<String, Object> updatedAttributes) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);

        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();

            updatedAttributes.forEach((attribute, value) -> {
                switch (attribute) {
                    case "name":
                        contact.setName((String) value);
                        break;
                    case "email":
                        contact.setEmail((String) value);
                        break;
                    case "phone":
                        contact.setPhone((String) value);
                        break;
                    case "jobTitle":
                        contact.setJobTitle((String) value);
                        break;
                    case "accountName":
                        contact.setAccountName((String) value);
                        break;
                    case "leadSource":
                        contact.setLeadSource((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid attribute: " + attribute);
                }
            });

            return contactRepository.save(contact);
        }

        throw new ContactNotFoundException("Contact with ID " + contactId + " not found");
    }

    public List<Contact> searchContactsByName(String name) {
        return contactRepository.findByNameContaining(name);
    }

    public List<Contact> searchContactsByEmail(String email) {
        return contactRepository.findByEmailContaining(email);
    }

    public List<Contact> searchContactsByPhone(String phone) {
        return contactRepository.findByPhoneContaining(phone);
    }
}

