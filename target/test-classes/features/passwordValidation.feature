#Author: manjumadhu0913@gmail.com
#Keywords Summary : Negative test


Feature: As a system administrator I want to disallow users with empty username, name or password

Scenario Outline: Validating users with empty username, name or password
Given the user is in home page
When we enter <username> and <full name> and <password>
And click on log in button
Then "Status: Password does not conform rules" should be displayed

Examples:
|username |full name | password|
|Tom      |Tomsimon  | t       |
|Jerry    |Jerryhome | 1*      |
|winnie   |winni po  | 1 6     |
|Bob      |Bon wayn  | %%%     |
