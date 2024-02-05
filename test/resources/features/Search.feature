@all
Feature: Search Functionality

Background:
Given User open the application

@search @validproduct @smoke @regression
Scenario: Search for a valid product

When User enter valid product into search field
And Click on search button
Then Valid product should get displayed in results

@search @invalidproduct @regression
Scenario: Search for invalid product

When User enter invalid product into search field
And Click on search button
Then Warning message will be displayed

@search @noproduct @regression
Scenario: Search without provide any product

When User does not enter any product 
And Click on search button
Then Warning message will be displayed