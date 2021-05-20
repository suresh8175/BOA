package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_Old {
	
	private WebDriver driver;
	
	//By Locators
    private By email		= By.name("forms.loginForm.email");
    private By password 	= By.name("forms.loginForm.password");
    private By loginButton	= By.xpath("//button[@type='submit']");
    private By forgotPwdLink= By.xpath("//span[@class='forgot-password']");
    
    //Constructor of Page Class
    public LoginPage_Old(WebDriver driver) {
    	this.driver = driver;
    }
    
    //Page Actions/methods
    public String getLoginPageTitle() {
    	return driver.getTitle();
    }
    public boolean isForgotPwdLinkExist() {
    	return driver.findElement(forgotPwdLink).isDisplayed();
    }
    
    public void doLogin(String un, String pwd) throws InterruptedException {
    	System.out.println("Login with : " + un + " " + pwd);
    	driver.findElement(email).sendKeys(un);
    	driver.findElement(password).sendKeys(pwd);
    	driver.findElement(loginButton).click();
    }
    
   
    public String afterLoginUrl() {
    	return driver.getCurrentUrl();
    }
}
