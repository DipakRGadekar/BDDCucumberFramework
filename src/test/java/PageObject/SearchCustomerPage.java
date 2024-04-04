package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver lDriver;

	public SearchCustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id = "SearchEmail")
	WebElement inpSearchEmail;

	@FindBy(id = "search-customers")
	WebElement btnSearchCustomer;

	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	/*@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;*/
	
	@FindBy(id = "SearchFirstName")
	WebElement inpFirstName;

	@FindBy(id = "SearchLastName")
	WebElement inpuLastName;

	public void enterEmail(String email) {
		inpSearchEmail.sendKeys(email);
	}

	public void clickOnSearchBtn() {
		btnSearchCustomer.click();
	}

	public boolean searchCustomerByEmail(String email) {
		boolean found = false;

		// total no. of rows in a grid
		int ttlRows = tableRows.size();

		// total no. of columns
		// int ttlColumns = tableColumns.size();

		for (int i = 1; i <= ttlRows; i++)// to iterate all the rows of the grid
		{
		//	System.out.println("Searching row:" + i);

			WebElement webElementEmail = lDriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			// System.out.println(actualEmailAdd);

			if (actualEmailAdd.equals(email)) {
				found = true;
			}
		}
		return found;
	}

	//////////// Search customer By Name //////////////
	// Action method to enter FirstName
	public void enterFirstName(String firstName) {
		inpFirstName.sendKeys(firstName);
	}

	// Action method to enter LastName
	public void enterLastName(String lastName) {
		inpuLastName.sendKeys(lastName);
	}

	public boolean searchCustomerByName(String name) {
		boolean found = false;

		// total no. of rows in a grid
		int ttlRows = tableRows.size();

		for (int i = 1; i <= ttlRows; i++)// to iterate all the rows of the grid
		{
			// System.out.println("Searching row:" + i);

			WebElement webElementName = lDriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			String actualName = webElementName.getText();
			// System.out.println(actualName);

			if (actualName.equals(name)) {
				found = true;
				break;
			}
		}
		return found;
	}

}
