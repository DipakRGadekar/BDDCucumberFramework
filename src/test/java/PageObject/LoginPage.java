package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement userID;

	@FindBy(id = "Password")
	WebElement userPWD;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginBtn;

	@FindBy(linkText = "Logout")
	WebElement logoutBtn;

	public void enterUsername(String User_Email) {
		userID.clear();
		userID.sendKeys(User_Email);
	}

	public void enterPassword(String User_PWD) {
		userPWD.clear();
		userPWD.sendKeys(User_PWD);
	}

	public void clickonLoginBtn() {
		loginBtn.click();
	}
	public void clickonLogoutBtn()  {
		 try {
		        Thread.sleep(4000); // Add a short sleep before the click (optional)
		    } catch (InterruptedException e) {
		        // Handle interruption if needed
		        e.printStackTrace();
		    }
		logoutBtn.click();
	}
}
