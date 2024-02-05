package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {
	
	WebDriver driver;
	private HomePage hp;
	private LoginPage lp;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		hp = new HomePage(driver);
		lp = hp.navigateToLoginPage();
	}

	@When("^User enters valid email (.+)$")
	public void user_enters_valid_email(String email) {
		
	    lp.enterEmailAddress(email);
	}

	@When("^Enters valid password (.+)$")
	public void enters_valid_password(String password) {
	    
		lp.enterPassword(password);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		
		lp = new LoginPage(driver);
		lp.clickOnLoginButton();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		
		Assert.assertTrue(lp.accountCreationMessage());
	}

	@When("User enters invalid email")
	public void user_enters_invalid_email() { 
		
		lp.enterEmailAddress(CommonUtils.generateEmailAddress());
	}

	@When("Enters invalid password {string}")
	public void enters_invalid_password(String invalidPassword) {
		
		lp.enterPassword(invalidPassword);
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {
		
		Assert.assertTrue(lp.emptyEmailOrPasswordMessage());
	}

	@When("User wont enter any email")
	public void user_wont_enter_any_email() {
		
		System.out.println("No email");
	}

	@When("Wont enter password")
	public void wont_enter_password() {
		
		System.out.println("No password");

	}

}
