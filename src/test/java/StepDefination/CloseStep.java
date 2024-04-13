package StepDefination;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass{

	@Then("close browser")
	public void close_browser() {
		log.info("Close the browser");
		//driver.close();
		 driver.quit();
	}
}
