package com.example.leadmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leadmanager.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);
    List<Account> findAll();
    List<Account> findByCompanyNameContaining(String companyName);

    List<Account> findByEmailContaining(String email);

    List<Account> findByStateContaining(String state);

    List<Account> findByActive(String active);
}
