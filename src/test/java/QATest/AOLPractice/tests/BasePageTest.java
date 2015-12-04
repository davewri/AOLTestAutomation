package QATest.AOLPractice.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import QATest.AOLPractice.base.TestBaseSetup;
import QATest.AOLPractice.pageobjects.BasePage;

public class BasePageTest extends TestBaseSetup{

	private WebDriver driver;
	
	@BeforeClass

	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void verifyAOLHomePage() {
		System.out.println("Home page test...");
		BasePage basePage = new BasePage(driver);
		//Assert.assertEquals(true, basePage.verifyBasePageTitle().isDisplayed());
	}

}
