#Author: manjumadhu0913@gmail.com
#Keywords Summary : Positive test

Feature: As a system administrator I want to be able to add new user to a authorization system

Scenario Outline: Adding valid users to the Authorization system
Given the user is in home page
When we enter <username> and <fullname> and <password>
And click on log in button
Then <username> and <fullname> and <password> should be added to authorization system
And status should be displayed

Examples:
|username | fullname        | password|
|Tom      | Tom simon       | test@123|
|Jerry    | Jerry Home      | 12test  | 
|Bob      | Bob test builder| @1234b  |

