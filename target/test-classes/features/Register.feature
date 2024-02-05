@all
Feature: User Registration

Background: 
Given User navigate to Register Account page

@register @mandatoryfields @smoke @regression
Scenario: Register with mandatory fields
When User enters below details into the fields
|firstname|"Ash"|
|lastname|"albin"|
|email|"a0sandra@gmail.com"|
|telephone|"0123456789"|
|password|"aqws"|
And Select Privacy Policy field
And Click on Continue button
Then Account should get successfully created

@register @allfields @smoke @regression 
Scenario: Register with all fields

When User enters below details into the fields
|firstname|"Ash"|
|lastname|"albin"|
|email|"a0sand@gmail.com"|
|telephone|"0123456789"|
|password|"aqws"|
And Select Yes for Newsletter
And Select Privacy Policy field
And Click on Continue button
Then Account should get successfully created

@register @nodetails @regression
Scenario: Register without providing any field

When User does not enter details into any fields
And Click on Continue button
Then Warning messages should be displayed for the mandatory fields

@register @duplicateemail @regression
Scenario: Register will duplicate email address

When User enters below details into the fields
|firstname|"Ash"|
|lastname|"albin"|
|email|"a0sandra0h3@gmail.com"|
|telephone|"0123456789"|
|password|"aqws"|
And Select Yes for Newsletter
And Select Privacy Policy field
And Click on Continue button
Then Wrning message informaing the user about the duplicated email
