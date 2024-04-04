package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdef extends BaseClass {

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Initialization started...........");
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginPage = new LoginPage(driver);
		addNewCustomerPage = new AddNewCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
		driver.get(URL);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPage.clickonLoginBtn();
	}

	/////////// Login Feature ///////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitleString = driver.getTitle();
		if (actualTitleString.contains(expectedTitle)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertFalse(false); // false
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		loginPage.clickonLogoutBtn();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		// driver.quit();
	}

	//////////////// Add new Customer ////////////////////////
	@Then("User can view Dashboard page")
	public void user_can_view_dashboard_page() {
		String actualTitle = addNewCustomerPage.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		addNewCustomerPage.clickOnCustomersMenu();
		Thread.sleep(1000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustomerPage.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustomerPage.clickOnAddnew();
	}

	@Then("Page header should be {string}")
	public void page_header_should_be(String string) {
		String actualTitle = addNewCustomerPage.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		// addNewCustomerPage.enterEmail("priti213@gmail.com");
		addNewCustomerPage.enterEmail(generateEmailID() + "@gmail.com");
		addNewCustomerPage.enterPassword("test1");
		addNewCustomerPage.enterFirstName("Rohit");
		addNewCustomerPage.enterLastName("Sharma");
		addNewCustomerPage.enterGender("Male");
		addNewCustomerPage.enterDob("07/25/1996");
		addNewCustomerPage.enterCompanyName("india");
		addNewCustomerPage.selectTaxExempt();
		// addNewCustomerPage.selectNewsLetter("Test store 2");
		addNewCustomerPage.enterCustomerRoles("Administrators");
		addNewCustomerPage.enterManagerOfVendor("Vendor 2");
		addNewCustomerPage.enterAdminComment("Admin content");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addNewCustomerPage.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMsg)) {
			Assert.assertTrue(true);// pass
		} else {
			Assert.assertTrue(false);// fail
		}
	}

	///////////// Search Customer by email////////////////
	@Then("Enter customer email")
	public void enter_customer_email() {
		searchCustomerPage.enterEmail("priti2@gmail.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(3000);
		searchCustomerPage.clickOnSearchBtn();
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "priti2@gmail.com";

		// Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));
		if (searchCustomerPage.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	////// Search by customer Name ////////////////////
	@Then("Enter customer First Name")
	public void enter_customer_first_name() {
		searchCustomerPage.enterFirstName("Rohit");
	}

	@Then("Enter customer Last Name")
	public void enter_customer_last_name() {
		searchCustomerPage.enterLastName("Sharma");
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Rohit Sharma";

		if (searchCustomerPage.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@After
	public void teardown(Scenario sc) {
		System.out.println("Tear Down method executed..");
		if (sc.isFailed() == true) {
			// Convert web driver object to TakeScreenshot

			String fileWithPath = "H:\\Eclipse Data\\CucumberFramework\\Screenshots\\failedScreenshot.png";
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			// Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}

}
