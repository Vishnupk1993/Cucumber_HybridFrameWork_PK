package stepDefenitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import utils.commonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	private  AccountSuccessPage accountsuccess;
	private commonUtils commonutils;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver=DriverFactory.getDriver();
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage=homepage.selectRegisterOption();
		
		driver.findElement(By.linkText("Register")).click();
		
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable){
		commonutils= new commonUtils() ;
		Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(commonutils.getEmailwithTimestamp());
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPasswordText(dataMap.get("password"));
		registerpage.enterconfirmPassword(dataMap.get("password"));

	    
	}

	@When("user selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registerpage.selectPrivacyPolicy();
		
	    
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountsuccess=registerpage.selectContinueButton();
			    
	}

  @Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	   accountsuccess= new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountsuccess.validatePageHeading());
	    
	}

	@When("users select Yes for newsletter")
	public void users_select_yes_for_newsletter() {
		registerpage.selectYesNewsLettercheckBox();
		
	    
	}
	
	@When("User enters the below fields with duplicate email")
	public void user_enter_Duplicate_email_for_accountRegistration(DataTable dataTable)
	{
		Map<String,String>dataMap=dataTable.asMap(String.class,String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(dataMap.get("email"));
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPasswordText(dataMap.get("password"));
		registerpage.enterconfirmPassword(dataMap.get("password"));
		
	}

	@Then("User account should get a proper warning messagea about duplicate email")
	public void user_account_should_get_a_proper_warning_messagea_about_duplicate_email() {
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	    
	}

	@When("User dont enters any details in to the fields")
	public void user_dont_enters_any_details_in_to_the_fields() {
		registerpage.enterFirstName("");
		registerpage.enterLastName("");
		registerpage.enterEmailAddress("");
		registerpage.enterTelephoneNumber("");
		registerpage.enterPasswordText("");
		registerpage.enterconfirmPassword("");
	    
	}

	@Then("should get proper warning message for every mandatory fields")
	public void should_get_proper_warning_message_for_every_mandatory_fields() {
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNameWarningmessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarningmessage());
 
	}
	public String getEmailwithTimestamp()
	{
		Date date = new Date();
		return "vishnu.menon"+date.toString().replace(" ", "_").replace(":","_" )+"@gmail.com";
	}

}
