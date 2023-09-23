@Reg
Feature: Login Functionality

@Reg
Scenario: login with valid credentials
When user enter "standard_user" and "secret_sauce" details
And user click on login button
Then Validate successfull login

Scenario: login with invalid credentials
When user enter "standard_userrr" and "seeecret_sauce" details
And user click on login button
Then validate error message


Scenario: login with valid username and invalid password credentials
When user enter "standard_user" and "secret_sauceee" details
And user click on login button
Then validate error message


Scenario: login with invalid username and valid password credentials
When user enter "standard_userrr" and "secret_sauce" details
And user click on login button
Then validate error message
