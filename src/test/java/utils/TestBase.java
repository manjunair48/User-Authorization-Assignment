package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	public WebDriver webDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("QAUrl");
		
		if(driver == null) {
		  if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		  }
		  if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		  {	
            WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		  }
		  driver.get("http://localhost:4567/index");
		}
		return driver;
	}

}
