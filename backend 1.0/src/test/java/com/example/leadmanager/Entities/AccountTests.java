package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.Account;
import com.example.leadmanager.repository.AccountRepository;

@SpringBootTest
@Transactional
public class AccountTests {

    @Autowired
    private AccountRepository accountRepository;

    // @Test
    // public void saveAccountWithAllProperties() {
    //     // Create a new Account object with all properties set
    //     Account account = new Account();
    //     account.setCompanyName("Example Company");
    //     account.setAddress("123 Main St");
    //     account.setState("California");
    //     account.setRegion("West");
    //     account.setWebsite("example.com");
    //     account.setTypeOfBusiness("Finance");
    //     account.setPhone("123-456-7890");
    //     account.setEmail("info@example.com");
    //     account.setTypeOfAccount("Customer");
    //     account.setActive("Yes");

    //     // Create a list of contacts and opportunities and associate them with the account
    //     List<Contact> contacts = new ArrayList<>();
    //     List<Opportunity> opportunities = new ArrayList<>();
    //     // Populate contacts and opportunities lists and associate them with the account

    //     account.setContacts(contacts);
    //     account.setOpportunities(opportunities);

    //     // Save the Account to the database
    //     accountRepository.save(account);

    //     // Check if the Account has been saved with non-null properties
    //     assertNotNull(account.getAccount_id());
    //     // Check other properties as needed...
    //     assertNotNull(account.getContacts());
    //     assertNotNull(account.getOpportunities());
    // }

    @Test
    public void saveAccountWithNullProperties() {
        // Create a new Account object without setting any properties
        Account account = new Account();

        // Save the Account to the database
        accountRepository.save(account);

        // Check if the Account has been saved with null properties
       // assertNull(account.getAccount_id());
        // Check other properties as needed...
        assertNull(account.getContacts());
        assertNull(account.getOpportunities());
    }

    // @Test
    // public void updateAccountProperties() {
    //     // Create a new Account object and save it to the database
    //     Account account = new Account();
    //     accountRepository.save(account);

    //     // Update the Account properties
    //     account.setCompanyName("Updated Company Name");
    //     // Update other properties as needed...

    //     // Save the updated Account to the database
    //     accountRepository.save(account);

    //     // Retrieve the Account from the database and check if properties have been updated
    //     Account updatedAccount = accountRepository.findById(account.getAccount_id()).orElse(null);
    //     assertNotNull(updatedAccount);
    //     assertEquals("Updated Company Name", updatedAccount.getCompanyName());
    //     // Check other updated properties as needed...
    // }

    @Test
    public void deleteAccount() {
        // Create a new Account object and save it to the database
        Account account = new Account();
        accountRepository.save(account);

        // Delete the Account from the database
        accountRepository.delete(account);

        // Try to retrieve the Account from the database and expect it to be null
        Account deletedAccount = accountRepository.findById(account.getAccount_id()).orElse(null);
        assertNull(deletedAccount);
    }

    @Test
    public void saveAccountWithAllProperties() {
        // Create a new Account object with all properties set
        Account account = new Account();
        account.setAddress("123 Main St");
        account.setState("California");
        account.setRegion("West");
        account.setWebsite("example.com");
        account.setTypeOfBusiness("Finance");
        account.setPhone("123-456-7890");
        account.setEmail("info@example.com");
        account.setTypeOfAccount("Customer");
        account.setActive("Yes");

        // Save the Account to the database
        accountRepository.save(account);

        // Retrieve the Account from the database and check if properties are correct
        Account retrievedAccount = accountRepository.findById(account.getAccount_id()).orElse(null);
        assertNotNull(retrievedAccount);

        assertEquals("123 Main St", retrievedAccount.getAddress());
        assertEquals("California", retrievedAccount.getState());
        assertEquals("West", retrievedAccount.getRegion());
        assertEquals("example.com", retrievedAccount.getWebsite());
        assertEquals("Finance", retrievedAccount.getTypeOfBusiness());
        assertEquals("123-456-7890", retrievedAccount.getPhone());
        assertEquals("info@example.com", retrievedAccount.getEmail());
        assertEquals("Customer", retrievedAccount.getTypeOfAccount());
        assertEquals("Yes", retrievedAccount.getActive());
    }

    @Test
    public void updateAccountProperties() {
        // Create a new Account object and save it to the database
        Account account = new Account();
        accountRepository.save(account);

        // Update the Account properties
        account.setAddress("Updated Address");
        account.setState("Updated State");
        account.setRegion("Updated Region");
        account.setWebsite("updated.example.com");
        account.setTypeOfBusiness("Education");
        account.setPhone("987-654-3210");
        account.setEmail("updated.info@example.com");
        account.setTypeOfAccount("Partner");
        account.setActive("No");

        // Save the updated Account to the database
        accountRepository.save(account);

        // Retrieve the Account from the database and check if properties have been updated
        Account updatedAccount = accountRepository.findById(account.getAccount_id()).orElse(null);
        assertNotNull(updatedAccount);

        assertEquals("Updated Address", updatedAccount.getAddress());
        assertEquals("Updated State", updatedAccount.getState());
        assertEquals("Updated Region", updatedAccount.getRegion());
        assertEquals("updated.example.com", updatedAccount.getWebsite());
        assertEquals("Education", updatedAccount.getTypeOfBusiness());
        assertEquals("987-654-3210", updatedAccount.getPhone());
        assertEquals("updated.info@example.com", updatedAccount.getEmail());
        assertEquals("Partner", updatedAccount.getTypeOfAccount());
        assertEquals("No", updatedAccount.getActive());
    }
}
