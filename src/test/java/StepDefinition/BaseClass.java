package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

//parent class
public class BaseClass {
	
	
	public static WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage SearchCustPg;
	public static Logger Log;
	public Properties readConfig;
	 
	
	public String generateEmailId()
	{
		return (RandomStringUtils.randomAlphabetic(5));
	}
	
	

}
