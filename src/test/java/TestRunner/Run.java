package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
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
		plugin = { "pretty", "html:target/Cucumber-Reports/reports1.html",
				"junit:target/Cucumber-Reports/reports_xml.xml", "json:target/Cucumber-Reports/reports_json.json" })

public class Run {
// This will be empty
}
