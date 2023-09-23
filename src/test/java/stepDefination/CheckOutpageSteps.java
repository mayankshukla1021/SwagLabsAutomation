package stepDefination;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckoutPage;

public class CheckOutpageSteps {
	CheckoutPage checkout = new CheckoutPage();
	@Then("user enter personal details {string} {string} {string}")
	public void user_enter_personal_details(String Fname, String Lname, String Pcode) {
		checkout.user_enter_personal_details(Fname, Lname, Pcode);
   
	
	}
	@And ("user click on continue button")
	public void user_click_on_continue_button() {
		checkout.ClickOnContinuebtn(); 
	}
	@Then ("Validate user navigate to checkout page two")
	public void Validate_user_navigate_to_checkout_page_two() {
		checkout.Validate_user_navigate_to_checkout_page_two();
	}
}
