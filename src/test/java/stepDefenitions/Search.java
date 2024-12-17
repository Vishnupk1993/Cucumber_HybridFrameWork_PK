package stepDefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.SearchResultPage;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Search {
	WebDriver driver;
	private HomePage homepage;
	private SearchResultPage searchResults;
	

	@Given("User opens the applications")
	public void user_opens_the_applications() {
	
		driver=DriverFactory.getDriver();
	    
	}

	@When("user enters valid product {string} in to the search box")
	public void user_enters_valid_product_in_to_the_search_button(String validProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductInTosearchBox(validProductText);
		
		
	}
	
	@And("User clicks on the Search button")
	public void user_click_on_search_button() {
		searchResults=homepage.clickOnSearchButton();
		
	    
	}

	@Then("user should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {
		
		Assert.assertTrue(searchResults.searchProduct());
	}

	@When("user enter an invalid product {string} into the searchbox")
	public void user_enter_an_invalid_product_into_the_searchbox(String invalidProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductInTosearchBox(invalidProductText);
	    
	}

	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", searchResults.getMessageText());
		
	    
	}

	@When("user dont enter any product name in to the search box field")
	public void user_enter_any_product_name_in_to_the_search_box_field() {
		 homepage= new HomePage(driver);
	    	
	}

}
