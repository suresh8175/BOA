package BOAPOC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseDesign {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://uat-portal.boa.co.nz/");
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
