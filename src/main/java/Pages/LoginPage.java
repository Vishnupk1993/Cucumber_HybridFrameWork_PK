package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils elementutils; 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils =new ElementUtils(driver);
	}
	@FindBy(id="input-email")
	private WebElement emailField;
	public void enterEmailAddress(String emailText)
	{
		elementutils.inputText(emailField, emailText, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	@FindBy(id="input-password")
	private WebElement passwordFiled;
	public void enterPassword(String passwrordText)
	{
		elementutils.inputText(passwordFiled, passwrordText, commonUtils.EXPLICIT_WAIT_TIME);
		 
	}
	
	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginButton;
	public AccountPage selectLoginButton()
	{
		elementutils.clickOnElement(loginButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new AccountPage(driver);
		
	}
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	public String getWarningMessageText() {
		
		return elementutils.getTextFromElement(warningMessage, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	
}
