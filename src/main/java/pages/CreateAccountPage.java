package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import utils.ElementUtil;

public class CreateAccountPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//By Locators
    private By createAccount	= By.cssSelector("span.create-account");
    private By pageTitle		= By.cssSelector("p.sign-up-header-title");
    private By helpLink			= By.xpath("//form[@model='forms.createAccountForm']/div/div/div/div[3]/a");
    private By email			= By.xpath("//input[@type='email']");
    private By password			= By.xpath("//input[@type='password']");
    private By confirmPassword	= By.name("forms.createAccountForm.confirmPassword");
    private By firstName		= By.name("forms.createAccountForm.firstName");
    private By lastName			= By.name("forms.createAccountForm.lastName");
    private By mobileNumber		= By.xpath("//form[@model='forms.createAccountForm']/div[6]/div/div/input");
    private By officeNumber		= By.xpath("//form[@model='forms.createAccountForm']/div[6]/div[2]/div/input");
    private By industryDropDown	= By.xpath("//form[@model='forms.createAccountForm']/div[7]/div/div/div/div/i");
    private By industryOption	= By.xpath("//form[@model='forms.createAccountForm']/div[7]/div/div/div/div/div/div[11]");
    private By roleDropDown		= By.xpath("//form[@model='forms.createAccountForm']/div[7]/div/div[2]/div/div/i");
    private By customerRoleOption	= By.xpath("//form[@model='forms.createAccountForm']/div[7]/div/div[2]/div/div/div/div[8]");
    private By companyName		= By.name("forms.createAccountForm.companyName");
    private By termsConditions	= By.xpath("//form[@model='forms.createAccountForm']/div[10]/div/div/div/div/label");
    private By loginButton		= By.xpath("//form[@model='forms.createAccountForm']/div[13]/div/a");
    
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
    
    public String verifyPageTitle() {
    	String uiMessage = elementUtil.GetMessage(pageTitle);
    	return uiMessage;
    }
    
    public Boolean verifyHelpLink() {
    	Boolean isDisplayed = elementUtil.doIsDisplayed(helpLink);
    	return isDisplayed;
    }
    
    @Step("Enter username : {0}")
    public void enterUsername(String un) throws InterruptedException {
    	elementUtil.doSendKeys(email, un);        
    }
    
    @Step("Enter password : {0}")
    public void enterPassword(String pwd) throws InterruptedException {
    	elementUtil.doSendKeys(password, pwd);        
    }
    
    @Step("Enter confirm password : {0}")
    public void enterConfirmPassword(String cpwd) throws InterruptedException {
    	elementUtil.doSendKeys(confirmPassword, cpwd);        
    }
    
    @Step("Enter first name : {0}")
    public void enterFirstName(String fname) throws InterruptedException {
    	elementUtil.doSendKeys(firstName, fname);        
    }
    
    @Step("Enter last name : {0}")
    public void enterLastName(String lname) throws InterruptedException {
    	elementUtil.doSendKeys(lastName, lname);        
    }
    
    @Step("Enter mobile number : {0}")
    public void enterMobileNumber(String mnumber) throws InterruptedException {
    	elementUtil.doSendKeys(mobileNumber, mnumber);        
    }
    
    @Step("Enter mobile number : {0}")
    public void enterOfficeNumber(String onumber) throws InterruptedException {
    	elementUtil.doSendKeys(officeNumber, onumber);        
    }
    
    @Step("Select industry")
    public void selectIndustry() throws InterruptedException {
    	elementUtil.doClick(industryDropDown);
    	elementUtil.doClick(industryOption);      
    }
    
    @Step("Select customer role")
    public void selectCustomerRole() throws InterruptedException {
    	elementUtil.doClick(roleDropDown);
    	elementUtil.doClick(customerRoleOption);      
    }
    
    @Step("Enter company name : {0}")
    public void enterCompanyName(String companyname) throws InterruptedException {
    	elementUtil.doSendKeys(companyName, companyname);        
    }

    @Step("Accept terms and conditions")
    public void acceptTermsConditions() throws InterruptedException {
    	elementUtil.doClick(termsConditions);     
    }
    
    @Step("Verify login button")
    public Boolean verifyLoginLink() {
    	Boolean isDisplayed = elementUtil.doIsDisplayed(loginButton);
    	return isDisplayed;
    }
}
