package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


// @RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\Features\\",
		// features = ".\\Features\\Customer.feature",
		// features =
		// {".\\Features\\Customer.feature",".\\Features\\LoginFeature.feature"}
		glue = "StepDefination", 
		dryRun = false,
		// tags = @Sanity and @Regression, it will run both sanity and regression test
		// cases
		tags = "@Sanity", 
		monochrome = true, 
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
	
		//plugin = { "pretty", "html:target/Cucumber-Reports/reports1.html","junit:target/Cucumber-Reports/reports_xml.xml", "json:target/Cucumber-Reports/reports_json.json" })

public class Run extends AbstractTestNGCucumberTests {
// This will be empty
}
