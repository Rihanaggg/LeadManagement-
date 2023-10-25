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

import com.example.leadmanager.dto.FirstFormDTO;
import com.example.leadmanager.entity.Lead;
import com.example.leadmanager.exception.LeadNotFoundException;
import com.example.leadmanager.repository.LeadRepository;
import com.example.leadmanager.service.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @Autowired
    private LeadRepository leadRepository;

    @GetMapping("/all")
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/lead/{leadId}")
    public Optional<Lead> getLeadById(@PathVariable Long leadId) {
        return leadRepository.findById(leadId);

    }


    @DeleteMapping("/delete/{leadId}")
    public void deleteLeadById(@PathVariable Long leadId) {
        leadService.deleteLeadById(leadId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createLead(@RequestBody FirstFormDTO firstFormDTO) {
        try {
            Lead lead = leadService.createLead(firstFormDTO);
            return new ResponseEntity<>("Lead created successfully with ID: " + lead.getLeadId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating lead: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/allupdate/{leadId}")
        public ResponseEntity<Lead> updateLead(@PathVariable Long leadId, @RequestBody FirstFormDTO updatedFormDTO) {
        Lead updatedLead = leadService.updateLead(leadId, updatedFormDTO);
        return ResponseEntity.ok(updatedLead);
    }

    @PatchMapping("/update/{leadId}")
        public ResponseEntity<Lead> updateLeadAttributes(@PathVariable Long leadId, @RequestBody FirstFormDTO updatedAttributes) {
        Lead updatedLead = leadService.updateLeadByAttribute(leadId, updatedAttributes);
        return ResponseEntity.ok(updatedLead);
    }

    // @GetMapping("/search/name")
    // public List<Lead> searchLeads(@RequestParam String name) {
    //     return leadService.searchLeadsByName(name);
    // }

    // @GetMapping("/search/companyName")
    // public List<Lead> searchLeadsByCompanyName(@RequestParam String companyName) {
    //     return leadService.searchLeadsByCompanyName(companyName);
    // }

    // @GetMapping("/search/email")
    // public List<Lead> searchLeadsByEmail(@RequestParam String email) {
    //     return leadService.searchLeadsByEmail(email);
    // }

    // @GetMapping("/search/state")
    // public List<Lead> searchLeadsByState(@RequestParam String state) {
    //     return leadService.searchLeadsByState(state);
    // }

    // @GetMapping("/search/status")
    // public List<Lead> searchLeadsByStatus(@RequestParam String status) {
    //     return leadService.searchLeadsByStatus(status);
    // }

    @GetMapping("/search")
    public List<Lead> searchLeads(
        @RequestParam String searchType,
        @RequestParam String query
    ) {
        switch (searchType) {
            case "name":
                return leadService.searchLeadsByName(query);
            case "status":
                return leadService.searchLeadsByStatus(query);
            case "companyName":
                return leadService.searchLeadsByCompanyName(query);
            case "email":
                return leadService.searchLeadsByEmail(query);
            case "state":
                return leadService.searchLeadsByState(query);
            default:
                throw new IllegalArgumentException("Invalid search type: " + searchType);
        }
    }

    @PutMapping("/{leadId}/status")
    public ResponseEntity<String> updateLeadStatus(@PathVariable Long leadId, @RequestParam String newStatus) {
        try {
            leadService.updateLeadStatus(leadId, newStatus);
            return ResponseEntity.ok("Lead status updated successfully.");
        } catch (LeadNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating lead status.");
        }
    }

}
