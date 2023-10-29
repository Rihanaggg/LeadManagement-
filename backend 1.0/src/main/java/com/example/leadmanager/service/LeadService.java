package com.example.leadmanager.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.leadmanager.dto.FirstFormDTO;
import com.example.leadmanager.entity.Account;
import com.example.leadmanager.entity.Contact;
import com.example.leadmanager.entity.Lead;
import com.example.leadmanager.entity.NewLead;
import com.example.leadmanager.entity.Opportunity;
import com.example.leadmanager.entity.QualifiedLead;
import com.example.leadmanager.entity.UnqualifiedLead;
import com.example.leadmanager.entity.User;
import com.example.leadmanager.exception.LeadNotFoundException;
import com.example.leadmanager.repository.AccountRepository;
import com.example.leadmanager.repository.ContactRepository;
import com.example.leadmanager.repository.LeadRepository;
import com.example.leadmanager.repository.NewLeadRepository;
import com.example.leadmanager.repository.OpportunityRepository;
import com.example.leadmanager.repository.QualifiedLeadRepository;
import com.example.leadmanager.repository.UnqualifiedLeadRepository;
import com.example.leadmanager.security.UserService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;


    @Autowired
    private NewLeadRepository newLeadRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private QualifiedLeadRepository qualifiedLeadRepository;

    @Autowired
    private UnqualifiedLeadRepository unqualifiedLeadRepository;

    @Autowired
    private UserService userService;

    //get all leads
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }
    
    // Get lead by ID
    public Optional<Lead> getLeadById(Long leadId) {
        return leadRepository.findById(leadId);
    }

     public Lead createLead(FirstFormDTO firstFormDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> loggedInUser = userService.getByName(username);
        
        NewLead newLead = new NewLead();

        newLead.setName(firstFormDTO.getName());
        newLead.setCompanyName(firstFormDTO.getCompanyName());
        newLead.setEmail(firstFormDTO.getEmail());
        newLead.setPhone(firstFormDTO.getPhone());
        newLead.setJobTitle(firstFormDTO.getJobTitle());
        newLead.setAddress(firstFormDTO.getAddress());
        newLead.setState(firstFormDTO.getState());
        newLead.setRegion(firstFormDTO.getRegion());
        newLead.setWebsite(firstFormDTO.getWebsite());
        newLead.setTypeOfBusiness(firstFormDTO.getTypeOfBusiness());
        newLead.setRequiredQuantity(firstFormDTO.getRequiredQuantity());
        newLead.setExpectedRevenue(firstFormDTO.getExpectedRevenue());
        newLead.setProbability(firstFormDTO.getProbability());
        newLead.setProducts(firstFormDTO.getProducts());
        newLead.setStatus(firstFormDTO.getStatus());
        newLead.setSource(firstFormDTO.getSource());
        newLead.setCreatedDate(firstFormDTO.getCreatedDate());
if(loggedInUser.isPresent()){
    newLead.setOwner(loggedInUser.get());
}
        newLeadRepository.save(newLead);

         // Create a new Lead and associate it with the saved Account
        Lead lead = new Lead();
        lead.setNewLead(newLead);

        return leadRepository.save(lead);
    }

    
    public void deleteLeadById(Long leadId) {
        leadRepository.deleteById(leadId);
    }

    //update entire lead
    public Lead updateLead(Long leadId, FirstFormDTO updatedFormDTO) {
        Optional<Lead> optionalLead = leadRepository.findById(leadId);

        if (optionalLead.isPresent()) {
            Lead lead = optionalLead.get();

            // Update the lead's properties with the values from the updatedFormDTO
            lead.getNewLead().setName(updatedFormDTO.getName());
            lead.getNewLead().setCompanyName(updatedFormDTO.getCompanyName());
            lead.getNewLead().setEmail(updatedFormDTO.getEmail());
            lead.getNewLead().setPhone(updatedFormDTO.getPhone());
            lead.getNewLead().setJobTitle(updatedFormDTO.getJobTitle());
            lead.getNewLead().setAddress(updatedFormDTO.getAddress());
            lead.getNewLead().setState(updatedFormDTO.getState());
            lead.getNewLead().setRegion(updatedFormDTO.getRegion());
            lead.getNewLead().setWebsite(updatedFormDTO.getWebsite());
            lead.getNewLead().setTypeOfBusiness(updatedFormDTO.getTypeOfBusiness());
            lead.getNewLead().setRequiredQuantity(updatedFormDTO.getRequiredQuantity());
            lead.getNewLead().setExpectedRevenue(updatedFormDTO.getExpectedRevenue());
            lead.getNewLead().setProbability(updatedFormDTO.getProbability());
            lead.getNewLead().setProducts(updatedFormDTO.getProducts());
            lead.getNewLead().setStatus(updatedFormDTO.getStatus());
            lead.getNewLead().setSource(updatedFormDTO.getSource());
            lead.getNewLead().setCreatedDate(updatedFormDTO.getCreatedDate());

            return leadRepository.save(lead);
        }

        // Handle case where lead with leadId is not found
        throw new LeadNotFoundException("Lead with ID " + leadId + " not found");
    }
   
    // public Lead updateLeadByAttribute(Long leadId,FirstFormDTO updatedAttributes) {
    //     Optional<Lead> optionalLead = leadRepository.findById(leadId);

    //     if (optionalLead.isPresent()) {
    //         Lead lead = optionalLead.get();
    //         NewLead newLead = lead.getNewLead();

    //         // Update the specified attributes
    //         updatedAttributes.forEach((attribute, value) -> {
    //             switch (attribute) {
    //                 case "name":
    //                     newLead.setName((String) value);
    //                     break;
    //                 case "companyName":
    //                     newLead.setCompanyName((String) value);
    //                     break;
    //                 case "email":
    //                     newLead.setEmail((String) value);
    //                     break;
    //                 case "phone":
    //                     newLead.setPhone((String) value);
    //                     break;
    //                 case "jobTitle":
    //                     newLead.setJobTitle((String) value);
    //                     break;
    //                 case "address":
    //                     newLead.setAddress((String) value);
    //                     break;
    //                 case "state":
    //                     newLead.setState((String) value);
    //                     break;
    //                 case "region":
    //                     newLead.setRegion((String) value);
    //                     break;
    //                 case "website":
    //                     newLead.setWebsite((String) value);
    //                     break;
    //                 case "typeOfBusiness":
    //                     newLead.setTypeOfBusiness((String) value);
    //                     break;
    //                 case "requiredQuantity":
    //                     newLead.setRequiredQuantity((Integer) value);
    //                     break;
    //                 case "expectedRevenue":
    //                     newLead.setExpectedRevenue((Double) value);
    //                     break;
    //                 case "probability":
    //                     newLead.setProbability((Double) value);
    //                     break;
    //                 case "products":
    //                     newLead.setProducts((String) value);
    //                     break;
    //                 case "status":
    //                     newLead.setStatus((String) value);
    //                     break;
    //                 case "source":
    //                     newLead.setSource((String) value);
    //                     break;
    //                 default:
    //                     // Handle unknown attribute
    //                     throw new IllegalArgumentException("Invalid attribute: " + attribute);
    //             }
    //         });

    //         return leadRepository.save(lead);
    //     }

    //     // Handle case where lead with leadId is not found
    //     throw new LeadNotFoundException("Lead with ID " + leadId + " not found");
    // }

    public Lead updateLeadByAttribute(Long leadId, FirstFormDTO updatedAttributes) {
    Optional<Lead> optionalLead = leadRepository.findById(leadId);

    if (optionalLead.isPresent()) {
        Lead lead = optionalLead.get();
        NewLead newLead = lead.getNewLead();

        // Update the specified attributes using FirstFormDTO with null checks
        if (updatedAttributes.getName() != null) {
            newLead.setName(updatedAttributes.getName());
        }
        if (updatedAttributes.getCompanyName() != null) {
            newLead.setCompanyName(updatedAttributes.getCompanyName());
        }
        if (updatedAttributes.getEmail() != null) {
            newLead.setEmail(updatedAttributes.getEmail());
        }
        if (updatedAttributes.getPhone() != null) {
            newLead.setPhone(updatedAttributes.getPhone());
        }
        if (updatedAttributes.getJobTitle() != null) {
            newLead.setJobTitle(updatedAttributes.getJobTitle());
        }
        if (updatedAttributes.getAddress() != null) {
            newLead.setAddress(updatedAttributes.getAddress());
        }
        if (updatedAttributes.getState() != null) {
            newLead.setState(updatedAttributes.getState());
        }
        if (updatedAttributes.getRegion() != null) {
            newLead.setRegion(updatedAttributes.getRegion());
        }
        if (updatedAttributes.getWebsite() != null) {
            newLead.setWebsite(updatedAttributes.getWebsite());
        }
        if (updatedAttributes.getTypeOfBusiness() != null) {
            newLead.setTypeOfBusiness(updatedAttributes.getTypeOfBusiness());
        }
        if (updatedAttributes.getRequiredQuantity() != 0) {
            newLead.setRequiredQuantity(updatedAttributes.getRequiredQuantity());
        }
        if (updatedAttributes.getExpectedRevenue() != 0) {
            newLead.setExpectedRevenue(updatedAttributes.getExpectedRevenue());
        }
        if (updatedAttributes.getProbability() != 0) {
            newLead.setProbability(updatedAttributes.getProbability());
        }
        if (updatedAttributes.getProducts() != null) {
            newLead.setProducts(updatedAttributes.getProducts());
        }
        if (updatedAttributes.getStatus() != null) {
            newLead.setStatus(updatedAttributes.getStatus());
        }
        if (updatedAttributes.getSource() != null) {
            newLead.setSource(updatedAttributes.getSource());
        }
        if (updatedAttributes.getCreatedDate() != null) {
            newLead.setCreatedDate(updatedAttributes.getCreatedDate());
        }
        return leadRepository.save(lead);
    } else {
        // Handle the case where leadId is not found
        throw new EntityNotFoundException("Lead with ID " + leadId + " not found.");
    }
}


    public List<Lead> searchLeadsByName(String name) {
        return leadRepository.searchByName(name);
    }
    
    public List<Lead> searchLeadsByCompanyName(String companyName) {
        return leadRepository.findByNewLeadCompanyNameContaining(companyName);
    }

    public List<Lead> searchLeadsByEmail(String email) {
        return leadRepository.findByNewLeadEmailContaining(email);
    }

    public List<Lead> searchLeadsByState(String state) {
        return leadRepository.findByNewLeadStateContaining(state);
    }

    public List<Lead> searchLeadsByStatus(String status) {
        return leadRepository.findByNewLeadStatusContaining(status);
    }


    public void updateLeadStatus(Long leadId, String newStatus) {
        Optional<Lead> optionalLead = leadRepository.findById(leadId);

        if (optionalLead.isPresent()) {
            Lead lead = optionalLead.get();
            NewLead newLead = lead.getNewLead();

            // Update the lead's status
            newLead.setStatus(newStatus);
            leadRepository.save(lead);

            if (newStatus.equals("Won")) {
                // Create Account, Contact, and Opportunity entities
                newLead.setStatus(newStatus);
                leadRepository.save(lead);

                Account account = new Account();
                account.setCompanyName(newLead.getCompanyName());
                account.setAddress(newLead.getAddress());
                account.setState(newLead.getState());
                account.setRegion(newLead.getRegion());
                account.setTypeOfBusiness(newLead.getTypeOfBusiness());
                account.setWebsite(newLead.getWebsite());
                account.setEmail(newLead.getEmail());
                account.setActive("Yes");
                accountRepository.save(account);


                Contact contact = new Contact();
                contact.setName(newLead.getName());
                contact.setEmail(newLead.getEmail());
                contact.setPhone(newLead.getPhone());
                contact.setJobTitle(newLead.getJobTitle());
                contact.setLeadSource(newLead.getSource());
                contact.setAccountName(newLead.getCompanyName());
                contact.setAccount(account);
                contactRepository.save(contact);

                Opportunity opportunity = new Opportunity();
                opportunity.setRequiredQuantity(newLead.getRequiredQuantity());
                opportunity.setExpectedRevenue(newLead.getExpectedRevenue());
                opportunity.setProbability(newLead.getProbability());
                opportunity.setProducts(newLead.getProducts());
                opportunity.setSource(newLead.getSource());
                opportunity.setStatus(newLead.getStatus());
                opportunity.setAccountName(newLead.getCompanyName());
                opportunity.setOwner(newLead.getOwner());
                opportunity.setExpectedClosingDate(new Date());
                opportunity.setAccount(account);
                opportunityRepository.save(opportunity);

                // Set the account, contact, and opportunity for the lead
                lead.setAccount(account);
                lead.setContact(contact);
                lead.setOpportunity(opportunity);

                // Save the entities
                
                // Move to QualifiedLead table
                QualifiedLead qualifiedLead = new QualifiedLead();
                qualifiedLead.setNewLead(newLead);

                qualifiedLeadRepository.save(qualifiedLead);
                 // Remove the lead data
                leadRepository.delete(lead);
            } else if (newStatus.equals("Lost")) {
                // Move to UnqualifiedLead table
                newLead.setStatus(newStatus);
                leadRepository.save(lead);

                UnqualifiedLead unqualifiedLead = new UnqualifiedLead();
                unqualifiedLead.setNewLead(newLead);

                unqualifiedLeadRepository.save(unqualifiedLead);
                 // Remove the lead data
                leadRepository.delete(lead);
            }
        } else {
            // Handle case where lead with leadId is not found
            throw new LeadNotFoundException("Lead with ID " + leadId + " not found");
        }
    }
}


