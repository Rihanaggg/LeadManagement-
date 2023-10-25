package com.example.leadmanager.controller;

import java.util.List;
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

import com.example.leadmanager.dto.OpportunityFormDTO;
import com.example.leadmanager.entity.Opportunity;
import com.example.leadmanager.service.OpportunityService;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/all")
    public List<Opportunity> getAllOpportunities() {
        return opportunityService.getAllOpportunities();
    }

    @GetMapping("/opportunity/{opportunityId}")
    public Optional<Opportunity> getOpportunityById(@PathVariable Long opportunityId) {
        return opportunityService.getOpportunityById(opportunityId);
    }

    @DeleteMapping("/delete/{opportunityId}")
    public void deleteOpportunityById(@PathVariable Long opportunityId) {
        opportunityService.deleteOpportunityById(opportunityId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOpportunity(@RequestBody OpportunityFormDTO opportunityFormDTO) {
        try {
            Opportunity opportunity = opportunityService.createOpportunity(opportunityFormDTO, null); // Assuming you don't pass an account for creation
            return new ResponseEntity<>("Opportunity created successfully with ID: " + opportunity.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating opportunity: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/updatebyId/{opportunityId}")
    public ResponseEntity<Opportunity> updateOpportunityAttributes( @PathVariable Long opportunityId, @RequestBody OpportunityFormDTO updatedAttributes) 
    {
    Opportunity updatedOpportunity = opportunityService.updateOpportunityByAttribute(opportunityId, updatedAttributes);
    return ResponseEntity.ok(updatedOpportunity);
    }


    @PutMapping("/update/{opportunityId}")
    public ResponseEntity<Opportunity> updateOpportunity(@PathVariable Long opportunityId, @RequestBody OpportunityFormDTO updatedFormDTO) {
        Opportunity updatedOpportunity = opportunityService.updateOpportunity(opportunityId, updatedFormDTO);
        return ResponseEntity.ok(updatedOpportunity);
    }

    @GetMapping("/search/status")
    public List<Opportunity> searchOpportunitiesByStatus(@RequestParam String status) {
        return opportunityService.searchOpportunitiesByStatus(status);
    }
}
