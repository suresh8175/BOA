package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public class CreateAccountPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//By Locators
    private By createAccount= By.cssSelector("span.create-account");
    
   
    //Constructor of Page Class
    public CreateAccountPage(WebDriver driver) {
    	this.driver = driver;
    	elementUtil = new ElementUtil(this.driver);
    }
    
    public void createPage() {
    	elementUtil.doClick(createAccount);
    	//return new CreateAccountPage(driver);
    }

    public String afterCreateUrl() {
    	return driver.getCurrentUrl();
    }
}
