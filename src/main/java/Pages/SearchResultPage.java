package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.commonUtils;

public class SearchResultPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils =new ElementUtils(driver);
	}
	@FindBy(linkText ="HP LP3065")
	private WebElement ValidProduct;
	public boolean searchProduct()
	{
		return elementutils.elementDisplayStatus(ValidProduct, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	public String getMessageText()
	{
		return elementutils.getTextFromElement(messageText, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
}
