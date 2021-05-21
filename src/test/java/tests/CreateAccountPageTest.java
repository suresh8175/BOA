package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.Constants;

public class CreateAccountPageTest extends BaseTest {
	
	@Test
	@Severity(SeverityLevel.MINOR)
	public void createButtonTest() throws InterruptedException {	
		createPage.createPage();
	}
	
	@Test(dependsOnMethods = { "createButtonTest" })
	@Severity(SeverityLevel.CRITICAL)
	public void createUrlTest() throws InterruptedException {	
		String createUrl = createPage.afterCreateUrl();
		Assert.assertEquals(createUrl, Constants.CREATE_ACCOUNT_PAGE_URL);
	}
	
	@Test(dependsOnMethods = { "createUrlTest" })
	@Severity(SeverityLevel.CRITICAL)
	public void verifyCreatePageTitleTest() throws InterruptedException {	
		String message = createPage.verifyPageTitle();
		Assert.assertEquals(message, Constants.CREATE_ACCOUNT_PAGE_TITLE);
	}
	
	@Test(dependsOnMethods = { "verifyCreatePageTitleTest" })
	@Severity(SeverityLevel.CRITICAL)
	public void verifyHelpLinkTest() {	
		Assert.assertTrue(createPage.verifyHelpLink());
	}
	
	@Test(dependsOnMethods = { "verifyHelpLinkTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterUsernameTest() throws InterruptedException {
		createPage.enterUsername(prop.getProperty("newusername"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterUsernameTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterPasswordTest() throws InterruptedException {
		createPage.enterPassword(prop.getProperty("newpassword"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterPasswordTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterConfirmPasswordTest() throws InterruptedException {
		createPage.enterConfirmPassword(prop.getProperty("confirmpassword"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterConfirmPasswordTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void verifyBothPasswordsTest() throws InterruptedException {
		String password = prop.getProperty("newpassword");
		String confirmpassword = prop.getProperty("confirmpassword");
		Assert.assertEquals(password, confirmpassword);
	}
	
	@Test(dependsOnMethods = { "enterConfirmPasswordTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterFirstNameTest() throws InterruptedException {
		createPage.enterFirstName(prop.getProperty("firstname"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterFirstNameTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterLastNameTest() throws InterruptedException {
		createPage.enterLastName(prop.getProperty("lastname"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterLastNameTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterMobileNumberTest() throws InterruptedException {
		createPage.enterMobileNumber(prop.getProperty("mobilenumber"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterMobileNumberTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterOfficeNumberTest() throws InterruptedException {
		createPage.enterOfficeNumber(prop.getProperty("officenumber"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterOfficeNumberTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void selectIndustryTest() throws InterruptedException {
		createPage.selectIndustry();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "selectIndustryTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void selectCustomerRoleTest() throws InterruptedException {
		createPage.selectCustomerRole();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "selectCustomerRoleTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void enterCompanyNameTest() throws InterruptedException {
		createPage.enterCompanyName(prop.getProperty("companyname"));
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "enterCompanyNameTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void acceptTermsConditionsTest() throws InterruptedException {
		createPage.acceptTermsConditions();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = { "acceptTermsConditionsTest" })
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLoginLinkTest() {	
		Assert.assertTrue(createPage.verifyLoginLink());
	}
	
}
