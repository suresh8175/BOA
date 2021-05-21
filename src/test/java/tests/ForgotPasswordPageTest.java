package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Step;
import utils.Constants;

public class ForgotPasswordPageTest extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(ForgotPasswordPageTest.class));
	
	@Test
	@Step("Click on Forgot Password")
	public void forgotButtonTest() throws InterruptedException {	
		
		forgotPage.clickOnForgot();
		String forgotUrl = forgotPage.afterUrl();
		Assert.assertEquals(forgotUrl, "https://uat-portal.boa.co.nz/forgotPassword");
	}
	
	@Test(dependsOnMethods = { "forgotButtonTest" })
	@Step("Enter the email to reset password")
	public void resetPasswordTest() throws InterruptedException {	
		
		forgotPage.enterEmail(prop.getProperty("username"));
		Thread.sleep(5000);
		String forgotUrl = forgotPage.afterUrl();
		Assert.assertEquals(forgotUrl, Constants.FORGOT_PAGE_URL);
	}
	
	@Test(dependsOnMethods = { "resetPasswordTest" })
	@Step("Verify reset password message")
	public void resetPasswordMessageTest() throws InterruptedException {	
		String message = forgotPage.resetPasswordMessage();
		Assert.assertEquals(message, Constants.FORGOT_RESET_PASSWORD_MESSAGE);
	}
	

}
