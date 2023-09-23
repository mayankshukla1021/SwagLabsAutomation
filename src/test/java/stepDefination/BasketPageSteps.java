package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasketPage;

public class BasketPageSteps {
	BasketPage basket = new BasketPage();

	@And("user click on add to cart button")
	public void user_click_on_add_to_cart_button() {
		basket.clickOnAddToCart();
	}

	@Then("Validate cartcount is {string}")
	public void Validate_cartcount(String count) {
		basket.validCartCount(count);
	}

	@And("user navigate to checkout page")
	public void user_navigate_to_checkout_page() {
		basket.user_navigate_to_checkout_page();
	}

}
