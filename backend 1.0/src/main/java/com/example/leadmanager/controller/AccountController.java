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

import com.example.leadmanager.dto.AccountFormDTO;
import com.example.leadmanager.entity.Account;
import com.example.leadmanager.repository.AccountRepository;
import com.example.leadmanager.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{accountId}")
    public Optional<Account> getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @DeleteMapping("/delete/{accountId}")
    public void deleteAccountById(@PathVariable Long accountId) {
        accountService.deleteAccountById(accountId);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountFormDTO accountFormDTO) {
        try {
            Account account = accountService.createAccount(accountFormDTO);
            return new ResponseEntity<>("Account created successfully with ID: " + account.getAccount_id(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating account: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody AccountFormDTO updatedFormDTO) {
        Account updatedAccount = accountService.updateAccount(accountId, updatedFormDTO);
        return ResponseEntity.ok(updatedAccount);
    }

    // @PatchMapping("/updatebyid/{accountId}")
    // public ResponseEntity<Account> updateAccountAttributes(@PathVariable Long accountId, @RequestBody Map<String, Object> updatedAttributes) {
    //     Account updatedAccount = accountService.updateAccountByAttribute(accountId, updatedAttributes);
    //     return ResponseEntity.ok(updatedAccount);
    // }

    @PatchMapping("/updatebyId/{accountId}")
    public ResponseEntity<Account> updateAccountAttributes( @PathVariable Long accountId,@RequestBody AccountFormDTO updatedAttributes) {
        Account updatedAccount = accountService.updateAccountByAttribute(accountId, updatedAttributes);
        return ResponseEntity.ok(updatedAccount);
    }

    @GetMapping("/search/companyName")
    public List<Account> searchAccountsByCompanyName(@RequestParam String companyName) {
        return accountService.searchAccountsByCompanyName(companyName);
    }

    @GetMapping("/search/email")
    public List<Account> searchAccountsByEmail(@RequestParam String email) {
        return accountService.searchAccountsByEmail(email);
    }

    @GetMapping("/search/state")
    public List<Account> searchAccountsByState(@RequestParam String state) {
        return accountService.searchAccountsByState(state);
    }

    @GetMapping("/search/active")
    public List<Account> searchAccountsByActiveStatus(@RequestParam String active) {
        return accountService.searchAccountsByActiveStatus(active);
    }

    @GetMapping("/search")
    public List<Account> searchAccounts(
            @RequestParam String searchType,
            @RequestParam String query
    ) {
        switch (searchType) {
            case "companyName":
                return accountService.searchAccountsByCompanyName(query);
            case "email":
                return accountService.searchAccountsByEmail(query);
            case "state":
                return accountService.searchAccountsByState(query);
            case "active":
                return accountService.searchAccountsByActiveStatus(query);
            default:
                throw new IllegalArgumentException("Invalid search type: " + searchType);
        }
    }
}
