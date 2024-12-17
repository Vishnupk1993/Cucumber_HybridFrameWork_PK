package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class AccountPage {
	WebDriver driver;
	private ElementUtils elementutils; 
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils =new ElementUtils(driver);
	}
	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement editYuourAccountInformationOption;
	public boolean displayStatusofEditYourAccountInformation(String emailText)
	{
		return elementutils.elementDisplayStatus(editYuourAccountInformationOption, commonUtils.EXPLICIT_WAIT_TIME);
	}

}
