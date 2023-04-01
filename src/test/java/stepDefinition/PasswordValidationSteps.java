package stepDefinition;

import io.cucumber.java.en.Then;
import dependencyinjection.TestContextSetup;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PasswordValidationSteps {
	
	TestContextSetup testContext;
	
	public PasswordValidationSteps(TestContextSetup testContext) {
		this.testContext = testContext;
	}
	
	@Then("{string} should be displayed")
    public void status_password_does_not_conform_rules_should_be_displayed(String message) throws Throwable {
       String error = testContext.pageobjectmanager.getHomePage().getErrorMsg();
       assertEquals(error, message);
    }

}
