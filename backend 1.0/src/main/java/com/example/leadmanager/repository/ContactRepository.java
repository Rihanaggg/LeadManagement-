package com.example.leadmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.leadmanager.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findById(Long id);
    List<Contact> findAll();
    List<Contact> findByNameContaining(String name);
    List<Contact> findByEmailContaining(String email);
    List<Contact> findByPhoneContaining(String phone);
}
