Feature: Registration Functionality
Scenario: User creating an account only with mandatory fields
Given User navigates to Register Account page
When User enters the below fields
|firstName  |Vishnu                   |
|lastName   |pk                       | 
|telephone  |9605178926               |
|password   |Test@2024								| 
And user selects Privacy Policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the below fields
|firstName  |Vishnu                   |
|lastName   |pk                       | 
|telephone  |9605178926               |
|password   |Test@2024								| 
And users select Yes for newsletter
And user selects Privacy Policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an duplicate account with all fields
Given User navigates to Register Account page
When User enters the below fields with duplicate email
|firstName  |Vishnu                   |
|lastName   |pk                       | 
|email      |vishnu.menon742@gmail.com|
|telephone  |9605178926               |
|password   |Test@2024								| 
And users select Yes for newsletter
And user selects Privacy Policy
And User clicks on continue button
Then User account should get a proper warning messagea about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enters any details in to the fields
And User clicks on continue button
Then should get proper warning message for every mandatory fields