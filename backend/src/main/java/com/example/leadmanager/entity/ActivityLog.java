// package com.example.leadmanager.entity;

// import java.util.Date;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import lombok.Data;

// @Entity
// @Data
// public class ActivityLog {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long activity_log_id;

//     private Date createdAt;
//     private String message;

//     @ManyToOne
//     @JsonBackReference
//     @JoinColumn(name = "user_id")
//     private User user;

//     @ManyToOne
//     @JsonBackReference
//     @JoinColumn(name = "lead_id")
//     private Lead lead;

//     // Getters and setters
// }

