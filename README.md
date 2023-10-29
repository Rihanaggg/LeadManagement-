# CRM - Lead Management System

## Table of Contents
1. [Introduction](#introduction)
   - [Purpose](#purpose)
   - [Scope](#scope)
   - [Definitions, Acronyms, and Abbreviations](#definitions-acronyms-and-abbreviations)
   - [References](#references)
   - [Overview](#overview)
2. [System Description](#system-description)
   - [Functional Requirements](#functional-requirements)
   - [Non-Functional Requirements](#non-functional-requirements)
3. [Use Cases](#use-cases)
   - [Create New Lead](#use-case-1-create-new-lead)
   - [Qualify Lead](#use-case-2-qualify-lead)
   - [Move Lead to Proposition Stage](#use-case-3-move-lead-to-proposition-stage)
   - [Negotiate Lead](#use-case-4-negotiate-lead)
   - [Mark Lead as Won](#use-case-5-mark-lead-as-won)
   - [Generate Reports](#use-case-6-generate-reports)
4. [System Architecture](#system-architecture)
   - [Frontend](#frontend)
   - [Backend](#backend)
   - [Database](#database)
   - [External APIs](#external-apis)
5. [Testing](#testing)
   - [Unit Testing](#unit-testing)
   - [Integration Testing](#integration-testing)

---

## Introduction

### 1.1 Purpose

The purpose of this document is to define the requirements of the Sugar CRM Lead Management System, which aims to streamline the lead handling process across five stages: New, Qualified, Proposition, Negotiation, and Won. Additionally, it describes the dashboard and Report part for this system.

### 1.2 Scope

This system will encompass the development of a full-stack application capable of creating leads, moving them through stages, and generating reports. The application will consist of web and chat-based interfaces.

### 1.3 Definitions, Acronyms, and Abbreviations

- CRM: Customer Relationship Management
- SRS: Software Requirements Specification

### 1.4 References

- Salesforce lead management portals
- Oddo

### 1.5 Overview

The Sugar CRM Lead Management System is a comprehensive software solution designed to streamline the process of managing leads within a Customer Relationship Management (CRM) framework. This system aims to facilitate efficient lead handling through five distinct stages: New, Qualified, Proposition, Negotiation, and Won. It provides a user-friendly interface for creating, categorizing, and progressing leads, ultimately enhancing the sales pipeline.

## System Description

### 2.1 Functional Requirements

#### 2.1.1 Lead Management

The system shall allow users to create new leads.

The system shall allow users to qualify leads.

The system shall allow users to move leads through stages: New, Qualified, Proposition, Negotiation, Won.

The system shall provide functionality to view and edit lead details.

#### 2.1.2 Forms

The system shall provide web-based forms for lead data entry.

The system shall provide chat-based forms for lead data entry.

#### 2.1.3 Dashboards

The system shall generate interactive dashboards displaying lead statistics.

#### 2.1.4 Reports

The system shall generate detailed reports on lead activities.

### 2.2 Non-Functional Requirements

#### 2.2.1 Performance

The system shall handle a minimum of 1000 concurrent users.

#### 2.2.2 Security

User authentication and authorization shall be implemented.

#### 2.2.3 Usability

The system shall have an intuitive user interface.

#### 2.2.4 Reliability

The system shall have a 99% uptime.

#### 2.2.5 Compatibility

The system shall be compatible with the latest versions of major browsers.

## Use Cases

### 3.1 Use Case 1: Create New Lead

**Actor:** User

**Description:** This use case describes the process of creating a new lead in the system.

**Preconditions:**
- User is logged into the system.

**Flow of Events:**
1. User navigates to the "Create Lead" section.
2. User provides necessary lead information (e.g., name, contact details, company).
3. User submits the form.

**Postconditions:**
- The system creates a new lead and assigns it the "New" status.

### 3.2 Use Case 2: Qualify Lead

**Actor:** User

**Description:** This use case outlines the process of qualifying a lead.

**Preconditions:**
- User is logged into the system.
- There is at least one lead in the "New" stage.

**Flow of Events:**
1. User selects a lead in the "New" stage.
2. User reviews lead details.
3. User determines if the lead is qualified.
4. User updates the lead status to "Qualified".

**Postconditions:**
- The lead is moved to the "Qualified" stage.

### 3.3 Use Case 3: Move Lead to Proposition Stage

**Actor:** User

**Description:** This use case covers the process of advancing a lead to the "Proposition" stage.

**Preconditions:**
- User is logged into the system.
- There is at least one lead in the "Qualified" stage.

**Flow of Events:**
1. User selects a lead in the "Qualified" stage.
2. User reviews lead details and prepares a proposition.
3. User updates the lead status to "Proposition".

**Postconditions:**
- The lead is moved to the "Proposition" stage.

### 3.4 Use Case 4: Negotiate Lead

**Actor:** User

**Description:** This use case describes the negotiation process for a lead.

**Preconditions:**
- User is logged into the system.
- There is at least one lead in the "Proposition" stage.

**Flow of Events:**
1. User selects a lead in the "Proposition" stage.
2. User initiates negotiations with the lead.
3. User updates the lead status to "Negotiation".

**Postconditions:**
- The lead is moved to the "Negotiation" stage.

### 3.5 Use Case 5: Mark Lead as Won

**Actor:** User

**Description:** This use case covers the process of marking a lead as "Won".

**Preconditions:**
- User is logged into the system.
- There is at least one lead in the "Negotiation" stage.

**Flow of Events:**
1. User selects a lead in the "Negotiation" stage.
2. User successfully negotiates and closes the lead.
3. User updates the lead status to "Won".

**Postconditions:**
- The lead is marked as "Won".

### 3.6 Use Case 6: Generate Reports

**Actor:** User

**Description:** This use case outlines the process of generating reports on lead activities.

**Preconditions:**
- User is logged into the system.

**Flow of Events:**
1. User navigates to the "Reports" section

## System Architecture

### 4.1 Frontend

- Angular Framework

### 4.2 Backend

- Spring Boot

### 4.3 Database

- MySQL

### 4.4 External APIs

- Email API

## Testing

### 5.1 Unit Testing

The purpose of unit testing is to verify that individual units of code function as intended. It ensures that each component of the system works correctly in isolation.

### 5.2 Integration Testing

Integration testing verifies that different modules or components of the system work together as intended when integrated. It ensures that interactions between various units do not cause unexpected behavior.

