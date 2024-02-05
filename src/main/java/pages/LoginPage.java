package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(linkText="Edit your account information")
	private WebElement accountCreationConfirmation;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement noEmailOrPasswordMessage;
	
	
	
	public void enterEmailAddress(String email) {
		
		elementUtils.typeTextIntoElement(emailAddressField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String password) {
		
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnLoginButton() {
		
		elementUtils.clicOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean accountCreationMessage() {
		
		return elementUtils.textIsDisplayed(accountCreationConfirmation, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean emptyEmailOrPasswordMessage() {
		
		return elementUtils.textIsDisplayed(noEmailOrPasswordMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
