package com.example.leadmanager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leadmanager.entity.QualifiedLead;
import com.example.leadmanager.entity.UnqualifiedLead;
import com.example.leadmanager.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/lead-probabilities")
    public List<Double> getAllLeadProbabilities() {
        return dashboardService.getAllLeadProbabilities();
    }

    @GetMapping("/expected-revenues")
    public List<Double> getAllExpectedRevenues() {
        return dashboardService.getAllExpectedRevenues();
    }

    @GetMapping("/status")
    public Map<String, Integer> getLeadCountsByStatus() {
        return dashboardService.countLeadsByStatus();
    }

    @GetMapping("/source")
    public Map<String, Integer> getLeadCountsBySource() {
        return dashboardService.countLeadsBySource();
    }

    @GetMapping("/region")
    public Map<String, Integer> getLeadCountsByRegion() {
        return dashboardService.countLeadsByRegion();
    }

    @GetMapping("/products")
    public Map<String, Integer> getLeadCountsByProducts() {
        return dashboardService.countLeadsByProducts();
    }

    @GetMapping("/won-leads")
    public List<QualifiedLead> getAllWonLeads() {
        return dashboardService.findAllWonLeads();
    }

    @GetMapping("/lost-leads")
    public List<UnqualifiedLead> getAllLostLeads() {
        return dashboardService.findAllLostLeads();
    }

    @GetMapping("/totalExpectedRevenue")
    public double getTotalExpectedRevenue() {
        return dashboardService.calculateTotalExpectedRevenue();
    }

    @GetMapping("/totalWeightedRevenue")
    public double getTotalWeightedRevenue() {
        return dashboardService.calculateTotalWeightedRevenue();
    }

    @GetMapping("/totalLeadCount")
    public int getTotalLeadCount() {
        return dashboardService.calculateTotalLeadCount();
    }

    @GetMapping("/totalWonLeadsCount")
    public int getTotalWonLeads() {
        return dashboardService.calculateTotalWonLeadCount();
    }

    @GetMapping("/totalLostLeadsCount")
    public int getTotalLostLeads() {
        return dashboardService.calculateTotalLostLeadCount();
    }

    @GetMapping("/convertionRate")
    public double getConversionRate() {
        return dashboardService.calculateConversionRate();
    }
}
