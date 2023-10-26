package com.example.leadmanager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leadmanager.entity.Lead;
import com.example.leadmanager.entity.QualifiedLead;
import com.example.leadmanager.entity.UnqualifiedLead;
import com.example.leadmanager.repository.LeadRepository;
import com.example.leadmanager.repository.QualifiedLeadRepository;
import com.example.leadmanager.repository.UnqualifiedLeadRepository;


@Service
public class DashboardService {

    @Autowired
    private LeadService leadService;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private QualifiedLeadRepository qualifiedLeadRepository;

    @Autowired
    private UnqualifiedLeadRepository unqualifiedLeadRepository;

    public List<Double> getAllLeadProbabilities() {
        List<Lead> allLeads = leadService.getAllLeads();
        return extractProbabilities(allLeads);
    }

    private List<Double> extractProbabilities(List<Lead> leads) {
        return leads.stream()
                .map(lead -> lead.getNewLead().getProbability())
                .toList();
    }

    public List<Double> getAllExpectedRevenues() {
        List<Lead> allLeads = leadService.getAllLeads();
        return extractExpectedRevenues(allLeads);
    }
    
    private List<Double> extractExpectedRevenues(List<Lead> leads) {
        return leads.stream()
                .map(lead -> lead.getNewLead().getExpectedRevenue())
                .toList();
    }

    public int calculateTotalLeadCount() {
        List<Lead> allLeads = leadService.getAllLeads();
        return extractLeadCount(allLeads);
    }
    
    private int extractLeadCount(List<Lead> leads) {
        return leads.size();
    }
    
    public double calculateTotalExpectedRevenue() {
        List<Lead> allLeads = leadService.getAllLeads();
        List<Double> expectedRevenues = extractExpectedRevenues(allLeads);
        return expectedRevenues.stream().mapToDouble(Double::doubleValue).sum();
    }
    

    public Map<String, Integer> getLeadCounts() {
        Map<String, Integer> leadCounts = new HashMap<>();
    
        // Count leads by status
        leadCounts.putAll(countLeadsByStatus());
    
        // Count leads by source
        leadCounts.putAll(countLeadsBySource());
    
        // Count leads by region
        leadCounts.putAll(countLeadsByRegion());

        leadCounts.putAll(countLeadsByProducts());
    
        return leadCounts;
    }
    public Map<String, Integer> countLeadsByStatus() {
    Map<String, Integer> statusCounts = new HashMap<>();
    statusCounts.put("New", leadRepository.countLeadsByStatus("New"));
    statusCounts.put("Qualified", leadRepository.countLeadsByStatus("Qualified"));
    statusCounts.put("Proposition", leadRepository.countLeadsByStatus("Proposition"));
    statusCounts.put("Negotiation", leadRepository.countLeadsByStatus("Negotiation"));
    statusCounts.put("Won", leadRepository.countLeadsByStatus("Won"));
    return statusCounts;
}

public Map<String, Integer> countLeadsBySource() {
    Map<String, Integer> sourceCounts = new HashMap<>();
    sourceCounts.put("Web", leadRepository.countLeadsBySource("Web"));
    sourceCounts.put("Phone Inquiry", leadRepository.countLeadsBySource("Phone Inquiry"));
    sourceCounts.put("Referral", leadRepository.countLeadsBySource("Referral"));
    return sourceCounts;
}

public Map<String, Integer> countLeadsByRegion() {
    Map<String, Integer> regionCounts = new HashMap<>();
    regionCounts.put("East", leadRepository.countLeadsByRegion("East"));
    regionCounts.put("West", leadRepository.countLeadsByRegion("West"));
    regionCounts.put("North", leadRepository.countLeadsByRegion("North"));
    regionCounts.put("South", leadRepository.countLeadsByRegion("South"));
    return regionCounts;
}

public Map<String, Integer> countLeadsByProducts() {
    Map<String, Integer> productCounts = new HashMap<>();
    productCounts.put("Accounting software", leadRepository.countLeadsByProducts("Accounting software"));
    productCounts.put("Cloud services", leadRepository.countLeadsByProducts("Cloud services"));
    productCounts.put("Communication software", leadRepository.countLeadsByProducts("Communication software"));
    productCounts.put("Content management software", leadRepository.countLeadsByProducts("Content management software"));
    productCounts.put("Customer service platforms", leadRepository.countLeadsByProducts("Customer service platforms"));
    productCounts.put("Analytics", leadRepository.countLeadsByProducts("Analytics"));
    productCounts.put("Cloud storage", leadRepository.countLeadsByProducts("Cloud storage"));
    return productCounts;
}


    public List<QualifiedLead> findAllWonLeads() {
        return qualifiedLeadRepository.findAll();
    }

    public int calculateTotalWonLeadCount() {
        return findAllWonLeads().size();
    }
    
     
    public List<UnqualifiedLead> findAllLostLeads() {
        return unqualifiedLeadRepository.findAll();
    }

     public int calculateTotalLostLeadCount() {       
        return findAllLostLeads().size();
    }

    public double calculateConversionRate() {
        int totalWonLeads = calculateTotalWonLeadCount();
        int totalLeads = calculateTotalLeadCount();

        if (totalLeads != 0) {
            return ((double) totalWonLeads / totalLeads) * 100;
        } else {
            return 0.0; // Handle the case where totalLeads is zero to avoid division by zero
        }
    }
}
