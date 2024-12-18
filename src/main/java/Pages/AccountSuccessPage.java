package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class AccountSuccessPage {
	WebDriver driver;
	private ElementUtils elementutils;
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils =new ElementUtils(driver);
	}
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement pageHeading;
	public String validatePageHeading()
	{
		return elementutils.getTextFromElement(pageHeading, commonUtils.EXPLICIT_WAIT_TIME);
	}

}
