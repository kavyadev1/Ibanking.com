package Ibanking.com.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Ibanking.com.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest()
	{
		
		
		
		logger.info("URL is open");
		//create object of loginpage
		LoginPage lp = new LoginPage(driver);
		
		//using objects we can call methods
		logger.info("enter username");
		lp.setUserName(username);
		logger.info("enter password");
		lp.setPassword(password);
		lp.clicksubmit();
		if (driver.getTitle().equals("Guru 99 Bank Manager homePage"))
		{
			Assert.assertTrue(true);
			logger.info("loggin passed");
		}
		else 
		{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			
		}

		
	}

	private void captureScreenshot(WebDriver driver, String string) {
		// TODO Auto-generated method stub
		
	}
	

}
