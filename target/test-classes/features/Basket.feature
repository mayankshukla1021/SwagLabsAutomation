Feature: Basket Functionality

Background: User navigate to swag labs
When user enter "standard_user" and "secret_sauce" details
And user click on login button

@Reg
Scenario: verify user was able to add product in cart 
And user click on add to cart button
Then Validate cartcount is "1"