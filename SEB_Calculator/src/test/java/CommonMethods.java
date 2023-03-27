

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//Simple open browser runner
	public static void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		getDriver().get("https://www.seb.lt/eng/private/calculator-leasing");
	}
	
	//Simple browser closing
	public static void closeBrowser() {
		getDriver().quit();
	}
	
	//Find web element by class name
	public static WebElement findWebElementById(String locator) {
		WebElement element = getDriver().findElement(By.id(locator));
		return element;
	}
	
	//Find web element by class name
	public static WebElement findWebElementByClass(String locator) {
		WebElement element = getDriver().findElement(By.cssSelector(locator));
		return element;
	}
	
	//Click on element
	public static void clickOnElement(String element) {
		findWebElementByClass(element).click();
	}
	
	//Insert data (string) into data field
	public static void insertStringIntoField(String locator, String value) {
		findWebElementByClass(locator).clear();
		findWebElementByClass(locator).sendKeys(value);
	}
	
	//Switch to iframe
	public static void switchToFieldset() {
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame("calculator-frame-06");
	}
	
	//Find element text method
	public static String findElementText(String element) {
		return findWebElementByClass(element).getText();
	
	}
	
	//get element color method
	public static String getElementColor(String element, String value) {
		return findWebElementByClass(element).getCssValue(value);
	
	}

	//getDriver method to simplify steps
	public static WebDriver getDriver() {
		return driver.get();
	}

	

}
