package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	WebDriver ldriver;

	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerMenu;
	@FindBy(xpath = " //a[@href='/Admin/Customer/List']//i/following-sibling::p")
	WebElement customers_menuitem;
	@FindBy(xpath = "//a[normalize-space()='Add new']")
	WebElement btnAddNew;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement inpEmail;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement inpPassword;
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement inpFirstName;
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement inpLastName;
	@FindBy(xpath = "//label[normalize-space()='Male']")
	WebElement MaleGender;
	@FindBy(xpath = "//label[normalize-space()='Female']")
	WebElement FemalGender;
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;
	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;
	@FindBy(id = "IsTaxExempt")
	WebElement chkTaxExempt;
	@FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']")
	WebElement newsletterListbox;
	@FindBy(xpath = "//li[normalize-space()='Your store name']")
	WebElement store1Option;
	@FindBy(xpath = "//li[contains(text(),'Test store 2')]")
	WebElement store2Option;
	@FindBy(xpath = "(//input[@role='listbox'])[2]")
	WebElement listCustomerRoles;
	@FindBy(xpath = "//li[normalize-space()='Administrators']")
	WebElement listItemAdministrators;
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;
	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	WebElement listItemForumModerators;
	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement listItemVendors;
	
	// VendorId
	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminComment;
	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;

	// Actions Methods for web elements

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickOnCustomersMenu() {
		customerMenu.click();
	}

	public void clickOnCustomersMenuItem() {
		customers_menuitem.click();
	}

	public void clickOnAddnew() {
		btnAddNew.click();
	}

	public void enterEmail(String email) {
		inpEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		inpPassword.sendKeys(password);
	}

	public void enterFirstName(String firstName) {
		inpFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		inpLastName.sendKeys(lastName);
	}

	public void enterGender(String gender) {
		if (gender.equals("Male")) {
			MaleGender.click();
		} else if (gender.equals("Female")) {
			FemalGender.click();
		} else// default set Male gender
		{
			MaleGender.click();
		}
	}

	public void enterDob(String dob) {
		txtDob.sendKeys(dob);
	}

	public void enterCompanyName(String coName) {
		txtCompanyName.sendKeys(coName);
	}

	public void selectTaxExempt() {
		chkTaxExempt.click();
	}

	// Method to select store from newsletter list
	public void selectNewsLetter(String storeName) throws InterruptedException {
		newsletterListbox.click();
		Thread.sleep(2000);// Click on the list box
		// Depending on the storeName parameter, select the corresponding option
		if (storeName.equals("Your store name")) {
			store1Option.click();
		} else if (storeName.equals("Test store 2")) {
			store2Option.click();
		} else {
			System.out.println("Invalid store name provided");
		}
	}

	public void enterCustomerRoles(String role) throws InterruptedException {
		// Click on the list box
		listCustomerRoles.click();
		Thread.sleep(3000);
		// Depending on the role parameter, select the corresponding option
		if (role.equals("Administrators")) {
			listItemAdministrators.click();
		} 
		else if (role.equals("Registered")) {
			listItemRegistered.click();
		}
		else if (role.equals("Guests")) {
			listItemGuests.click();
		}
		else if (role.equals("Forum Moderators")) {
			listItemForumModerators.click();
		}
		else if (role.equals("Vendors")) {
			listItemVendors.click();
		}
	}

	public void enterManagerOfVendor(String value) {
		Select drp = new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}

	public void enterAdminComment(String content) {
		txtAdminComment.sendKeys(content);
	}

	public void clickOnSave() {
		btnSave.click();
	}
}
