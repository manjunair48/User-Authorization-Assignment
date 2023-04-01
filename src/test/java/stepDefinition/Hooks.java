package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import dependencyinjection.TestContextSetup;

public class Hooks {
	TestContextSetup testContext;

	public Hooks(TestContextSetup testContext) {
	 	this.testContext = testContext;
	}
	
	@After
	public void AfterScenario() throws IOException {
		testContext.testbase.webDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException 
	{
		WebDriver driver =testContext.testbase.webDriverManager();
		if(scenario.isFailed())
		{	
			File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent;
			try {
				fileContent = FileUtils.readFileToByteArray(sourcePath);
				scenario.attach(fileContent, "image/png", "image");	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
