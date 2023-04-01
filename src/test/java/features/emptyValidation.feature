#Author: manjumadhu0913@gmail.com
#Keywords Summary : Negative test

Feature: As a system administrator I want to disallow users with empty username, name or password

Scenario: Validation by sending fullName as Blank
Given the user is in home page
When username and password is entered and fullName is blank
|Tom Simon|Test23|
And click on log in button
Then "Status: Full name cannot be empty" should be displayed
And userdetails should not added to the authorization system

Scenario: Validation by sending Password as Blank
Given the user is in home page
When username and fullName is entered and password is blank
|Tom|Tom Simon|
And click on log in button
Then "Status: Password cannot be empty" should be displayed
And userdetails should not added to the authorization system

Scenario: Validation by sending username as Blank
Given the user is in home page
When password and fullName is entered and username is blank
|Test123|Tom Simon|
And click on log in button
Then "Status: Login cannot be empty" should be displayed
And userdetails should not added to the authorization system
