package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class CheckoutPage extends Base{
	public void user_enter_personal_details(String Fname, String Lname, String Pcode) {
		WebElement firstname=driver.findElement(By.cssSelector("input#first-name"));
		firstname.sendKeys(Fname);
		
		WebElement lastname=driver.findElement(By.cssSelector("input#last-name"));
		lastname.sendKeys(Lname);
		
		WebElement Postcode=driver.findElement(By.cssSelector("input#postal-code"));
		Postcode.sendKeys(Pcode);
		   
		
	}
	public void ClickOnContinuebtn() {
		WebElement conbutton=driver.findElement(By.cssSelector("input.btn_primary.cart_button"));
		clickonElement(conbutton);
	}
	public void Validate_user_navigate_to_checkout_page_two() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("checkout-step-two"));
	}
}
