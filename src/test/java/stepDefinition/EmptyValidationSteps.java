package stepDefinition;

import static org.testng.Assert.assertFalse;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dependencyinjection.TestContextSetup;

public class EmptyValidationSteps {
	int countBefore;
	TestContextSetup testContext;

	Logger log ; 
	public EmptyValidationSteps(TestContextSetup testContext) {
		this.testContext = testContext;
		log = Logger.getLogger(TestContextSetup.class.getName());
	}
	
	@When("^username and password is entered and fullName is blank$")
    public void username_and_password_is_entered(DataTable data)   {
		countBefore = testContext.pageobjectmanager.getHomePage().getCountOfUsersAdded();
		log.info("Count of the added user before validating blank spaces" +countBefore);
		List<List<String>> obj = data.asLists();
		
		testContext.pageobjectmanager.getHomePage().setUsername(obj.get(0).get(0));
        testContext.pageobjectmanager.getHomePage().setPassword(obj.get(0).get(1));
    }
	
	@And("^userdetails should not added to the authorization system$")
    public void userdetails_should_not_added_to_the_authorization_system() throws Throwable {
		int countAfter = testContext.pageobjectmanager.getHomePage().getCountOfUsersAdded();
		log.info("Count of the added user after validating blank spaces" +countAfter);
		Assert.assertTrue(countAfter==countBefore);
    }
	
	 @When("^username and fullName is entered and password is blank$")
	 public void username_and_fullname_is_entered_and_password_is_blank(DataTable data) throws Throwable {
		countBefore = testContext.pageobjectmanager.getHomePage().getCountOfUsersAdded();
		log.info("Count of the added user before validating blank spaces" +countBefore);
		List<List<String>> obj = data.asLists();
		testContext.pageobjectmanager.getHomePage().setUsername(obj.get(0).get(0));
        testContext.pageobjectmanager.getHomePage().setFullName(obj.get(0).get(1));
	 }
	 
	 
	 @When("^password and fullName is entered and username is blank$")
     public void password_and_fullname_is_entered_and_username_is_blank(DataTable data) throws Throwable {
	    countBefore = testContext.pageobjectmanager.getHomePage().getCountOfUsersAdded();
		log.info("Count of the added user before validating blank spaces" +countBefore);
		List<List<String>> obj = data.asLists();
		testContext.pageobjectmanager.getHomePage().setFullName(obj.get(0).get(0));
        testContext.pageobjectmanager.getHomePage().setFullName(obj.get(0).get(1));
     }
	 
	 @When("^all the fields are sent blank$")
     public void all_the_fields_are_sent_blank() throws Throwable {
	   countBefore = testContext.pageobjectmanager.getHomePage().getCountOfUsersAdded();
	   log.info("Count of the added user before validating blank spaces" +countBefore);
	   log.info("All the input fields are submitted blank");
     }
}
