# API Documentation
** This document contains information related to api ** 

### Update Lead Status

- **URL:** `/api/leads/{leadId}/status`
- **Method:** `PUT`
- **Tags:** `lead-controller`
- **Operation ID:** `updateLeadStatus`

#### Parameters

- **Path Parameters**
  - `leadId` (integer, int64) - *Required*

- **Query Parameters**
  - `newStatus` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `string`
      - 
### Update Lead

- **URL:** `/api/leads/allupdate/{leadId}`
- **Method:** `PUT`
- **Tags:** `lead-controller`
- **Operation ID:** `updateLead`

#### Parameters

- **Path Parameters**
  - `leadId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema:
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - `$ref`: `#/components/schemas/Lead`
### Create Lead

- **URL:** `/api/leads/create`
- **Method:** `POST`
- **Tags:** `lead-controller`
- **Operation ID:** `createLead`

#### Request Body

- Content Type: `application/json`
  - Schema: `FirstFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `string`
### Create Lead

- **URL:** `/api/leads/create`
- **Method:** `POST`
- **Tags:** `lead-controller`
- **Operation ID:** `createLead`

#### Request Body

- Content Type: `application/json`
  - Schema: `FirstFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `string`
### Search Leads

- **URL:** `/api/leads/search`
- **Method:** `GET`
- **Tags:** `lead-controller`
- **Operation ID:** `searchLeads`

#### Parameters

- **Query Parameters**
  - `searchType` (string) - *Required*
  - `query` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Lead`
### Get Lead by ID

- **URL:** `/api/leads/lead/{leadId}`
- **Method:** `GET`
- **Tags:** `lead-controller`
- **Operation ID:** `getLeadById`

#### Parameters

- **Path Parameters**
  - `leadId` (integer, int64) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - `$ref`: `#/components/schemas/Lead`
### Get All Leads

- **URL:** `/api/leads/all`
- **Method:** `GET`
- **Tags:** `lead-controller`
- **Operation ID:** `getAllLeads`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Lead`
### Delete Lead by ID

- **URL:** `/api/leads/delete/{leadId}`
- **Method:** `DELETE`
- **Tags:** `lead-controller`
- **Operation ID:** `deleteLeadById`

#### Parameters

- **Path Parameters**
  - `leadId` (integer, int64) - *Required*

#### Responses

- **200 OK**
  - Description: OK
### Update Account

- **URL:** `/api/accounts/update/{accountId}`
- **Method:** `PUT`
- **Tags:** `account-controller`
- **Operation ID:** `updateAccount`

#### Parameters

- **Path Parameters**
  - `accountId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema:
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - `$ref`: `#/components/schemas/Account`
### Create Account

- **URL:** `/api/accounts/create`
- **Method:** `POST`
- **Tags:** `account-controller`
- **Operation ID:** `createAccount`

#### Request Body

- Content Type: `application/json`
  - Schema:
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `string`
### Update Account Attributes

- **URL:** `/api/accounts/updatebyId/{accountId}`
- **Method:** `PATCH`
- **Tags:** `account-controller`
- **Operation ID:** `updateAccountAttributes`

#### Parameters

- **Path Parameters**
  - `accountId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema:
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      -
}
### Search Accounts

- **URL:** `/api/accounts/search`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `searchAccounts`

#### Parameters

- **Query Parameters**
  - `searchType` (string) - *Required*
  - `query` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Account`
### Search Accounts by State

- **URL:** `/api/accounts/search/state`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `searchAccountsByState`

#### Parameters

- **Query Parameters**
  - `state` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Account`
### Search Accounts by Email

- **URL:** `/api/accounts/search/email`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `searchAccountsByEmail`

#### Parameters

- **Query Parameters**
  - `email` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Account`
### Search Accounts by Company Name

- **URL:** `/api/accounts/search/companyName`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `searchAccountsByCompanyName`

#### Parameters

- **Query Parameters**
  - `companyName` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Account`
### Search Accounts by Active Status

- **URL:** `/api/accounts/search/active`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `searchAccountsByActiveStatus`

#### Parameters

- **Query Parameters**
  - `active` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Account`
### Get All Accounts

- **URL:** `/api/accounts/all`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `getAllAccounts`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Account`
### Get Account by ID

- **URL:** `/api/accounts/account/{accountId}`
- **Method:** `GET`
- **Tags:** `account-controller`
- **Operation ID:** `getAccountById`

#### Parameters

- **Path Parameters**
  - `accountId` (integer, int64) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - `$ref`: `#/components/schemas/Account`
### Delete Account by ID

- **URL:** `/api/accounts/delete/{accountId}`
- **Method:** `DELETE`
- **Tags:** `account-controller`
- **Operation ID:** `deleteAccountById`

#### Parameters

- **Path Parameters**
  - `accountId` (integer, int64) - *Required*

#### Responses

- **200 OK**
  - Description: OK
### Update Opportunity

- **URL:** `/api/opportunities/update/{opportunityId}`
- **Method:** `PUT`
- **Tags:** `opportunity-controller`
- **Operation ID:** `updateOpportunity`

#### Parameters

- **Path Parameters**
  - `opportunityId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref`: `#/components/schemas/OpportunityFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - `$ref`: `#/components/schemas/Opportunity`
### Create Opportunity

- **URL:** `/api/opportunities/create`
- **Method:** `POST`
- **Tags:** `opportunity-controller`
- **Operation ID:** `createOpportunity`

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref`: `#/components/schemas/OpportunityFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `string`
### Update Opportunity Attributes

- **URL:** `/api/opportunities/updatebyId/{opportunityId}`
- **Method:** `PATCH`
- **Tags:** `opportunity-controller`
- **Operation ID:** `updateOpportunityAttributes`

#### Parameters

- **Path Parameters**
  - `opportunityId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref`: `#/components/schemas/OpportunityFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*
### Search Opportunities by Status

- **URL:** `/api/opportunities/search/status`
- **Method:** `GET`
- **Tags:** `opportunity-controller`
- **Operation ID:** `searchOpportunitiesByStatus`

#### Parameters

- **Query Parameters**
  - `status` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Opportunity`
### Get Opportunity by ID

- **URL:** `/api/opportunities/opportunity/{opportunityId}`
- **Method:** `GET`
- **Tags:** `opportunity-controller`
- **Operation ID:** `getOpportunityById`

#### Parameters

- **Path Parameters**
  - `opportunityId` (integer, int64) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - `$ref`: `#/components/schemas/Opportunity`
### Get All Opportunities

- **URL:** `/api/opportunities/all`
- **Method:** `GET`
- **Tags:** `opportunity-controller`
- **Operation ID:** `getAllOpportunities`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Opportunity`
### Delete Opportunity by ID

- **URL:** `/api/opportunities/delete/{opportunityId}`
- **Method:** `DELETE`
- **Tags:** `opportunity-controller`
- **Operation ID:** `deleteOpportunityById`

#### Parameters

- **Path Parameters**
  - `opportunityId` (integer, int64) - *Required*

#### Responses

- **200 OK**
  - Description: OK

### Update Contact

- **URL:** `/api/contacts/update/{contactId}`
- **Method:** `PUT`
- **Tags:** `contact-controller`
- **Operation ID:** `updateContact`

#### Parameters

- **Path Parameters**
  - `contactId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref`: `#/components/schemas/ContactFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - `$ref`: `#/components/schemas/Contact`
### Create Contact

- **URL:** `/api/contacts/create`
- **Method:** `POST`
- **Tags:** `contact-controller`
- **Operation ID:** `createContact`

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref`: `#/components/schemas/ContactFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `string`
### Update Contact Attributes

- **URL:** `/api/contacts/updatebyId/{contactId}`
- **Method:** `PATCH`
- **Tags:** `contact-controller`
- **Operation ID:** `updateContactAttributes`

#### Parameters

- **Path Parameters**
  - `contactId` (integer, int64) - *Required*

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref`: `#/components/schemas/ContactFormDTO`
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - `$ref`: `#/components/schemas/Contact`
### Search Contacts

- **URL:** `/api/contacts/search`
- **Method:** `GET`
- **Tags:** `contact-controller`
- **Operation ID:** `searchContacts`

#### Parameters

- **Query Parameters**
  - `searchType` (string) - *Required*
  - `query` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Contact`
### Search Contacts by Phone

- **URL:** `/api/contacts/search/phone`
- **Method:** `GET`
- **Tags:** `contact-controller`
- **Operation ID:** `searchContactsByPhone`

#### Parameters

- **Query Parameters**
  - `phone` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Contact`
### Search Contacts by Name

- **URL:** `/api/contacts/search/name`
- **Method:** `GET`
- **Tags:** `contact-controller`
- **Operation ID:** `searchContactsByName`

#### Parameters

- **Query Parameters**
  - `name` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Contact`
### Search Contacts by Email

- **URL:** `/api/contacts/search/email`
- **Method:** `GET`
- **Tags:** `contact-controller`
- **Operation ID:** `searchContactsByEmail`

#### Parameters

- **Query Parameters**
  - `email` (string) - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Contact`
### Get Contact by ID

- **URL:** `/api/contacts/contact/{contactId}`
- **Method:** `GET`
- **Tags:** `contact-controller`
- **Operation ID:** `getContactById`

#### Parameters

- **Path Parameters**
  - `contactId` (integer) - *Required*
    - Format: `int64`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - `$ref`: `#/components/schemas/Contact`
### Get All Contacts

- **URL:** `/api/contacts/all`
- **Method:** `GET`
- **Tags:** `contact-controller`
- **Operation ID:** `getAllContacts`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
      - Items: 
        - `$ref`: `#/components/schemas/Contact`
### Delete Contact by ID

- **URL:** `/api/contacts/delete/{contactId}`
- **Method:** `DELETE`
- **Tags:** `contact-controller`
- **Operation ID:** `deleteContactById`

#### Parameters

- **Path Parameters**
  - `contactId` (integer) - *Required*
    - Format: `int64`

#### Responses

- **200 OK**
  - Description: OK
### Get Authentication Token

- **URL:** `/api/auth/token`
- **Method:** `POST`
- **Tags:** `auth-controller`
- **Operation ID:** `token`

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref: #/components/schemas/LoginRequest`
  - Required: true

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `object`
### User Signup

- **URL:** `/api/auth/signup`
- **Method:** `POST`
- **Tags:** `auth-controller`
- **Operation ID:** `registerUser`

#### Request Body

- Content Type: `application/json`
  - Schema: `$ref: #/components/schemas/SignUpRequest`
  - Required: true

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `string`
### Get All Won Leads

- **URL:** `/dashboard/won-leads`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getAllWonLeads`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `array`
        - Items: `$ref: #/components/schemas/QualifiedLead`
### Get Total Won Leads Count

- **URL:** `/dashboard/totalWonLeadsCount`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getTotalWonLeads`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `integer`
        - Format: `int32`
### Get Total Weighted Revenue

- **URL:** `/dashboard/totalWeightedRevenue`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getTotalWeightedRevenue`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `number`
        - Format: `double`
### Get Total Lost Leads Count

- **URL:** `/dashboard/totalLostLeadsCount`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getTotalLostLeads`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `integer`
        - Format: `int32`
### Get Total Lead Count

- **URL:** `/dashboard/totalLeadCount`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getTotalLeadCount`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `integer`
        - Format: `int32`
### Get Total Expected Revenue

- **URL:** `/dashboard/totalExpectedRevenue`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getTotalExpectedRevenue`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - Type: `number`
        - Format: `double`
### Get Lead Counts By Status

- **URL:** `/dashboard/status`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getLeadCountsByStatus`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `object`
        - Additional Properties:
          - Type: `integer`
            - Format: `int32`
### Get Lead Counts By Source

- **URL:** `/dashboard/source`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getLeadCountsBySource`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `object`
        - Additional Properties:
          - Type: `integer`
            - Format: `int32`
### Get Lead Counts By Region

- **URL:** `/dashboard/region`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getLeadCountsByRegion`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `object`
        - Additional Properties:
          - Type: `integer`
            - Format: `int32`
### Get Lead Counts By Products

- **URL:** `/dashboard/products`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getLeadCountsByProducts`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `object`
        - Additional Properties:
          - Type: `integer`
            - Format: `int32`
### Get All Lost Leads

- **URL:** `/dashboard/lost-leads`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getAllLostLeads`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `array`
        - Items:
          - `$ref`: `#/components/schemas/UnqualifiedLead`
### Get All Lead Probabilities

- **URL:** `/dashboard/lead-probabilities`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getAllLeadProbabilities`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `array`
        - Items:
          - Type: `number`
            - Format: `double`
### Get All Expected Revenues

- **URL:** `/dashboard/expected-revenues`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getAllExpectedRevenues`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `array`
        - Items:
          - Type: `number`
            - Format: `double`
### Get Conversion Rate

- **URL:** `/dashboard/convertionRate`
- **Method:** `GET`
- **Tags:** `dashboard-controller`
- **Operation ID:** `getConversionRate`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema:
      - Type: `number`
        - Format: `double`
# Schemas

## OpportunityFormDTO

- Type: object

| Property           | Type   | Format   |
|-------------------|--------|----------|
| requiredQuantity   | integer| int32    |
| expectedRevenue    | number | double   |
| probability        | number | double   |
| expectedClosingDate| string | date-time|
| products           | string |          |
| status             | string |          |
| source             | string |          |
| accountName        | string |          |

## Account

- Type: object

| Property       | Type   | Format   |
|---------------|--------|----------|
| account_id     | integer| int64    |
| companyName    | string |          |
| address        | string |          |
| state          | string |          |
| region         | string |          |
| website        | string |          |
| typeOfBusiness | string |          |
| phone          | string |          |
| email          | string |          |
| typeOfAccount  | string |          |
| active         | string |          |
| contacts       | array  |          |
| opportunities  | array  |          |

## Contact

- Type: object

| Property     | Type   | Format   |
|-------------|--------|----------|
| contact_id   | integer| int64    |
| name         | string |          |
| email        | string |          |
| phone        | string |          |
| jobTitle     | string |          |
| accountName  | string |          |
| leadSource   | string |          |
| account      | [Account](#account) |

## Opportunity

- Type: object

| Property           | Type   | Format   |
|-------------------|--------|----------|
| id                | integer| int64    |
| requiredQuantity   | integer| int32    |
| expectedRevenue    | number | double   |
| probability        | number | double   |
| expectedClosingDate| string | date-time|
| products           | string |          |
| status             | string |          |
| source             | string |          |
| accountName        | string |          |
| owner              | [User](#user)   |
| account            | [Account](#account) |

## User

- Type: object

| Property   | Type   | Format   |
|-----------|--------|----------|
| id        | integer| int32    |
| name      | string |          |
| password  | string |          |
| role      | string |          |

## FirstFormDTO

- Type: object

| Property           | Type   | Format   |
|-------------------|--------|----------|
| name               | string |          |
| companyName        | string |          |
| email              | string |          |
| phone              | string |          |
| jobTitle           | string |          |
| address            | string |          |
| state              | string |          |
| region             | string |          |
| website            | string |          |
| typeOfBusiness     | string |          |
| requiredQuantity   | integer| int32    |
| expectedRevenue    | number | double   |
| probability        | number | double   |
| products           | string |          |
| status             | string |          |
| source             | string |          |
| createdDate        | string | date-time|

## Lead

- Type: object

| Property   | Type   | Format   |
|-----------|--------|----------|
| leadId     | integer| int64    |
| newLead    | [NewLead](#newlead) |
| account    | [Account](#account) |
| contact    | [Contact](#contact) |
| opportunity| [Opportunity](#opportunity) |

## NewLead

- Type: object

| Property           | Type   | Format   |
|-------------------|--------|----------|
| newleadid          | integer| int64    |
| name               | string |          |
| companyName        | string |          |
| email              | string |          |
| phone              | string | maxLength: 10, minLength: 0 |
| jobTitle           | string |          |
| address            | string |          |
| state              | string |          |
| region             | string |          |
| website            | string |          |
| typeOfBusiness     | string |          |
| requiredQuantity   | integer| int32    |
| expectedRevenue    | number | double   |
| probability        | number | double   |
| products           | string |          |
| status             | string |          |
| source             | string |          |
| createdDate        | string | date-time|
| owner              | [User](#user)   |
## ContactFormDTO

- Type: object

| Property     | Type   |
|--------------|--------|
| name         | string |
| email        | string |
| phone        | string |
| jobTitle     | string |
| accountName  | string |
| leadSource   | string |

## AccountFormDTO

- Type: object

| Property       | Type   |
|----------------|--------|
| companyName    | string |
| address        | string |
| state          | string |
| region         | string |
| website        | string |
| typeOfBusiness | string |
| phone          | string |
| email          | string |
| typeOfAccount  | string |
| active         | string |

## LoginRequest

- Type: object
- Required:
  - username
  - password

| Property   | Type   |
|------------|--------|
| username   | string |
| password   | string |

## SignUpRequest

- Type: object
- Required:
  - username
  - password

| Property   | Type   |
|------------|--------|
| username   | string |
| password   | string |
| role       | string |

## QualifiedLead

- Type: object

| Property   | Type   | Format   |
|------------|--------|----------|
| id         | integer| int64    |
| newLead    | [NewLead](#newlead) |

## UnqualifiedLead

- Type: object

| Property   | Type   | Format   |
|------------|--------|----------|
| id         | integer| int64    |
| newLead    | [NewLead](#newlead) |

# Security Schemes

## Bearer Authentication

- Type: http
- Scheme: bearer
- Bearer Format: JWT
