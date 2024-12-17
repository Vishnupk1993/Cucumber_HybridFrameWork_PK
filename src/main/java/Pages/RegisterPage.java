package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementUtils elementutils; 
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils =new ElementUtils(driver);
	}
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	public void enterFirstName(String firstNameText)
	{
		
		elementutils.inputText(firstNameField, firstNameText, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	public void enterLastName(String lastNameText)
	{
		
		elementutils.inputText(lastNameField, lastNameText, commonUtils.EXPLICIT_WAIT_TIME);
	}

	@FindBy(id="input-email")
	private WebElement emailField;
	public void enterEmailAddress(String emailText)
	{
		
		elementutils.inputText(emailField, emailText, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	public void enterTelephoneNumber(String telephoneText) {
	
		elementutils.inputText(telephoneField, telephoneText, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	public void enterPasswordText(String passwordText)
	{
		
		elementutils.inputText(passwordField, passwordText, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	public void enterconfirmPassword(String passwordText)
	{
		elementutils.inputText(confirmPassword, passwordText, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	@FindBy(name="agree")
	private WebElement pricavayLink;
	public void selectPrivacyPolicy()
	{
		elementutils.clickOnElement(pricavayLink, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement SelectContinueButton;
	public AccountSuccessPage selectContinueButton()
	{
		
		elementutils.clickOnElement(SelectContinueButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesToNewsLetter;
	public void selectYesNewsLettercheckBox()
	{
		elementutils.clickOnElement(yesToNewsLetter, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMessage;
	public String getWarningMessageText()
	{
		return elementutils.getTextFromElement(WarningMessage, commonUtils.EXPLICIT_WAIT_TIME);
		
		
	}
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	public String getFirstNameWarningmessage()
	{
		return elementutils.getTextFromElement(firstNameWarning,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	public String getLastNameWarning()
	{
		return elementutils.getTextFromElement(lastNameWarning,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	public String getEmailWarning()
	{
		return elementutils.getTextFromElement(emailWarning,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	public String getTelephoneWarning()
	{
		return elementutils.getTextFromElement(telephoneWarning,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	public String getPasswordWarningmessage()
	{
		return elementutils.getTextFromElement(passwordWarning,commonUtils.EXPLICIT_WAIT_TIME);
	}
}
