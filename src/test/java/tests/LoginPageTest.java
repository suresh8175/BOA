package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utils.Constants;

@Epic("Feature Name : Login Page")
public class LoginPageTest extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPageTest.class));
	
	@Test
	@Severity(SeverityLevel.MINOR)
	public void loginPageTitleTest() {	
		String title = loginPage.getLoginPageTitle();
		//System.out.println("login page title is : " + title);
		LOGGER.info("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(dependsOnMethods = { "loginPageTitleTest" })
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkTest() {	
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(dependsOnMethods = { "forgotPwdLinkTest" })
	@Severity(SeverityLevel.CRITICAL)
	public void isCreateAccountLinkExistTest() {	
		Assert.assertTrue(loginPage.isCreateAccountLinkExist());
	}

	
	@Test(dependsOnMethods = { "isCreateAccountLinkExistTest" })
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		String loginUrl = loginPage.afterUrl();
		
		LOGGER.info("home page url is : " + loginUrl);
		Assert.assertEquals(loginUrl, Constants.HOME_PAGE_URL);
		if(loginUrl.equals(Constants.HOME_PAGE_URL)) {
			loginPage.afterLogin();
		}
	}
}
