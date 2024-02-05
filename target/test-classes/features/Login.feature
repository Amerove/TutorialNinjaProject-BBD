@all
Feature: User Login
Registered user should be able to login to access account details

Background:
Given User navigates to login page
 
@login @validcredentials @smoke @regression 
Scenario Outline: Login with valid credentials
When User enters valid email <email>
And Enters valid password <password>
And click on the login button
Then Uuser should login successfully
Examples:
|			email 					 	| password |
|a0sandra0h3@gmail.com 	|Amer1406! |
|amotooricap1@gmail.com	| 12345		|
|amotooricap3@gmail.com	| 12345		|

@login @ivalidcredentials @smoke @regression
Scenario: Login with invalid credentials
When User enters invalid email "a0sandra@gmail.com"
And Enters invalid password "Amer14"
And click on the login button
Then Uuser should get a proper warning message

@login @validemailandinvalidpassword @regression
Scenario: Login with valid email and invalid password
When User enters valid email "a0sandra0h3@gmail.com"
And Enters invalid password "Amer14"
And click on the login button
Then Uuser should get a proper warning message
@login @invalidemailandvalidpassword @regression
Scenario: Login with invalid email and valid password
When User enters invalid email "a0sandra@gmail.com"
And Enters valid password "Amer1406!"
And click on the login button
Then Uuser should get a proper warning message
@login @nocredentials @regression
Scenario: Login without providing any credentials
When User wont enter any email
And Wont enter password
And click on the login button
Then Uuser should get a proper warning message