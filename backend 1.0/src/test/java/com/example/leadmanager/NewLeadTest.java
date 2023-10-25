package com.example.leadmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.leadmanager.entity.NewLead;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class NewLeadTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void newLeadValidationShouldFail() {
        NewLead newLead = new NewLead();
        newLead.setEmail("invalidemail"); // Invalid email format
        newLead.setPhone("12345678901"); // Phone exceeds max size
        newLead.setCompanyName(""); // Blank company name

        // Validate the newLead object
        var violations = validator.validate(newLead);

        // Check if there are violations
        assertFalse(violations.isEmpty());
    }

    @Test
    public void newLeadValidationShouldPass() {
        NewLead newLead = new NewLead();

        newLead.setName("Nidhi");
        newLead.setEmail("valid@example.com");
        newLead.setPhone("1234567890");
        newLead.setCompanyName("Example Company");        
        newLead.setJobTitle("manager");
        newLead.setAddress("123,street");
        newLead.setState("london");
        newLead.setRegion("east");
        newLead.setWebsite("www.tt.com");
        newLead.setTypeOfBusiness("sports");
        newLead.setRequiredQuantity(400);
        newLead.setExpectedRevenue(45900);
        newLead.setProbability(0.80);
        newLead.setProducts("cloud");
        newLead.setStatus("new");
        newLead.setSource("refferal");

        // Validate the newLead object
        var violations = validator.validate(newLead);

        // Check if there are no violations
        assertTrue(violations.isEmpty());
    }
}
