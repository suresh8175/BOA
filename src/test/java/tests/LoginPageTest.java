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
	
	@Test(priority=1)
	@Severity(SeverityLevel.MINOR)
	public void loginPageTitleTest() {	
		String title = loginPage.getLoginPageTitle();
		//System.out.println("login page title is : " + title);
		LOGGER.info("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkTest() {	
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

//	@DataProvider
//	public Object[][] getUsersData() {
//		Object data2[][] = ExcelUtil.getTestData(Constants.LOGIN_SHEET_NAME);
//		return data2;
//		
//	}
	
	//@Test(dataProvider = "getUsersData")
	@Test(priority=3)
	@Severity(SeverityLevel.BLOCKER)
	//public void loginTest(String username, String password) throws InterruptedException {	
	public void loginTest() throws InterruptedException {
		//loginPage.doLogin(username, password);
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		String loginUrl = loginPage.afterUrl();
		//System.out.println("home page url is : " + loginUrl);
		LOGGER.info("home page url is : " + loginUrl);
		Assert.assertEquals(loginUrl, Constants.HOME_PAGE_URL);
		if(loginUrl.equals(Constants.HOME_PAGE_URL)) {
			loginPage.afterLogin();
		}
	}
}
