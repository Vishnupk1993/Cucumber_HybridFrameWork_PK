Feature: Search functionality

Scenario: User search for a valid product
Given User opens the applications
When user enters valid product "HP" in to the search box
And User clicks on the Search button
Then user should get valid product displayed in search result

Scenario: User search for an invalid product
Given User opens the applications
When user enter an invalid product "Honda" into the searchbox
And User clicks on the Search button
Then user should get a message about no product matching

Scenario: user search without any product
Given User opens the applications
When user dont enter any product name in to the search box field
And User clicks on the Search button 
Then user should get a message about no product matching