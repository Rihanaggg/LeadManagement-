package com.example.leadmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leadmanager.dto.OpportunityFormDTO;
import com.example.leadmanager.entity.Account;
import com.example.leadmanager.entity.Opportunity;
import com.example.leadmanager.exception.OpportunityNotFoundException;
import com.example.leadmanager.repository.OpportunityRepository;

@Service
public class OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    // Get all opportunities
    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    // Get opportunity by ID
    public Optional<Opportunity> getOpportunityById(Long opportunityId) {
        return opportunityRepository.findById(opportunityId);
    }

    // Create a new opportunity
    public Opportunity createOpportunity(OpportunityFormDTO opportunityFormDTO, Account account) {
        Opportunity opportunity = new Opportunity();

        // Set properties from opportunityFormDTO
        opportunity.setRequiredQuantity(opportunityFormDTO.getRequiredQuantity());
        opportunity.setExpectedRevenue(opportunityFormDTO.getExpectedRevenue());
        opportunity.setProbability(opportunityFormDTO.getProbability());
       // opportunity.setPriority(opportunityFormDTO.getPriority());
        opportunity.setExpectedClosingDate(opportunityFormDTO.getExpectedClosingDate());
        opportunity.setProducts(opportunityFormDTO.getProducts());
        opportunity.setStatus(opportunityFormDTO.getStatus());
        opportunity.setSource(opportunityFormDTO.getSource());
        opportunity.setAccountName(opportunityFormDTO.getAccountName());
        

        return opportunityRepository.save(opportunity);
    }

    // Delete opportunity by ID
    public void deleteOpportunityById(Long opportunityId) {
        opportunityRepository.deleteById(opportunityId);
    }

    // Update entire opportunity
    public Opportunity updateOpportunity(Long opportunityId, OpportunityFormDTO updatedFormDTO) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);

        if (optionalOpportunity.isPresent()) {
            Opportunity opportunity = optionalOpportunity.get();

            // Update the opportunity's properties with the values from the updatedFormDTO
            opportunity.setRequiredQuantity(updatedFormDTO.getRequiredQuantity());
            opportunity.setExpectedRevenue(updatedFormDTO.getExpectedRevenue());
            opportunity.setProbability(updatedFormDTO.getProbability());
            //opportunity.setPriority(updatedFormDTO.getPriority());
            opportunity.setExpectedClosingDate(updatedFormDTO.getExpectedClosingDate());
            opportunity.setProducts(updatedFormDTO.getProducts());
            opportunity.setStatus(updatedFormDTO.getStatus());
            opportunity.setSource(updatedFormDTO.getSource());
            opportunity.setAccountName(updatedFormDTO.getAccountName());

            return opportunityRepository.save(opportunity);
        }

        // Handle case where opportunity with opportunityId is not found
        throw new OpportunityNotFoundException("Opportunity with ID " + opportunityId + " not found");
    }

    // Search opportunities by status
    public List<Opportunity> searchOpportunitiesByStatus(String status) {
        return opportunityRepository.findByStatus(status);
    }

    public Opportunity updateOpportunityByAttribute(Long opportunityId, OpportunityFormDTO updatedAttributes) {
        Optional<Opportunity> optionalOpportunity = opportunityRepository.findById(opportunityId);
    
        if (optionalOpportunity.isPresent()) {
            Opportunity opportunity = optionalOpportunity.get();
    
            // Update the specified attributes using OpportunityFormDTO with null checks
            if (updatedAttributes.getRequiredQuantity() != 0) {
                opportunity.setRequiredQuantity(updatedAttributes.getRequiredQuantity());
            }
            if (updatedAttributes.getExpectedRevenue() != 0) {
                opportunity.setExpectedRevenue(updatedAttributes.getExpectedRevenue());
            }
            if (updatedAttributes.getProbability() != 0) {
                opportunity.setProbability(updatedAttributes.getProbability());
            }
            if (updatedAttributes.getExpectedClosingDate() != null) {
                opportunity.setExpectedClosingDate(updatedAttributes.getExpectedClosingDate());
            }
            if (updatedAttributes.getProducts() != null) {
                opportunity.setProducts(updatedAttributes.getProducts());
            }
            if (updatedAttributes.getStatus() != null) {
                opportunity.setStatus(updatedAttributes.getStatus());
            }
            if (updatedAttributes.getSource() != null) {
                opportunity.setSource(updatedAttributes.getSource());
            }
            if (updatedAttributes.getAccountName() != null) {
                opportunity.setAccountName(updatedAttributes.getAccountName());
            }
    
            return opportunityRepository.save(opportunity);
        }
    
        throw new OpportunityNotFoundException("Opportunity with ID " + opportunityId + " not found");
    }
    

}
