package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import driverfactory.DriverFactory;
import pages.CreateAccountPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;


public class BaseTest {
	
	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	public LoginPage loginPage;
	public ForgotPasswordPage forgotPage;
	public CreateAccountPage createPage;
	
	@BeforeClass
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		
		//String browserName = prop.getProperty("browser");
		driver = df.init_driver(prop);
		
		String url = prop.getProperty("url");
		//System.out.println(url);
		
		driver.get(url);
		
		loginPage = new LoginPage(driver);
		forgotPage = new ForgotPasswordPage(driver);
		createPage = new CreateAccountPage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
