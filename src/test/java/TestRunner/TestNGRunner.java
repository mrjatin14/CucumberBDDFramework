package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

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
//		plugin = {"pretty", "html:target/cucumber-reports/reports1.html"}

		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)



public class TestNGRunner  extends AbstractTestNGCucumberTests{

}
