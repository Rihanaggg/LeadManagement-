package com.example.leadmanager.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

@SpringBootTest
public class LeadServiceTests {

    @Mock
    private LeadRepository leadRepository;

    @Mock
    private NewLeadRepository newLeadRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private OpportunityRepository opportunityRepository;

    @Mock
    private QualifiedLeadRepository qualifiedLeadRepository;

    @Mock
    private UnqualifiedLeadRepository unqualifiedLeadRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private LeadService leadService;

    @Test
    public void getAllLeads_ReturnsListOfLeads() {
        List<Lead> leads = new ArrayList<>();
        leads.add(new Lead());
        leads.add(new Lead());

        when(leadRepository.findAll()).thenReturn(leads);

        List<Lead> result = leadService.getAllLeads();

        assertEquals(2, result.size());
    }

    @Test
    public void getLeadById_ExistingLeadId_ReturnsOptionalLead() {
        Lead lead = new Lead();
        lead.setLeadId(1L);

        when(leadRepository.findById(1L)).thenReturn(Optional.of(lead));

        Optional<Lead> result = leadService.getLeadById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getLeadId());
    }

    @Test
    public void getLeadById_NonexistentLeadId_ReturnsEmptyOptional() {
        when(leadRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Lead> result = leadService.getLeadById(1L);

        assertTrue(result.isEmpty());
    }

    @Test
    public void createLead_ValidFirstFormDTO_ReturnsCreatedLead() {
        FirstFormDTO firstFormDTO = new FirstFormDTO();
        firstFormDTO.setName("John Doe");
        // Add other necessary attributes

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        when(authentication.getName()).thenReturn("testuser");

        User user = new User();
        user.setName("testuser");
        when(userService.getByName("testuser")).thenReturn(Optional.of(user));

        NewLead newLead = new NewLead();
        when(newLeadRepository.save(any(NewLead.class))).thenReturn(newLead);

        Lead lead = new Lead();
        lead.setNewLead(newLead);
        when(leadRepository.save(any(Lead.class))).thenReturn(lead);

        Lead createdLead = leadService.createLead(firstFormDTO);

        assertNotNull(createdLead);
        assertEquals(newLead, createdLead.getNewLead());
    }

    @Test
    public void testDeleteLeadById() {
        Long leadIdToDelete = 1L;

        // Mocking the behavior of the leadRepository
        doNothing().when(leadRepository).deleteById(leadIdToDelete);

        // Calling the method to be tested
        leadService.deleteLeadById(leadIdToDelete);

        // Verifying that the deleteById method was called with the correct leadId
        verify(leadRepository, times(1)).deleteById(leadIdToDelete);
    }

    @Test
    public void testUpdateLead() {
        Long leadIdToUpdate = 1L;

        // Create a sample updatedFormDTO
        FirstFormDTO updatedFormDTO = new FirstFormDTO();
        updatedFormDTO.setName("");
        // Add other properties as needed

        // Mocking the behavior of the leadRepository
        Lead existingLead = new Lead();
        NewLead newLead = new NewLead();
        existingLead.setNewLead(newLead);
        when(leadRepository.findById(leadIdToUpdate)).thenReturn(Optional.of(existingLead));
        when(leadRepository.save(any(Lead.class))).thenReturn(existingLead);

        // Calling the method to be tested
        Lead updatedLead = leadService.updateLead(leadIdToUpdate, updatedFormDTO);

        // Verifying that the leadRepository.findById was called with the correct leadId
        verify(leadRepository, times(1)).findById(leadIdToUpdate);

        // Verifying that the lead properties were updated
        assertEquals("", updatedLead.getNewLead().getName());
        // Add assertions for other properties

        // Verifying that leadRepository.save was called with the updated lead
        verify(leadRepository, times(1)).save(existingLead);
    }

    @Test
    public void testUpdateLeadByAttribute() {
        Long leadIdToUpdate = 1L;

        // Create a sample updatedAttributes
        FirstFormDTO updatedAttributes = new FirstFormDTO();
        updatedAttributes.setName("");
        updatedAttributes.setCompanyName("Updated Company");
        updatedAttributes.setAddress("abc");
        // updatedAttributes.setCreatedDate(2023-10-15T00:00:00.000+00:00);
        updatedAttributes.setEmail("ru@gmail.com");
        updatedAttributes.setExpectedRevenue(30.00);
        updatedAttributes.setJobTitle("engineer");
        updatedAttributes.setPhone("1234567890");
        updatedAttributes.setProbability(0.75);
        updatedAttributes.setProducts("analytics");
        updatedAttributes.setRegion("north");
        updatedAttributes.setRequiredQuantity(7890);
        updatedAttributes.setSource("web");
        updatedAttributes.setState("UK");
        updatedAttributes.setStatus("new");
        updatedAttributes.setTypeOfBusiness("education");
        updatedAttributes.setWebsite("www.okk.com");

        // Add other attributes as needed

        // Mocking the behavior of the leadRepository
        Lead existingLead = new Lead();
        NewLead newLead = new NewLead();
        existingLead.setNewLead(newLead);
        when(leadRepository.findById(leadIdToUpdate)).thenReturn(Optional.of(existingLead));
        when(leadRepository.save(any(Lead.class))).thenReturn(existingLead);

        // Calling the method to be tested
        Lead updatedLead = leadService.updateLeadByAttribute(leadIdToUpdate, updatedAttributes);

        // Verifying that the leadRepository.findById was called with the correct leadId
        verify(leadRepository, times(1)).findById(leadIdToUpdate);

        // Verifying that lead properties were updated
        assertEquals("", updatedLead.getNewLead().getName());
        assertEquals("Updated Company", updatedLead.getNewLead().getCompanyName());
        assertEquals("abc", updatedLead.getNewLead().getAddress());
        assertEquals("ru@gmail.com", updatedLead.getNewLead().getEmail());
        assertEquals(30.00, updatedLead.getNewLead().getExpectedRevenue());
        assertEquals("engineer", updatedLead.getNewLead().getJobTitle());
        assertEquals("1234567890", updatedLead.getNewLead().getPhone());
        assertEquals(0.75, updatedLead.getNewLead().getProbability());
        assertEquals("analytics", updatedLead.getNewLead().getProducts());
        assertEquals("north", updatedLead.getNewLead().getRegion());
        assertEquals(7890, updatedLead.getNewLead().getRequiredQuantity());
        assertEquals("web", updatedLead.getNewLead().getSource());
        assertEquals("UK", updatedLead.getNewLead().getState());
        assertEquals("new", updatedLead.getNewLead().getStatus());
        assertEquals("education", updatedLead.getNewLead().getTypeOfBusiness());
        assertEquals("www.okk.com", updatedLead.getNewLead().getWebsite());
        // Add assertions for other attributes

        // Verifying that leadRepository.save was called with the updated lead
        verify(leadRepository, times(1)).save(existingLead);
    }

    @Test
    public void testSearchLeadsByName() {
        String nameToSearch = "John Doe";

        // Create a sample list of leads
        List<Lead> sampleLeads = new ArrayList<>();
        sampleLeads.add(new Lead());
        sampleLeads.add(new Lead());
        // Add more leads as needed

        // Mocking the behavior of the leadRepository
        when(leadRepository.searchByName(nameToSearch)).thenReturn(sampleLeads);

        // Calling the method to be tested
        List<Lead> foundLeads = leadService.searchLeadsByName(nameToSearch);

        // Verifying that leadRepository.searchByName was called with the correct name
        verify(leadRepository, times(1)).searchByName(nameToSearch);

        // Verifying that the returned list of leads is not null
        assertNotNull(foundLeads);

        // Verifying that the returned list of leads matches the sample leads
        assertEquals(sampleLeads.size(), foundLeads.size());
        assertTrue(foundLeads.containsAll(sampleLeads));
    }

    @Test
    public void testSearchLeadsByCompanyName() {
        String companyNameToSearch = "ABC Inc.";

        List<Lead> sampleLeads = new ArrayList<>();
        sampleLeads.add(new Lead());
        sampleLeads.add(new Lead());

        when(leadRepository.findByNewLeadCompanyNameContaining(companyNameToSearch)).thenReturn(sampleLeads);

        List<Lead> foundLeads = leadService.searchLeadsByCompanyName(companyNameToSearch);

        verify(leadRepository, times(1)).findByNewLeadCompanyNameContaining(companyNameToSearch);

        assertNotNull(foundLeads);
        assertEquals(sampleLeads.size(), foundLeads.size());
        assertTrue(foundLeads.containsAll(sampleLeads));
    }

    @Test
    public void testSearchLeadsByEmail() {
        String emailToSearch = "john.doe@example.com";

        List<Lead> sampleLeads = new ArrayList<>();
        sampleLeads.add(new Lead());
        sampleLeads.add(new Lead());

        when(leadRepository.findByNewLeadEmailContaining(emailToSearch)).thenReturn(sampleLeads);

        List<Lead> foundLeads = leadService.searchLeadsByEmail(emailToSearch);

        verify(leadRepository, times(1)).findByNewLeadEmailContaining(emailToSearch);

        assertNotNull(foundLeads);
        assertEquals(sampleLeads.size(), foundLeads.size());
        assertTrue(foundLeads.containsAll(sampleLeads));
    }

    @Test
    public void testSearchLeadsByState() {
        String stateToSearch = "California";

        List<Lead> sampleLeads = new ArrayList<>();
        sampleLeads.add(new Lead());
        sampleLeads.add(new Lead());

        when(leadRepository.findByNewLeadStateContaining(stateToSearch)).thenReturn(sampleLeads);

        List<Lead> foundLeads = leadService.searchLeadsByState(stateToSearch);

        verify(leadRepository, times(1)).findByNewLeadStateContaining(stateToSearch);

        assertNotNull(foundLeads);
        assertEquals(sampleLeads.size(), foundLeads.size());
        assertTrue(foundLeads.containsAll(sampleLeads));
    }

    @Test
    public void testSearchLeadsByStatus() {
        String statusToSearch = "Active";

        List<Lead> sampleLeads = new ArrayList<>();
        sampleLeads.add(new Lead());
        sampleLeads.add(new Lead());

        when(leadRepository.findByNewLeadStatusContaining(statusToSearch)).thenReturn(sampleLeads);

        List<Lead> foundLeads = leadService.searchLeadsByStatus(statusToSearch);

        verify(leadRepository, times(1)).findByNewLeadStatusContaining(statusToSearch);

        assertNotNull(foundLeads);
        assertEquals(sampleLeads.size(), foundLeads.size());
        assertTrue(foundLeads.containsAll(sampleLeads));
    }

    @Test
    public void testUpdateLeadStatus_Won() {
        Long leadId = 1L;
        String newStatus = "Won";

        Lead lead = new Lead();
        NewLead newLead = new NewLead();
        lead.setNewLead(newLead);

        when(leadRepository.findById(leadId)).thenReturn(Optional.of(lead));

        leadService.updateLeadStatus(leadId, newStatus);

        verify(leadRepository, times(1)).findById(leadId);

        assertEquals(newStatus, newLead.getStatus());

        // Verify that Account, Contact, and Opportunity entities are created and
        // associated
        verify(accountRepository, times(1)).save(any(Account.class));
        verify(contactRepository, times(1)).save(any(Contact.class));
        verify(opportunityRepository, times(1)).save(any(Opportunity.class));

        // Verify that the lead is moved to the QualifiedLead table and removed from the
        // original table
        verify(qualifiedLeadRepository, times(1)).save(any(QualifiedLead.class));
        // verify(leadRepository, times(1)).delete(lead);
    }

    @Test
    public void testUpdateLeadStatus_Lost() {
        Long leadId = 1L;
        String newStatus = "Lost";

        Lead lead = new Lead();
        NewLead newLead = new NewLead();
        lead.setNewLead(newLead);

        when(leadRepository.findById(leadId)).thenReturn(Optional.of(lead));

        leadService.updateLeadStatus(leadId, newStatus);

        verify(leadRepository, times(1)).findById(leadId);

        assertEquals(newStatus, newLead.getStatus());

        // Verify that the lead is moved to the UnqualifiedLead table and removed from
        // the original table
        verify(unqualifiedLeadRepository, times(1)).save(any(UnqualifiedLead.class));
        // verify(leadRepository, times(1)).delete(lead);
    }

    @Test
    public void testUpdateLeadStatus_LeadNotFound() {
        Long leadId = 1L;
        String newStatus = "Won";

        when(leadRepository.findById(leadId)).thenReturn(Optional.empty());

        assertThrows(LeadNotFoundException.class, () -> {
            leadService.updateLeadStatus(leadId, newStatus);
        });

        verify(leadRepository, times(1)).findById(leadId);
    }

   
   
}
