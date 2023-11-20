package Ibanking.com.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ibanking.com.pageObject.LoginPage;
import Ibanking.com.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider = "LoginData")
public void loginDDT(String user, String pwd) throws InterruptedException
{
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(user);
	logger.info("username is provided");
	lp.setPassword(pwd);
	logger.info("pwd is provided");
	lp.clicksubmit();	
	Thread.sleep(3000);
	
	if(isAlertpresent()==true)
	{
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.info("login failed");
	}
	else 
	{
		
		Assert.assertTrue(true);
		logger.info("login passed");
		lp.clicklogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close logout alert
		driver.switchTo().defaultContent();
	}
}
	
	
	public boolean isAlertpresent()// user defined method to check alert is present or not 
	{
		try
		{
			
		driver.switchTo().alert();
					return true;
		} 
		catch(NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	@DataProvider(name ="LoginData")
	String [][] getData()
	{
		String path = System.getProperty("user.dir")+"/src/test/java/Ibanking/TestData/Bug list.xlsx" ;
		int rownum = XLUtils.getRowCount(path,"sheet1");
		int colcount = XLUtils.getCellCount(path,"sheet1",1);
		
		String logindata[][]= new String[rownum][colcount];
		for(int i=1; i<rownum; i++)
		{
			for(int j=0; j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellContent(path, "sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
	
	

}
