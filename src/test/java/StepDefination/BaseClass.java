package StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomerPage addNewCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	
	
	//Generate Unique email ID
	public String generateEmailID() {
		return RandomStringUtils.randomAlphanumeric(5);
	}
	
}
