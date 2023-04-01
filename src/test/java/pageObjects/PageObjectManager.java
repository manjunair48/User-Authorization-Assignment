package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;

	public PageObjectManager(WebDriver driver) {
			this.driver = driver;
	}
	

	public HomePage homepage;
	
	
	public HomePage getHomePage() {	
		HomePage homepage = new HomePage(driver);
		return homepage;
	}

}
