package driverfactory;

/**
 * @author Suresh Doniparti
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverFactory.class));

	WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initializing the driver on the basis of given browser name
	 * @param browserName
	 * @return this return WebDriver driver
	 */
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		//System.out.println("Browser name is : " + browserName);
		LOGGER.info("Browser name is : " + browserName);
		
		highlight = prop.getProperty("highlight").trim();
		optionsManager = new OptionsManager(prop);
		//Determine the Browser
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());	
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} 
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if (browserName.equals("iexplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}
		else if (browserName.equals("safari")) {
			driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else {
			//System.out.println("Please pass the correct browser name " + browserName);
			LOGGER.info("Please pass the correct browser name " + browserName);
		}
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is used to initialize the properties from config file.
	 * @return returns Properties prop
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	public String getScreenshot() {
		String src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
		File srcFile = new File(src);
		String path = "./screenshots/"+System.currentTimeMillis()+".png";
		
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
