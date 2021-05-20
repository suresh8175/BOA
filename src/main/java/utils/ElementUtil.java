package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverfactory.DriverFactory;

public class ElementUtil {
	
	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	//Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver);
	}
	
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if(DriverFactory.highlight.equals("true")) {
			jsUtil.flash(element);
		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
//		while(!getElement(locator).getAttribute("value").equals("")){
//			getElement(locator).sendKeys(Keys.BACK_SPACE);
//	    }
		if (!getElement(locator).getAttribute("value").equals("")) {
			getElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		}
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String waitForPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
    public String currentUrl() {
    	return driver.getCurrentUrl();
    }
    
    public String GetMessage(By locator) {
    	return getElement(locator).getText();
    }

	public void clearTheData(By locator) {
		//getElement(locator).clear();
		//getElement(locator).send_keys(Keys.CONTROL + u'\ue003');
		//getElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		while(!getElement(locator).getAttribute("value").equals("")){
			getElement(locator).sendKeys(Keys.BACK_SPACE);
	    }
	}
	
}
