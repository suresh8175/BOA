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
    private By forgotPwd	= By.cssSelector("span.forgot-password");
    private By createAccount= By.cssSelector("span.create-account");
    private By listbox		=  By.xpath("//div[@role='listbox']/i");
    private By logout		=  By.xpath("//div[@role='option']");
    
    //Constructor of Page Class
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    	elementUtil = new ElementUtil(this.driver);
    }
    
    //Page Actions/methods
    public String getLoginPageTitle() {
    	return elementUtil.waitForPageTitle();
    }
    
    @Step("Verify Forgot Password Link")
    public boolean isForgotPwdLinkExist() {
    	Boolean isDisplayed = elementUtil.doIsDisplayed(forgotPwd);
    	return isDisplayed;
    }
    
    @Step("Verify Create Account Link")
    public boolean isCreateAccountLinkExist() {
    	Boolean isDisplayed = elementUtil.doIsDisplayed(createAccount);
    	return isDisplayed;
    }
    
    @Step("Login with username : {0} and password : {1}")
    public LoginPage doLogin(String un, String pwd) throws InterruptedException {
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
