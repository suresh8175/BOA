package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public class ForgotPasswordPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//By Locators
    By forgotPassword	= By.xpath("//span[@class='forgot-password']");
    By enterEmail		= By.cssSelector("input.input-box");
    By submitButton		= By.cssSelector("button.ui.small.secondary.button");
    By resetMessage		= By.cssSelector("div.ui.message");
    
    //Constructor
    public ForgotPasswordPage(WebDriver driver) {
    	this.driver = driver;
    	elementUtil = new ElementUtil(this.driver);
    }
    
    public void clickOnForgot() {
    	elementUtil.doClick(forgotPassword);
    	//return new ForgotPasswordPage(driver);
    }
        
    public String afterUrl() {
    	return elementUtil.currentUrl();
    }
    
    public void enterEmail(String mail) throws InterruptedException {
    	
    	elementUtil.doSendKeys(enterEmail, mail);
    	elementUtil.doClick(submitButton);
    	Thread.sleep(3000);
    }
    
    public String resetPasswordMessage() throws InterruptedException {
    	
    	String uiMessage = elementUtil.GetMessage(resetMessage);
    	return uiMessage;
    }
}
