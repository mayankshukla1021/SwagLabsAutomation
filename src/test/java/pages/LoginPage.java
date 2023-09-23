package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class LoginPage extends Base {
	

	public void user_enter_and_details(String username, String pass) {
		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		userName.sendKeys(username);
		WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(pass);
}
	public void user_click_on_login_button() {
	WebElement loginbtn = driver.findElement(By.cssSelector("#login-button"));
	   clickonElement(loginbtn);
}
	public void validate_error_msg() {
		WebElement errmsg= driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertTrue(errmsg.isDisplayed());
}
}