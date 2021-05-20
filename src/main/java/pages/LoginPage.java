package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import utils.ElementUtil;

public class LoginPage {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPage.class));
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//By Locators
    private By email		= By.name("forms.loginForm.email");
    private By password 	= By.name("forms.loginForm.password");
    private By loginButton	= By.xpath("//button[@type='submit']");
    private By forgotPwdLink= By.cssSelector("span.forgot-password");
    private By listbox		=  By.xpath("//div[@role='listbox']/i");
    private By logout		=  By.xpath("//div[@role='option']");
    private By invalideMail	=  By.xpath("//form[@model='forms.loginForm']/div[3]/div/p");
    
    //Constructor of Page Class
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    	elementUtil = new ElementUtil(this.driver);
    }
    
    //Page Actions/methods
    public String getLoginPageTitle() {
    	return elementUtil.waitForPageTitle();
    }
    public boolean isForgotPwdLinkExist() {
    	Boolean isDisplayed = elementUtil.doIsDisplayed(forgotPwdLink);
    	//System.out.println("Is Displayed : " + isDisplayed);
    	return isDisplayed;
    }
    
    @Step("Login with username : {0} and password : {1}")
    public LoginPage doLogin(String un, String pwd) throws InterruptedException {
    	//System.out.println("Login with : " + un + " " + pwd);
    	LOGGER.info("Login with : " + un + " " + pwd);
    	
    	elementUtil.doSendKeys(email, un);
    	
    	elementUtil.doSendKeys(password, pwd);
    	
        elementUtil.doClick(loginButton);
        return new LoginPage(driver);
    }
          
    public String afterUrl() {
    	return elementUtil.currentUrl();
    }
    
    public void afterLogin() throws InterruptedException {
    	elementUtil.doClick(listbox);
    	elementUtil.doClick(logout);
    }
}
