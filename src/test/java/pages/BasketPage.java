package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class BasketPage extends Base {
		public void clickOnAddToCart() {
			WebElement addtocart =driver.findElement(By.cssSelector("button.btn_primary.btn_inventory"));
			clickonElement(addtocart);
		}
		public void validCartCount(String count) {
			WebElement Cartcount=driver.findElement(By.cssSelector("span.fa-layers-counter.shopping_cart_badge"));
				String cartvalue=Cartcount.getText();
				Assert.assertEquals(count, cartvalue);
		}
		public void user_navigate_to_checkout_page() {
			WebElement cartbtn=driver.findElement(By.cssSelector("a.shopping_cart_link"));
			clickonElement(cartbtn);
			WebElement checkoutbtn=driver.findElement(By.cssSelector("a.btn_action.checkout_button"));
			clickonElement(checkoutbtn);
		}
	
}

