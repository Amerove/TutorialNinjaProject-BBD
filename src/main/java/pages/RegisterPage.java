package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='content']//following-sibling::h1")
	private WebElement accountCreationMessage;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsletterSelection;
	
	@FindBy(name = "agree")
	private WebElement policyCheckBox;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privcyWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstnameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	              
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailMessage;
	
	
	public void enterFirstname(String firstName) {
		
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastname(String lastName) {
		
		elementUtils.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmailAddress(String emailAddress) {
		
		elementUtils.typeTextIntoElement(emailField, emailAddress, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephoneNumber(String telephone) {
		
		elementUtils.typeTextIntoElement(telephoneField, telephone,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String password) {
		
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void confirmPassword(String confirmPassword) {
		
		elementUtils.typeTextIntoElement(passwordConfirmField, confirmPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnContinue() {
		
		elementUtils.clicOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean accountSuccessfullyCreatedMessage() {
		
		return accountCreationMessage.isDisplayed();
	}
	
	public void newsletterOptions() {
		
		elementUtils.clicOnElement(newsletterSelection, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void privcyPolcyBox() {
		
		elementUtils.clicOnElement(policyCheckBox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean polcyWarningMessage() {
		
		return elementUtils.textIsDisplayed(privcyWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean firstnameWarningMessage() {
		
		return elementUtils.textIsDisplayed(firstnameWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean lastnameWarningMessage() {
		
		return elementUtils.textIsDisplayed(lastnameWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean emailWarningMessage() {
		
		return elementUtils.textIsDisplayed(emailWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean telephoneWarningMessage() {
		
		return elementUtils.textIsDisplayed(telephoneWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public boolean passwordWarningMessage() {
		
		return elementUtils.textIsDisplayed(passwordWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String duplicateEmailWarningMessage() {
		
		return elementUtils.getTextFromElement(duplicateEmailMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
