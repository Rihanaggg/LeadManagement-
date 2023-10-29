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
  - Schema: {
  "name": "string",
  "companyName": "string",
  "email": "string",
  "phone": "string",
  "jobTitle": "string",
  "address": "string",
  "state": "string",
  "region": "string",
  "website": "string",
  "typeOfBusiness": "string",
  "requiredQuantity": 0,
  "expectedRevenue": 0,
  "probability": 0,
  "products": "string",
  "status": "string",
  "source": "string",
  "createdDate": "2023-10-29T07:51:18.484Z"
}
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: {
  "leadId": 0,
  "newLead": {
    "newleadid": 0,
    "name": "string",
    "companyName": "string",
    "email": "string",
    "phone": "string",
    "jobTitle": "string",
    "address": "string",
    "state": "string",
    "region": "string",
    "website": "string",
    "typeOfBusiness": "string",
    "requiredQuantity": 0,
    "expectedRevenue": 0,
    "probability": 0,
    "products": "string",
    "status": "string",
    "source": "string",
    "createdDate": "2023-10-29T07:51:18.486Z",
    "owner": {
      "id": 0,
      "name": "string",
      "password": "string",
      "role": "string"
    }
  },
  "account": {
    "account_id": 0,
    "companyName": "string",
    "address": "string",
    "state": "string",
    "region": "string",
    "website": "string",
    "typeOfBusiness": "string",
    "phone": "string",
    "email": "string",
    "typeOfAccount": "string",
    "active": "string",
    "contacts": [
      {
        "contact_id": 0,
        "name": "string",
        "email": "string",
        "phone": "string",
        "jobTitle": "string",
        "accountName": "string",
        "leadSource": "string",
        "account": "string"
      }
    ],
    "opportunities": [
      "string"
    ]
  },
  "contact": {
    "contact_id": 0,
    "name": "string",
    "email": "string",
    "phone": "string",
    "jobTitle": "string",
    "accountName": "string",
    "leadSource": "string",
    "account": "string"
  },
  "opportunity": {
    "id": 0,
    "requiredQuantity": 0,
    "expectedRevenue": 0,
    "probability": 0,
    "expectedClosingDate": "2023-10-29T07:51:18.486Z",
    "products": "string",
    "status": "string",
    "source": "string",
    "accountName": "string",
    "owner": {
      "id": 0,
      "name": "string",
      "password": "string",
      "role": "string"
    },
    "account": {
      "account_id": 0,
      "companyName": "string",
      "address": "string",
      "state": "string",
      "region": "string",
      "website": "string",
      "typeOfBusiness": "string",
      "phone": "string",
      "email": "string",
      "typeOfAccount": "string",
      "active": "string",
      "contacts": [
        {
          "contact_id": 0,
          "name": "string",
          "email": "string",
          "phone": "string",
          "jobTitle": "string",
          "accountName": "string",
          "leadSource": "string",
          "account": "string"
        }
      ],
    
      "opportunities": [
        "string"
      ]
    }
  }
}
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
    - Schema:{
  "leadId": 0,
  "newLead": {
    "newleadid": 0,
    "name": "string",
    "companyName": "string",
    "email": "string",
    "phone": "string",
    "jobTitle": "string",
    "address": "string",
    "state": "string",
    "region": "string",
    "website": "string",
    "typeOfBusiness": "string",
    "requiredQuantity": 0,
    "expectedRevenue": 0,
    "probability": 0,
    "products": "string",
    "status": "string",
    "source": "string",
    "createdDate": "2023-10-29T08:13:49.440Z",
    "owner": {
      "id": 0,
      "name": "string",
      "password": "string",
      "role": "string"
    }
  },
  "account": {
    "account_id": 0,
    "companyName": "string",
    "address": "string",
    "state": "string",
    "region": "string",
    "website": "string",
    "typeOfBusiness": "string",
    "phone": "string",
    "email": "string",
    "typeOfAccount": "string",
    "active": "string",
    "contacts": [
      {
        "contact_id": 0,
        "name": "string",
        "email": "string",
        "phone": "string",
        "jobTitle": "string",
        "accountName": "string",
        "leadSource": "string",
        "account": "string"
      }
    ],
    "opportunities": [
      "string"
    ]
  },
  "contact": {
    "contact_id": 0,
    "name": "string",
    "email": "string",
    "phone": "string",
    "jobTitle": "string",
    "accountName": "string",
    "leadSource": "string",
    "account": "string"
  },
  "opportunity": {
    "id": 0,
    "requiredQuantity": 0,
    "expectedRevenue": 0,
    "probability": 0,
    "expectedClosingDate": "2023-10-29T08:13:49.440Z",
    "products": "string",
    "status": "string",
    "source": "string",
    "accountName": "string",
    "owner": {
      "id": 0,
      "name": "string",
      "password": "string",
      "role": "string"
    },
    "account": {
      "account_id": 0,
      "companyName": "string",
      "address": "string",
      "state": "string",
      "region": "string",
      "website": "string",
      "typeOfBusiness": "string",
      "phone": "string",
      "email": "string",
      "typeOfAccount": "string",
      "active": "string",
      "contacts": [
        {
          "contact_id": 0,
          "name": "string",
          "email": "string",
          "phone": "string",
          "jobTitle": "string",
          "accountName": "string",
          "leadSource": "string",
          "account": "string"
        }
      ],
      "opportunities": [
        "string"
      ]
    }
  }
} 
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
    - Schema:  {
    "leadId": 0,
    "newLead": {
      "newleadid": 0,
      "name": "string",
      "companyName": "string",
      "email": "string",
      "phone": "string",
      "jobTitle": "string",
      "address": "string",
      "state": "string",
      "region": "string",
      "website": "string",
      "typeOfBusiness": "string",
      "requiredQuantity": 0,
      "expectedRevenue": 0,
      "probability": 0,
      "products": "string",
      "status": "string",
      "source": "string",
      "createdDate": "2023-10-29T08:17:59.988Z",
      "owner": {
        "id": 0,
        "name": "string",
        "password": "string",
        "role": "string"
      }
    },
    "account": {
      "account_id": 0,
      "companyName": "string",
      "address": "string",
      "state": "string",
      "region": "string",
      "website": "string",
      "typeOfBusiness": "string",
      "phone": "string",
      "email": "string",
      "typeOfAccount": "string",
      "active": "string",
      "contacts": [
        {
          "contact_id": 0,
          "name": "string",
          "email": "string",
          "phone": "string",
          "jobTitle": "string",
          "accountName": "string",
          "leadSource": "string",
          "account": "string"
        }
      ],
      "opportunities": [
        "string"
      ]
    },
    "contact": {
      "contact_id": 0,
      "name": "string",
      "email": "string",
      "phone": "string",
      "jobTitle": "string",
      "accountName": "string",
      "leadSource": "string",
      "account": "string"
    },
    "opportunity": {
      "id": 0,
      "requiredQuantity": 0,
      "expectedRevenue": 0,
      "probability": 0,
      "expectedClosingDate": "2023-10-29T08:17:59.988Z",
      "products": "string",
      "status": "string",
      "source": "string",
      "accountName": "string",
      "owner": {
        "id": 0,
        "name": "string",
        "password": "string",
        "role": "string"
      },
      "account": {
        "account_id": 0,
        "companyName": "string",
        "address": "string",
        "state": "string",
        "region": "string",
        "website": "string",
        "typeOfBusiness": "string",
        "phone": "string",
        "email": "string",
        "typeOfAccount": "string",
        "active": "string",
        "contacts": [
          {
            "contact_id": 0,
            "name": "string",
            "email": "string",
            "phone": "string",
            "jobTitle": "string",
            "accountName": "string",
            "leadSource": "string",
            "account": "string"
          }
        ],
        "opportunities": [
          "string"
        ]
      }
    }
  }
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
    - Schema: {
  "leadId": 0,
  "newLead": {
    "newleadid": 0,
    "name": "string",
    "companyName": "string",
    "email": "string",
    "phone": "string",
    "jobTitle": "string",
    "address": "string",
    "state": "string",
    "region": "string",
    "website": "string",
    "typeOfBusiness": "string",
    "requiredQuantity": 0,
    "expectedRevenue": 0,
    "probability": 0,
    "products": "string",
    "status": "string",
    "source": "string",
    "createdDate": "2023-10-29T08:20:09.577Z",
    "owner": {
      "id": 0,
      "name": "string",
      "password": "string",
      "role": "string"
    }
  },
      - `$ref`: `#/components/schemas/Lead`
### Get All Leads

- **URL:** `/api/leads/all`
- **Method:** `GET`
- **Tags:** `lead-controller`
- **Operation ID:** `getAllLeads`

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: [
  {
    "leadId": 0,
    "newLead": {
      "newleadid": 0,
      "name": "string",
      "companyName": "string",
      "email": "string",
      "phone": "string",
      "jobTitle": "string",
      "address": "string",
      "state": "string",
      "region": "string",
      "website": "string",
      "typeOfBusiness": "string",
      "requiredQuantity": 0,
      "expectedRevenue": 0,
      "probability": 0,
      "products": "string",
      "status": "string",
      "source": "string",
      "createdDate": "2023-10-29T08:21:05.456Z",
      "owner": {
        "id": 0,
        "name": "string",
        "password": "string",
        "role": "string"
      }
    },
    "account": {
      "account_id": 0,
      "companyName": "string",
      "address": "string",
      "state": "string",
      "region": "string",
      "website": "string",
      "typeOfBusiness": "string",
      "phone": "string",
      "email": "string",
      "typeOfAccount": "string",
      "active": "string",
      "contacts": [
        {
          "contact_id": 0,
          "name": "string",
          "email": "string",
          "phone": "string",
          "jobTitle": "string",
          "accountName": "string",
          "leadSource": "string",
          "account": "string"
        }
      ],
      "opportunities": [
        "string"
      ]
    },
    "contact": {
      "contact_id": 0,
      "name": "string",
      "email": "string",
      "phone": "string",
      "jobTitle": "string",
      "accountName": "string",
      "leadSource": "string",
      "account": "string"
    },
    "opportunity": {
      "id": 0,
      "requiredQuantity": 0,
      "expectedRevenue": 0,
      "probability": 0,
      "expectedClosingDate": "2023-10-29T08:21:05.456Z",
      "products": "string",
      "status": "string",
      "source": "string",
      "accountName": "string",
      "owner": {
        "id": 0,
        "name": "string",
        "password": "string",
        "role": "string"
      },
      "account": {
        "account_id": 0,
        "companyName": "string",
        "address": "string",
        "state": "string",
        "region": "string",
        "website": "string",
        "typeOfBusiness": "string",
        "phone": "string",
        "email": "string",
        "typeOfAccount": "string",
        "active": "string",
        "contacts": [
          {
            "contact_id": 0,
            "name": "string",
            "email": "string",
            "phone": "string",
            "jobTitle": "string",
            "accountName": "string",
            "leadSource": "string",
            "account": "string"
          }
        ],
        "opportunities": [
          "string"
        ]
      }
    }
  }
]
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
  - Schema: {
  "companyName": "string",
  "address": "string",
  "state": "string",
  "region": "string",
  "website": "string",
  "typeOfBusiness": "string",
  "phone": "string",
  "email": "string",
  "typeOfAccount": "string",
  "active": "string"
}
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: {
  "account_id": 0,
  "companyName": "string",
  "address": "string",
  "state": "string",
  "region": "string",
  "website": "string",
  "typeOfBusiness": "string",
  "phone": "string",
  "email": "string",
  "typeOfAccount": "string",
  "active": "string",
  "contacts": [
    {
      "contact_id": 0,
      "name": "string",
      "email": "string",
      "phone": "string",
      "jobTitle": "string",
      "accountName": "string",
      "leadSource": "string",
      "account": "string"
    }
  ],
  "opportunities": [
    "string"
  ]
}
      - `$ref`: `#/components/schemas/Account`
### Create Account

- **URL:** `/api/accounts/create`
- **Method:** `POST`
- **Tags:** `account-controller`
- **Operation ID:** `createAccount`

#### Request Body

- Content Type: `application/json`
  - Schema:{
  "companyName": "string",
  "address": "string",
  "state": "string",
  "region": "string",
  "website": "string",
  "typeOfBusiness": "string",
  "phone": "string",
  "email": "string",
  "typeOfAccount": "string",
  "active": "string"
}
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
  - Schema: {
  "companyName": "string",
  "address": "string",
  "state": "string",
  "region": "string",
  "website": "string",
  "typeOfBusiness": "string",
  "phone": "string",
  "email": "string",
  "typeOfAccount": "string",
  "active": "string"
}
  - *Required*

#### Responses

- **200 OK**
  - Content Type: `*/*`
    - Schema: 
      - {
  "account_id": 0,
  "companyName": "string",
  "address": "string",
  "state": "string",
  "region": "string",
  "website": "string",
  "typeOfBusiness": "string",
  "phone": "string",
  "email": "string",
  "typeOfAccount": "string",
  "active": "string",
  "contacts": [
    {
      "contact_id": 0,
      "name": "string",
      "email": "string",
      "phone": "string",
      "jobTitle": "string",
      "accountName": "string",
      "leadSource": "string",
      "account": "string"
    }
  ],
  "opportunities": [
    "string"
  ]
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
