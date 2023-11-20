package Ibanking.com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver ;
		PageFactory.initElements(rdriver, this);		
	}

	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
		}
	
	//public void custdob(String mm , String dd, String yyyy) {
		//Object txtdob;
		//txtdob.Sendkeys(mm); to month date year
		//txtdob.Sendkeys(dd);
		//txtdob.Sendkeys(yyyy);
		
//	}
}
