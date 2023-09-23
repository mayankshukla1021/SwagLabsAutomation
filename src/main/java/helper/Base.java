package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	static {
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resource/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Before
	public void SetUp() {

		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "Chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			
			// option.addArguments("--headless");// for running test cases without opening
			// the browser.
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void selectValueFromDropdown(WebElement ele, String value, String type) {
		Select s = new Select(ele);
		switch (type) {
		case "ByVisibleText":
			s.selectByVisibleText(value);
			break;
		case "Byindex":
			s.selectByIndex(Integer.parseInt(value));
			break;
		case "Byvalue":
			s.selectByValue(value);
		}
	}

	/*
	 * alternate way to select the webelment form list/
	 * public void selectValueFromDropdownByVisibleText(WebElement ele, String value) 
	 * { Select s = new Select(ele);
	 * s.selectByVisibleText(value);
	 * 
	 * }
	 * public void selectValueFromDropdownByValue(WebElement ele, String value) {
	 * Select s = new Select(ele); 
	 * s.selectByValue(value);
	 * 
	 * } 
	 * public void selectValueFromDropdownByIndex(WebElement ele, int value) {
	 * Select s = new Select(ele); 
	 * s.selectByIndex(value);
	 * 
	 * }
	 */
	public void selectBootStrapDropdown(List<WebElement>list, String value) {
		for(WebElement ele:list) {
			String actualvalue=ele.getText();
			if(actualvalue.equals(value)) {
			ele.click();
			break;
		}
		}
		
	}
	/*alter way for bootBootStrapDropdown
	public void selctBootStrapDropdown2() {
		List<WebElement>country=driver.findElements(By.xpath(""));
		selectBootStrapDropdown(country, "india");
		
	}*/

	public void mouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
		
	}
	 
	public void Alertpopup(String action) {
        Alert alert = driver.switchTo().alert();
        if (action.equalsIgnoreCase("accept")) {
            alert.accept();
        } else if (action.equalsIgnoreCase("dismiss")) {
            alert.dismiss();
           
	}
	}
	public void waitForExpectedElement(WebElement ele, long wait) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(wait));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitforElementTobeClickable(WebElement ele, long wait) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(wait));
		w.until(ExpectedConditions.elementToBeClickable(ele));
		
		}
	public void clickonElement(WebElement ele) {
		waitforElementTobeClickable(ele, 10);
		try{
			ele.click();
		}catch(Exception e) {
			waitforElementTobeClickable(ele, 10);
			executorClickonElement(ele);
		}
		}
		public void executorClickonElement(WebElement ele){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",ele);
			js.executeScript("arguments[0].click();",ele);
			
			
		}
		public void validateText(WebElement ele, String expectedValue) {
			String acutalValue = ele.getText();
			org.junit.Assert.assertEquals(expectedValue, acutalValue );//  used for content comparison.
			org.junit.Assert.assertTrue("homepage logo nopesent", ele.isDisplayed()); //used for checking presence. 
			
		}
		public void switchFrame(String value) {
			switch(value) {
			case "name":
				driver.switchTo().frame(value);
				break;
			case "index":
				driver.switchTo().frame(Integer.parseInt(value));
				break;
			}
		}
		public void switchWindow(String title) {
			Set<String> allwindows= driver.getWindowHandles();
			for(String windowid:allwindows) {
				driver.switchTo().window(windowid);
				if(driver.getTitle().contains(title)){
				break;
				}
			}
		}
		public void clickOnCheckbox(WebElement  ele) {
			if (!ele.isSelected()) {
				clickonElement(ele);
			}		
		}
		@After
		public void tearDown(Scenario s) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File capturedScr = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(capturedScr, new File("Screenshot/"+s.getName()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.quit();
		}
		
	}



