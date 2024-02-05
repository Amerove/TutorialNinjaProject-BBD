package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name = "search")
	private WebElement searchboxField;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement productDisplay;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement invalidSearchMessage;
	
	
	public void clickIntoTheSearchBox() {
		
		elementUtils.clicOnElement(searchboxField, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterProduct(String product) {
		
		elementUtils.typeTextIntoElement(searchboxField, product, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void clickOnSearchButton() {
		
		elementUtils.clicOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String productDisplayChecking() {
		
		return elementUtils.getTextFromElement(productDisplay, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String invalidSearchWarningMessage () {
		
		return elementUtils.getTextFromElement(invalidSearchMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
