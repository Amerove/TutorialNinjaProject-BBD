package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDroplist;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	
	public void accountDroplist() {
		
		elementUtils.clicOnElement(myAccountDroplist, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage clickOnLoginOption() {
		
		elementUtils.clicOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public void clickOnRegisterOption() {
		
		elementUtils.clicOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage navigateToLoginPage() {
		
		accountDroplist();
		return clickOnLoginOption();
	}
	
	public RegisterPage namvigateToRegisterPage() {
		
		accountDroplist();
		clickOnRegisterOption();
		return new RegisterPage(driver);
	}
}
