package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import driverfactory.DriverFactory;
import pages.LoginPage;


public class BaseTest {
	
	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	public LoginPage loginPage;
	
	@BeforeSuite
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		
		//String browserName = prop.getProperty("browser");
		driver = df.init_driver(prop);
		
		String url = prop.getProperty("url");
		//System.out.println(url);
		
		driver.get(url);
		
		loginPage = new LoginPage(driver);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
