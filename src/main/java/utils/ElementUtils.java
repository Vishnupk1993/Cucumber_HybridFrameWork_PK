package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickOnElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	public void inputText(WebElement element, String inputText,long durationInSeconds)
	{
		
		WebElement webelement=waitForElement(element,durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(inputText);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	
	{
		WebElement webElement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
		
	}
	public void selectOptionsFromDropdown(WebElement element,String dropdownOption,long durationInSeconds)
	{
		WebElement webelement=waitForElement(element,durationInSeconds);
		Select select= new Select(webelement);
		select.selectByVisibleText(dropdownOption);
		select.selectByVisibleText(dropdownOption);
		select.selectByContainsVisibleText(dropdownOption);
		
	}
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert=waitforAlert(durationInSeconds);
		alert.accept();
	
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitforAlert(durationInSeconds);
		alert.dismiss();
	
	}
	
	public Alert waitforAlert(long durationInSeconds)
	{
		Alert alert =null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverandClick(WebElement element ,long durationInSeconds)

	{
		
		WebElement webelement=waitForVisibilityOfElement(element,durationInSeconds);
		Actions action = new Actions(driver);
		action.moveToElement(webelement).click().build().perform();
		
	}
	public WebElement waitForVisibilityOfElement(WebElement element ,long durationInSeconds)
	
	{
		WebElement webelement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webelement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
		
		
	}
	public void javaScriptClick(WebElement element ,long durationInSeconds)
	{
		WebElement webelement=waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeAsyncScript("arguments[0].click",webelement);
	}
	public void javaScriptTypeText(WebElement element, String inputText,long durationInSeconds)
	{
		WebElement webelement=waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+inputText+"'",webelement);
	}
	public String getTextFromElement(WebElement element ,long durationInSeconds)
	{
		WebElement webelement=waitForVisibilityOfElement(element,durationInSeconds);
		return webelement.getText();
	}
	
	public boolean elementDisplayStatus(WebElement element ,long durationInSeconds) {
		try {
		WebElement webelement=waitForVisibilityOfElement(element,durationInSeconds);
		return webelement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
		
	}
}
