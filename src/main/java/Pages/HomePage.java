package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils elementutils; 
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils =new ElementUtils(driver);
	}
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount_dropDown_Menu;
	
	@FindBy (linkText = "Login")
	private WebElement loginOption;
	public void clickOnMyAccount()
	{
		
		elementutils.clickOnElement(myAccount_dropDown_Menu, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public LoginPage selectLoginOption()
	{
		elementutils.clickOnElement(loginOption, 15);
		return new LoginPage(driver);
	}
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	public RegisterPage selectRegisterOption()
	{
		elementutils.clickOnElement(registerOption, commonUtils.EXPLICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBoxField;
	public void enterProductInTosearchBox(String ProductText)
	{
		elementutils.inputText(searchBoxField, ProductText, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	@FindBy(xpath="//button[contains(@class,'btn btn-d')]")
	private WebElement searchButton;
	public SearchResultPage clickOnSearchButton()
	{
		elementutils.clickOnElement(searchButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new SearchResultPage(driver);
	}

}
