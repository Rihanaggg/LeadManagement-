package com.example.leadmanager.service;

import com.example.leadmanager.entity.Account;
import com.example.leadmanager.dto.AccountFormDTO;
import com.example.leadmanager.exception.AccountNotFoundException;
import com.example.leadmanager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get account by ID
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    // Create a new account
    public Account createAccount(AccountFormDTO accountFormDTO) {
        Account account = new Account();

        // Set properties from accountFormDTO
        account.setCompanyName(accountFormDTO.getCompanyName());
        account.setAddress(accountFormDTO.getAddress());
        account.setState(accountFormDTO.getState());
        account.setRegion(accountFormDTO.getRegion());
        account.setWebsite(accountFormDTO.getWebsite());
        account.setTypeOfBusiness(accountFormDTO.getTypeOfBusiness());
        account.setPhone(accountFormDTO.getPhone());
        account.setEmail(accountFormDTO.getEmail());
        account.setTypeOfAccount(accountFormDTO.getTypeOfAccount());
        account.setActive(accountFormDTO.getActive());

        return accountRepository.save(account);
    }

    // Delete account by ID
    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    // Update entire account
    public Account updateAccount(Long accountId, AccountFormDTO updatedFormDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            // Update the account's properties with the values from the updatedFormDTO
            account.setCompanyName(updatedFormDTO.getCompanyName());
            account.setAddress(updatedFormDTO.getAddress());
            account.setState(updatedFormDTO.getState());
            account.setRegion(updatedFormDTO.getRegion());
            account.setWebsite(updatedFormDTO.getWebsite());
            account.setTypeOfBusiness(updatedFormDTO.getTypeOfBusiness());
            account.setPhone(updatedFormDTO.getPhone());
            account.setEmail(updatedFormDTO.getEmail());
            account.setTypeOfAccount(updatedFormDTO.getTypeOfAccount());
            account.setActive(updatedFormDTO.getActive());

            return accountRepository.save(account);
        }

        // Handle case where account with accountId is not found
        throw new AccountNotFoundException("Account with ID " + accountId + " not found");
    }

    // Update account by attribute
    public Account updateAccountByAttribute(Long accountId, Map<String, Object> updatedAttributes) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            // Update the specified attributes
            updatedAttributes.forEach((attribute, value) -> {
                switch (attribute) {
                    case "companyName":
                        account.setCompanyName((String) value);
                        break;
                    case "address":
                        account.setAddress((String) value);
                        break;
                    case "state":
                        account.setState((String) value);
                        break;
                    case "region":
                        account.setRegion((String) value);
                        break;
                    case "website":
                        account.setWebsite((String) value);
                        break;
                    case "typeOfBusiness":
                        account.setTypeOfBusiness((String) value);
                        break;
                    case "phone":
                        account.setPhone((String) value);
                        break;
                    case "email":
                        account.setEmail((String) value);
                        break;
                    case "typeOfAccount":
                        account.setTypeOfAccount((String) value);
                        break;
                    case "active":
                        account.setActive((String) value);
                        break;
                    default:
                        // Handle unknown attribute
                        throw new IllegalArgumentException("Invalid attribute: " + attribute);
                }
            });

            return accountRepository.save(account);
        }

        // Handle case where account with accountId is not found
        throw new AccountNotFoundException("Account with ID " + accountId + " not found");
    }

    // Search accounts by company name
    public List<Account> searchAccountsByCompanyName(String companyName) {
        return accountRepository.findByCompanyNameContaining(companyName);
    }

    // Search accounts by email
    public List<Account> searchAccountsByEmail(String email) {
        return accountRepository.findByEmailContaining(email);
    }

    // Search accounts by state
    public List<Account> searchAccountsByState(String state) {
        return accountRepository.findByStateContaining(state);
    }

    // Search accounts by active status
    public List<Account> searchAccountsByActiveStatus(String active) {
        return accountRepository.findByActive(active);
    }

}
