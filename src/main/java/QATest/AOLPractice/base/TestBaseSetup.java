package QATest.AOLPractice.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBaseSetup {

	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	//Should more drivers be added
	private static void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "Firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}	

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@BeforeClass
	public static void initializeTestBaseSetup() {
		try {
			setDriver("Firefox", "http://www.aol.com");

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}

