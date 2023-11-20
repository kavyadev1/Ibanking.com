package Ibanking.com.testcases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Ibanking.com.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver; 
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j2.properties");
		
		if (br.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver",readconfig.getChromeDriverPath());
		    driver = new ChromeDriver();
		}
		
		else if (br.equals("firefox")) 
		
		{
		    System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
		    driver = new FirefoxDriver();
		}
		
		else if (br.equals("ie")) {
		    System.setProperty("webdriver.ie.driver", readconfig.getIEDriverPath());
		    driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);

	
		

	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public class ScreenshotUtils {
	    
	    public  void captureScreenshot(WebDriver driver, String screenshotName)
	    {
	        // Convert WebDriver object to TakesScreenshot
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        
	        // Capture screenshot as a File
	        File source = ts.getScreenshotAs(OutputType.FILE);

	        // Define the destination folder and file name for the screenshot
	        String destinationPath = "screenshots/" + screenshotName + ".png";

	        try {
	            // Copy the screenshot file to the destination path
	            FileHandler.copy(source, new File(destinationPath));
	            System.out.println("Screenshot saved to: " + destinationPath);
	        } catch (IOException e) {
	            System.err.println("Error while capturing the screenshot: " + e.getMessage());
	        }
	    }
	}
	public String randomstring()
	{
		String generatestring = RandomStringUtils.randomAlphabetic(10);
		return (generatestring);
		
	}
}
