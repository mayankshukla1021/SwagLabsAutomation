package stepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	LoginPage login = new LoginPage();
	
	@When("user enter {string} and {string} details")
	public void user_wnter_and_deatils(String username, String pass) {
	    login.user_enter_and_details(username, pass);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		login.user_click_on_login_button();
	   
	}

	@Then("Validate successfull login")
	public void validate_successfull_login() {
	    
	}
	@Then("validate error message")
	public void validate_error_message() {
		login.validate_error_msg();
	}

}
