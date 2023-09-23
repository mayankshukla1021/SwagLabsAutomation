Feature: check Functionality
@Reg
Scenario: checkout with valid firstname and postalcode
When user enter "standard_user" and "secret_sauce" details
And user click on login button
And user click on add to cart button
Then Validate cartcount is "1"
And user navigate to checkout page
And user enter personal details "tyrant" "captain" "100230" 
And user click on continue button 
Then Validate user navigate to checkout page two

