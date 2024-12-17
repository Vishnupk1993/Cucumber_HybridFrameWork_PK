Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <userName> into the email field
And User enters valid password <password> in the password field
And User clicks on the Login button
Then User should get successfully logged in
Examples:
|userName                |password|
|vishnu.menon742@gmail.com|Test@2024|
|sasung@yopmail.com|Test@2024|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into the email field
And User enters invalid password "Taest@2024" in the password field
And User clicks on the Login button
Then User should get a warning message about invalid credentials

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "vishnu.menon742@gmail.com" into the email field
And User enters invalid password "123@2024" in the password field
And User clicks on the Login button
Then User should get a warning message about invalid credentials

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters valid email address "vishnu.abc742@gmail.com" into the email field
And User enters invalid password "Test@2024" in the password field
And User clicks on the Login button
Then User should get a warning message about invalid credentials

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter any email adderess in the email field
And User dont enter any email password in the password field
And User clicks on the Login button
Then User should get a warning message about invalid credentials





