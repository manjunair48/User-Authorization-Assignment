package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericUtils;

public class HomePage extends GenericUtils {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#username")
	private WebElement username;
	
	@FindBy(css="#name")
	private WebElement fullName;
	
	@FindBy(css="#password")
	private WebElement password;
	
	@FindBy(css="#submit")
	private WebElement btnLogin;
	
	@FindBy(css="#status")
	private WebElement status;
	
	@FindBy(css="#users")
	private List<WebElement> userDetails;
	
	@FindBy(css="#status")
	private WebElement errorMessage;
	
	@FindBy(css="#users")
	private List<WebElement> NoOfUsers;
	
	public void setUsername(String user) {
		username.sendKeys(user);
	}
	
	public void setFullName(String name) {
		fullName.sendKeys(name);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public String getStatus() {
		waitUntilElementAppears(status);
		return status.getText();
	}
	
	public String getUserDetails() {
		return userDetails.get(userDetails.size() - 1).getText();
	}
	
	public String getErrorMsg() {
	   waitUntilElementAppears(errorMessage);
	   return errorMessage.getText();
	}
	
	public int getCountOfUsersAdded() {
		return NoOfUsers.size();
	}	          
}
