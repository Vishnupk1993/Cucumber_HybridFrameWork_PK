package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;
import utils.commonUtils;

public class DriverFactory {
	static WebDriver driver=null;
	
	
	public static WebDriver initializeBrowser(String broserName)
	{

	
	{
		if(broserName.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(broserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		
	}
	 
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(commonUtils.PAGE_LOAD_TIME));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(commonUtils.IMPLICIT_WAIT_TIME));
	return driver;
}
	public static WebDriver getDriver()
	{
		return driver;
	} 
}