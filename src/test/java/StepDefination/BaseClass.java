package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilitise.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomerPage addNewCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	public static Logger log;
	public ReadConfig readConfig;
	
	//Generate Unique email ID
	public String generateEmailID() {
		return RandomStringUtils.randomAlphanumeric(5);
	}
}
