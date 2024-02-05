package stepdefinitions;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

import org.junit.Assert;

public class Search {
	
	WebDriver driver;
	private SearchPage sp = new SearchPage(driver);
	
	@Given("User open the application")
	public void user_open_the_application() {
		
		driver = DriverFactory.getDriver();
		sp = new SearchPage(driver);
		sp.clickIntoTheSearchBox();
		System.out.println(">> User has opened the application");
	    
	}

	@When("User enter valid product into search field")
	public void user_enter_valid_product_into_search_field() {
		
		sp.enterProduct("HP");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	  
		sp.clickOnSearchButton();	
	}

	@Then("Valid product should get displayed in results")
	public void valid_product_should_get_displayed_in_results() {
		
		Assert.assertEquals("HP LP3065", sp.productDisplayChecking());
	}

	@When("User enter invalid product into search field")
	public void user_enter_invalid_product_into_search_field() {
		
		sp.clickIntoTheSearchBox();
		sp.enterProduct("HONDA");
	}

	@Then("Warning message will be displayed")
	public void warning_message_will_be_displayed() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", sp.invalidSearchWarningMessage());
	}

	@When("User does not enter any product")
	public void user_does_not_enter_any_product() {
		
		sp.clickOnSearchButton();
		Assert.assertEquals("There is no product that matches the search criteria.", sp.invalidSearchWarningMessage());

	}


}
