package StepDefination;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilitise.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdef extends BaseClass {

	@Before
	public void setup() {
		readConfig = new ReadConfig();

		// Initialize Logger
		log = LogManager.getLogger("stepdef");

		String browser = readConfig.getBrowser();
		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver = null;
			break;

		}
		System.out.println("Initialization started...........");
		log.info("Steup Method Executed.....");
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		loginPage = new LoginPage(driver);
		addNewCustomerPage = new AddNewCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
		log.info("User launch chrome browser.....");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
		driver.get(URL);
		log.info("URL Open .....");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		log.info("Username and Password entered");
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPage.clickonLoginBtn();
		log.info("Clicked on Login Button");
	}

	/////////// Login Feature ///////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitleString = driver.getTitle();
		if (actualTitleString.contains(expectedTitle)) {
			log.warn("Test Passed: Login feature page title matched");
			Assert.assertTrue(true); // pass
		} else {
			log.warn("Test Failed: Login feature page title not matched..");
			Assert.assertFalse(false); // false
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		log.info("User clicked on Logout button");
		// Thread.sleep(4000);
		loginPage.clickonLogoutBtn();
	}

	/*
	 * @Then("close browser") public void close_browser() {
	 * log.info("Close the browser"); driver.close(); // driver.quit(); }
	 */

	//////////////// Add new Customer ////////////////////////
	@Then("User can view Dashboard page")
	public void user_can_view_dashboard_page() {
		log.info("Test Passed User can view Dashboard page");
		String actualTitle = addNewCustomerPage.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			log.info("user can view dashboard test passed.");
			Assert.assertTrue(true);
		} else {
			log.warn("user can view dashboard test failed.");
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		log.info("customer menu clicked");
		addNewCustomerPage.clickOnCustomersMenu();
		Thread.sleep(1000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustomerPage.clickOnCustomersMenuItem();
		log.info("customer menu item clicked");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustomerPage.clickOnAddnew();
		log.info("clicked on add new button.");
	}

	@Then("Page header should be {string}")
	public void page_header_should_be(String string) {
		String actualTitle = addNewCustomerPage.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		if (actualTitle.equals(expectedTitle)) {
			log.info("User can view Add new customer page- passed");
			Assert.assertTrue(true);
		} else {
			log.info("User can view Add new customer page- failed");
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
		log.info("customer information entered");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addNewCustomerPage.clickOnSave();
		log.info("clicked on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expectedConfirmationMsg)) {
			Assert.assertTrue(true);// pass
			log.info("User can view confirmation message - passed");
		} else {
			Assert.assertTrue(false);// fail
			log.warn("User can view confirmation message - failed");
		}
	}

	///////////// Search Customer by email////////////////
	@Then("Enter customer email")
	public void enter_customer_email() {
		searchCustomerPage.enterEmail("priti2@gmail.com");
		log.info("Email address entered");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(3000);
		searchCustomerPage.clickOnSearchBtn();
		log.info("Clicked on search button.");
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "priti2@gmail.com";

		// Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));
		if (searchCustomerPage.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
			log.info("User should found Email in the Search table - passed");
		} else {
			Assert.assertTrue(false);
			log.info("User should found Email in the Search table - passed");
		}
	}

	/////////////////// Search by customer Name ////////////////////
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

	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {
    if(scenario.isFailed()) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	}
	/*
	 * @After public void teardown(Scenario sc) {
	 * System.out.println("Tear Down method executed.."); if (sc.isFailed() == true)
	 * { // Convert web driver object to TakeScreenshot
	 * 
	 * String fileWithPath =
	 * "H:\\Eclipse Data\\CucumberFramework\\Screenshots\\failedScreenshot.png";
	 * TakesScreenshot scrShot = ((TakesScreenshot) driver);
	 * 
	 * // Call getScreenshotAs method to create image file File SrcFile =
	 * scrShot.getScreenshotAs(OutputType.FILE);
	 * 
	 * // Move image file to new destination File DestFile = new File(fileWithPath);
	 * 
	 * // Copy file at destination
	 * 
	 * try { FileUtils.copyFile(SrcFile, DestFile); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * driver.quit(); }
	 */
}
