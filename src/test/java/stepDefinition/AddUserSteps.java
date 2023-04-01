package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dependencyinjection.TestContextSetup;

public class AddUserSteps {

	TestContextSetup testContext;
	String userName;
	Logger log ;  
	public AddUserSteps(TestContextSetup testContext) {
		this.testContext = testContext;
		log = Logger.getLogger(TestContextSetup.class.getName());
	}
	
 	@Given("^the user is in home page$")
    public void the_user_is_in_home_page() throws Throwable {
 	    log.info("launching the application"); 
        WebDriver driver = testContext.testbase.webDriverManager();
    }

    @When("^we enter (.+) and (.+) and (.+)$")
    public void we_enter_and_and(String username, String fullname, String password) throws Throwable {
    	log.info("Entering username"); 
        testContext.pageobjectmanager.getHomePage().setUsername(username);
    	log.info("Entering full name"); 
        testContext.pageobjectmanager.getHomePage().setFullName(fullname);
        log.info("Entering password"); 
        testContext.pageobjectmanager.getHomePage().setPassword(password);
    }
    
    @And("^click on log in button$")
    public void click_on_log_in_button() throws Throwable {
    	log.info("clicking on the login button");
    	try {
           testContext.pageobjectmanager.getHomePage().clickLogin();
    	}
    	catch(Exception e) {
    	   e.printStackTrace();
    	}
    }
    
    @Then("^(.+) and (.+) and (.+) should be added to authorization system$")
    public void and_should_be_added_to_authorization_system(String username, String fullname, String password) throws Throwable {
       userName = username;
       String userDetails = testContext.pageobjectmanager.getHomePage().getUserDetails();
       String expMsg = "Name: "+fullname+" login: "+username+" password "+password;
       System.out.println(fullname);
       System.out.println(expMsg);
       System.out.println("from web page");
       System.out.println(userDetails);
       assertEquals(userDetails,expMsg);
    }
    
    @And("^status should be displayed$")
    public void status_should_be_displayed() throws Throwable {
    	String status = testContext.pageobjectmanager.getHomePage().getStatus();
        assertEquals(status, "Status: user "+userName+" was created");
    } 
}
