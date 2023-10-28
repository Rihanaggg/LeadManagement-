package com.example.leadmanager.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.leadmanager.entity.User;
import com.example.leadmanager.repository.UserRepository;

@SpringBootTest
@Transactional
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserWithAllProperties() {
        // Create a new User object with all properties set
        User user = new User();
        user.setName("John Doe");
        user.setPassword("password");
        user.setRole("ROLE_USER");

        // Save the User to the database
        userRepository.save(user);

        // Check if the User has been saved with non-null properties
        assertNotNull(user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("password", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void saveUserWithNullProperties() {
        // Create a new User object without setting any properties
        User user = new User();

        // Save the User to the database
        userRepository.save(user);

        // Check if the User has been saved with null properties
        assertNotNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getPassword());
        assertNull(user.getRole());
    }

    @Test
    public void updateUserProperties() {
        // Create a new User object and save it to the database
        User user = new User();
        user.setName("Jane Doe");
        user.setPassword("password123");
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);

        // Update the User properties
        user.setName("Updated Name");
        user.setPassword("updatedPassword");
        user.setRole("ROLE_MANAGER");

        // Save the updated User to the database
        userRepository.save(user);

        // Retrieve the User from the database and check if properties have been updated
        User updatedUser = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(updatedUser);
        assertEquals("Updated Name", updatedUser.getName());
        assertEquals("updatedPassword", updatedUser.getPassword());
        assertEquals("ROLE_MANAGER", updatedUser.getRole());
    }

    @Test
    public void deleteUser() {
        // Create a new User object and save it to the database
        User user = new User();
        userRepository.save(user);

        // Delete the User from the database
        userRepository.delete(user);

        // Try to retrieve the User from the database and expect it to be null
        User deletedUser = userRepository.findById(user.getId()).orElse(null);
        assertNull(deletedUser);
    }
}

