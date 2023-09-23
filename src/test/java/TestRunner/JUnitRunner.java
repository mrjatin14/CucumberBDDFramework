package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		//		features =".//Features/Customers.feature",
		//for execute multiple feature file
		//		features =".//Features/",
		//if we need to execute specific feature file then
		features =".//Features/LoginFeature.feature",
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
//		tags ="@Regression",
		plugin = {"pretty", "html:target/cucumber-reports/reports1.html"}



		//json & xml reports
		//		plugin = {"pretty", "json:target/cucumber-reports/reports_json_.json"}
		//		plugin = {"pretty", "xml:target/cucumber-reports/reports_xml.xml"}


		)

public class JUnitRunner {

}
