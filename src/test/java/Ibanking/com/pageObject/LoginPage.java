package Ibanking.com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
	
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);

	}
 @FindBy(name = "uid")
 WebElement txtUserName;
 
 @FindBy(name = "password")
 WebElement txtPassword;
 
 @FindBy(name = "btnLogin")
 WebElement btnlogin;
 
 @FindBy(xpath = "html/body/div[3]/div/ul/li[15]/a")
 WebElement lnklogout;
 
 public void setUserName(String uname)
 {
 txtUserName.sendKeys(uname); 
}
 public void setPassword(String pwd)
 {
 txtUserName.sendKeys(pwd); 
}
 public void clicksubmit()
 {
 btnlogin.click(); 
}
 public void clicklogout()
 {
	 lnklogout.click();
 }
}
 