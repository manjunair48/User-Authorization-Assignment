package dependencyinjection;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinition.AddUserSteps;
import utils.TestBase;

public class TestContextSetup {
	
	public WebDriver driver;
	public PageObjectManager pageobjectmanager;
	public TestBase testbase;
	
	public TestContextSetup() throws IOException {
		testbase = new TestBase();
		pageobjectmanager = new PageObjectManager(testbase.webDriverManager());
	}	

}
