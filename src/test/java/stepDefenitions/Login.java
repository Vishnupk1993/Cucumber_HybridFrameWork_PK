package stepDefenitions;

import org.openqa.selenium.WebDriver;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import utils.commonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	
	
	
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		 
		driver=DriverFactory.getDriver();
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage=homepage.selectLoginOption();
	
	}

	@When("^User enters valid email address (.+) into the email field$")
	public void user_enters_valid_email_address_into_the_email_field(String emailText) {
		
		loginpage.enterEmailAddress(emailText);
			     
	}

	@When("^User enters valid password (.+) in the password field$")
	public void user_enters_valid_password_in_the_password_field(String passwrordText) {
		loginpage.enterPassword(passwrordText);
		
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		accountpage=loginpage.selectLoginButton();
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(accountpage.displayStatusofEditYourAccountInformation(commonUtils.getEmailwithTimestamp()));
	   
	}

	@When("User enters invalid email address into the email field")
	public void user_enters_invalid_email_address_into_the_email_field() {
		
		loginpage.enterEmailAddress(commonUtils.getEmailwithTimestamp());
		
	    
	}

	@When("User enters invalid password {string} in the password field")
	public void user_enters_invalid_password_in_the_password_field(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);
		
	    
	}

	@Then("User should get a warning message about invalid credentials")
	public void user_should_get_a_warning_message_about_invalid_credentials() {
		
		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	    
	}

	@When("User dont enter any email adderess in the email field")
	public void user_dont_enter_any_email_adderess_in_the_email_field() {
		
		loginpage.enterEmailAddress("");
		
	}

	@When("User dont enter any email password in the password field")
	public void user_dont_enter_any_email_password_in_the_password_field() {
		loginpage.enterPassword("");
	    
	}
	
	

}
