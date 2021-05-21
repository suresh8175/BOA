package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CreateAccountPageTest extends BaseTest {
	
	@Test
	public void createTest() throws InterruptedException {	
		
		createPage.createPage();
		String createUrl = createPage.afterCreateUrl();
		//System.out.println("create page url is : " + createUrl);
		Assert.assertEquals(createUrl, "https://uat-portal.boa.co.nz/createAccount");
	}
}
