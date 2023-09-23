package StepDefinition;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


//child class
public class StepDefLogin extends BaseClass {


	@Before
	public void setup()
	{
		Log =  LogManager.getLogger("StepDefLogin");
		System.out.println("Setup method executed");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		Log.info("setup executes");
		//for the config properties
//		readConfig= new Properties();
//		try {
//			FileInputStream file = new FileInputStream(".Config.properties");
//			readConfig.load(file);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String browser = readConfig.getProperty("browser");
//	
	}
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
		SearchCustPg = new SearchCustomerPage(driver);
		Log.info("chrome browser launched");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.get(url);
		Log.info("url opened");

	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String pwd) 
	{
		loginPg.enterEmail(emailAdd);
		loginPg.enterPassword(pwd);
		Log.info("email address and password entered");

	}

	@And("Click on Login")
	public void click_on_login()
	{
		loginPg.clickOnLoginButton();
		Log.info("Clicked on login button");

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{

			Assert.assertTrue(true);//pass
			Log.warn("Test passed: Login feature :Page title matched.");
		}
		else
		{
			Assert.assertTrue(false);//fail
			Log.warn("Test Failed: Login feature- page title not matched.");
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() 
	{
		loginPg.clickOnLogOutButton();
		Log.info("user clicked on logout link.");

	}

/*	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
//		driver.quit();
		Log.info("Browser closed");

	}
	*/


	///////////////////////////////////////////////////////// Add new customer //////////////////////////////////////////////////////


	@Then("User can view Dashboad")
	public void user_can_view_dashboad() 
	{
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration" ;

		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true); //pass
			Log.info("user can view dashboard test passed.");
		}
		else 
		{
			Assert.assertTrue(false); //fail
			Log.warn("user can view dashboard test failed.");
		}

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() 
	{
		addNewCustPg.clickOnCustomersMenu();
		Log.info("customer menu clicked");

	}

	@And("click on customers Menu Item")
	public void click_on_customers_menu_item() 
	{
		addNewCustPg.clickOnCustomersMenuItem();
		Log.info("customer menu item clicked");

	}

	@And("click on Add new button")
	public void click_on_add_new_button() 
	{
		addNewCustPg.clickOnAddnew();
		Log.info("clicked on add new button.");

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration" ;


		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true); //pass
			Log.info("User can view Add new customer page- passed");
		}
		else 
		{
			Assert.assertTrue(false); //fail
			Log.info("User can view Add new customer page- failed");
		}


	}

	@When("User enter customer info")
	public void user_enter_customer_info()
	{
//		addNewCustPg.enterEmail("jio123@gmail.com");
		addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("text1");
		addNewCustPg.enterFirstName("Nikhil");
		addNewCustPg.enterLastName("Ahirwar");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDob("6/13/2000");
		addNewCustPg.enterCompanyName("TATA");
		addNewCustPg.enterAdminContent("AdminContent");
		addNewCustPg.enterManagerOfVendor("Vendor 2");
		
		Log.info("customer information entered");


	}

	@And("click on Save button")
	public void click_on_save_button() 
	{
		addNewCustPg.clickOnSave();
		Log.info("clicked on save button");

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) 
	{
		String bodyTagText =driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expectedConfirmationMsg))
		{
			Assert.assertTrue(true);
			Log.info("User can view confirmation message - passed");
		}
		else 
		{
			Assert.assertTrue(false);
			Log.warn("User can view confirmation message - failed");
		}

	}
	


	//////////////////////////////////////////// Search Customer /////////////////////////////////////////
	@And("Enter customer EMail")
	public void enter_customer_e_mail() {
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
		Log.info("Email address entered");


	}

	@When("Click on search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();
		Log.info("Clicked on search button.");


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( SearchCustPg.searchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
			Log.info("User should found Email in the Search table - passed");
			
		}
		else {
			
			Assert.assertTrue(false);
			Log.info("User should found Email in the Search table - passed");

		}

	}
	
//	/if the testcase is failed then it will capture screenshot 
	/*
	@After
	public  void  teardown(Scenario sc)
	{
		System.out.println("Tear Down method executed");
		if(sc.isFailed()==true)
		{
			
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create img file
			
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\Jatin\\eclipse-workspace\\CucumberBDDFramework\\Screenshot\\fullpage.png");
			
			//step3:  copy img file to destination --> for tht we use Apache common IO library
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}
	*/
	@AfterStep
	public void addScreenshot (Scenario scenario)  {
//		if we have to capture only failed test scenario screenshot then below statement will come under if else block
//		if (scenario.isFailed())
//		{

		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//attach img file report(data,media type, name of the attachment)
		scenario.attach(screenshot, "img/png", scenario.getName());
//		}

	}


	@BeforeStep
	public void  beforeStepMethodDemo()
	{
		System.out.println("This is before step.....");
	}

	@AfterStep
	public void  afterStepMethodDemo()
	{
		System.out.println("This is after step.....");
	}
	

	}








