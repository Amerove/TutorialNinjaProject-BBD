package driverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;

public class DriverFactory {

	static WebDriver driver = null;
	
	public static WebDriver initializeBrowser(String browserName) {
		
	if(browserName.equals("chrome")) {
		driver = new ChromeDriver();
		
	}else if(browserName.equals("firefox")){
		driver = new FirefoxDriver();
		
	}else if(browserName.equals("edge")) {
		driver = new EdgeDriver();
	}else {
		System.out.println("The browser you have entered is not supported!");
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.LOADTIME));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICITLYWAIT));
	
	return driver;
	
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
