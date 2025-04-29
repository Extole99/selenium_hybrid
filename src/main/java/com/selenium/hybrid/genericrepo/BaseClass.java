package com.selenium.hybrid.genericrepo;

import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	FileHandler fileHandler = new FileHandler();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite - Set up environment or config");
	}

	@BeforeGroups("regression")
	public void beforeGroups() {
		System.out.println("Before Groups - Setup before regression group tests");
	}

	@Parameters({"os", "browser"})
	@BeforeClass
	public void beforeClass(String os, String browser) throws Exception {
	    if (browser == null || browser.isEmpty()) { // Check for null or empty browser value
	        throw new Exception("Browser is null or empty in properties file!");
	    }
	    
	    logger = LogManager.getLogger(this.getClass());
	    String executionEnv = fileHandler.getDataFromPropertiesFile("execution_env");
	    String executionMode = fileHandler.getDataFromPropertiesFile("execution_mode");
	    logger.info("Execution environment: " + executionEnv);
	    logger.info("Operating System: " + os);
	    logger.info("Browser: " + browser);
	    logger.info("Execution mode : " + executionMode);

	    if (executionEnv.equalsIgnoreCase("local") && executionMode.equalsIgnoreCase("headless")) {
	        String browser1 = fileHandler.getDataFromPropertiesFile("browser1"); // <-- fix here
	        if (browser1 == null || browser1.isEmpty()) {
	            throw new Exception("Browser is null in properties file!");
	        }
	        switch (browser1.toLowerCase()) {
	        case "chrome":
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("--headless");
	            driver = new ChromeDriver(chromeOptions);
	            break;
	        case "edge":
	            EdgeOptions edgeOptions = new EdgeOptions();
	            edgeOptions.addArguments("--headless");
	            driver = new EdgeDriver(edgeOptions);
	            break;
	        default:
	            throw new Exception("No valid browser found: " + browser1);
	        }
	    } else if (executionEnv.equalsIgnoreCase("local")) {
	        String browser1 = fileHandler.getDataFromPropertiesFile("browser1");
	        if (browser1 == null || browser1.isEmpty()) { // Check for null or empty browser value
	            throw new Exception("Browser is null in properties file!");
	        }
	        switch (browser1.toLowerCase()) {
	        case "chrome":
	            driver = new ChromeDriver();
	            break;
	        case "edge":
	            driver = new EdgeDriver();
	            break;
	        case "firefox":
	            driver = new FirefoxDriver();
	            break;
	        default:
	            throw new Exception("No valid browser found: " + browser1);
	        }
	    } else if (executionEnv.equalsIgnoreCase("remote")) {
	        DesiredCapabilities capabilities = new DesiredCapabilities();

	        if (os == null || os.isEmpty()) { // Check for null or empty OS value
	            throw new Exception("Operating System is null or empty!");
	        }

	        switch (os.toLowerCase()) {
	        case "windows":
	            capabilities.setPlatform(Platform.WIN10);
	            break;
	        case "mac":
	            capabilities.setPlatform(Platform.MAC);
	            break;
	        default:
	            throw new Exception("No matching OS found: " + os);
	        }

	        // Browser Configuration
	        switch (browser.toLowerCase()) {
	        case "chrome":
	            ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
	            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	            capabilities.setBrowserName("chrome");
	            break;

	        case "edge":
	            EdgeOptions edgeOptions = new EdgeOptions();
	            edgeOptions.addArguments("--headless", "--disable-gpu");
	            capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
	            capabilities.setBrowserName("MicrosoftEdge");
	            break;

	        default:
	            throw new Exception("No valid browser found: " + browser);
	        }

	        String remoteUrl = fileHandler.getDataFromPropertiesFile("remote_url");
	        if (remoteUrl == null || remoteUrl.isEmpty()) { // Check for null or empty remote URL
	            throw new Exception("Remote URL is null or empty in properties file!");
	        }
	        driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
	    } else {
	        throw new Exception("Invalid execution environment: " + executionEnv);
	    }
	}

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void beforeMethod() throws Exception {
		if (driver == null) {
			throw new Exception("Driver is not initialized. Cannot proceed with test!");
		}
		driver.manage().window().maximize();
		driver.get(fileHandler.getDataFromPropertiesFile("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Paths.implicitlyWait));
		System.out.println("Browser & Url launched successfully");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method - Runs after each @Test method");
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver quit successfully");
		}
		System.out.println("After Class - Cleanup after all methods in class");
	}

	@AfterGroups("regression")
	public void afterGroups() {
		System.out.println("After Groups - Cleanup after regression group tests");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - Clean up environment or generate final reports");
	}
}
