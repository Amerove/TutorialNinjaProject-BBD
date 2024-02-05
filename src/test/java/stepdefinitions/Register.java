package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private HomePage hp;
	private RegisterPage rp = new RegisterPage(driver);
	
	@Given("User navigate to Register Account page")
	public void User_navigate_to_Register_Account_page() {
		
		driver = DriverFactory.getDriver();
		hp = new HomePage(driver);
		hp.namvigateToRegisterPage();
	}

	@When("User enters below details into the fields")
	public void User_enters_below_details_into_the_fields(DataTable dataTable) {
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		rp = new RegisterPage(driver);
		rp.enterFirstname(map.get("firstname"));
		rp.enterLastname(map.get("lastname"));
		rp.enterEmailAddress(CommonUtils.generateEmailAddress());
		rp.enterTelephoneNumber(map.get("telephone"));
		rp.enterPassword(map.get("password"));
		rp.confirmPassword(map.get("password"));
	}
	
	@When("User enters below details with duplicated email into the fields")
	public void User_enters_below_details_with_duplicated_email_into_the_fields(DataTable dataTable) {
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		rp = new RegisterPage(driver);
		rp.enterFirstname(map.get("firstname"));
		rp.enterLastname(map.get("lastname"));
		rp.enterEmailAddress(map.get("email"));
		rp.enterTelephoneNumber(map.get("telephone"));
		rp.enterPassword(map.get("password"));
		rp.confirmPassword(map.get("password"));
	}

	@When("Click on Continue button")
	public void click_on_continue_button() {
		
		rp.clickOnContinue();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
		
		Assert.assertTrue(rp.accountSuccessfullyCreatedMessage());
	}

	@When("Select Yes for Newsletter")
	public void select_yes_for_newsletter() {
		
		rp.newsletterOptions();
	}

	@When("Select Privacy Policy field")
	public void select_privacy_policy_field() {
		
		rp.privcyPolcyBox();
	}

	@When("User does not enter details into any fields")
	public void user_does_not_enter_details_into_any_fields() {
		
		rp = new RegisterPage(driver);
		rp.clickOnContinue();
	}

	@Then("Warning messages should be displayed for the mandatory fields")
	public void warning_messages_should_be_displayed_for_the_mandatory_fields() {
		
		Assert.assertTrue(rp.polcyWarningMessage());
		Assert.assertTrue(rp.firstnameWarningMessage());
		Assert.assertTrue(rp.lastnameWarningMessage());
		Assert.assertTrue(rp.emailWarningMessage());
		Assert.assertTrue(rp.telephoneWarningMessage());
		Assert.assertTrue(rp.passwordWarningMessage());	
	}

	@Then("Wrning message informaing the user about the duplicated email")
	public void wrning_message_informaing_the_user_about_the_duplicated_email() {
		
		Assert.assertTrue(rp.duplicateEmailWarningMessage().contains("Warning: E-Mail Address is already registered!"));
	}

}
