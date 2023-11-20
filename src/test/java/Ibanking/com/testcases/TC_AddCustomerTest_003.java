package Ibanking.com.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import Ibanking.com.pageObject.AddCustomerPage;
import Ibanking.com.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

		@Test
		public void addNewCustomer() throws InterruptedException 
		{
			LoginPage lp = new LoginPage(driver);
			lp.setUserName(username);
			lp.setPassword(password);
			lp.clicksubmit();
			Thread.sleep(3000);
			
			//create page objectclass object
			AddCustomerPage addcust = new AddCustomerPage(driver);
					addcust.clickAddNewCustomer();
					addcust.custName("kavya");
					addcust.custgender("female");
					addcust.custdob("10","15","1111");
					String email = randomstring()+"gmail.com";
					addcust.custemailid(email);
		           boolean res = driver.getPageSource().contains("customer registered successfully");
		           if(res==true)
		           {
		        	   Assert.assertTrue(true);
		           }
		           else
		           {
		        	   captureScreenshot(driver,"AddCustomerPage");
		        	   Assert.assertTrue(false);
		           }
					
			
		}
		
		
	}


