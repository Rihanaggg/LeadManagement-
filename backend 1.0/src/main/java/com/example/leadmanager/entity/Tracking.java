// package com.example.leadmanager.entity;

// import com.fasterxml.jackson.annotation.JsonBackReference;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;
// import lombok.Data;

// @Entity
// @Data
// public class Tracking {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long track_id;

//     @OneToOne(mappedBy = "tracking")
//     @JsonBackReference
//     private Lead lead;

//     private int daysToAssign;
//     private int daysToClose;

//     // Getters and setters
// }

