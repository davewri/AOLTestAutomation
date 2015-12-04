package QATest.AOLPractice.pageobjects;

import org.openqa.selenium.WebDriver;
import QATest.AOLPractice.pageobjects.BasePage;



public class AOLHomePage {
	
	private WebDriver driver;

	public AOLHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}


	public static String getAOLHomePageTitle() {
		String pageTitle = BasePage.getPageTitle();
		return pageTitle;
	}
	
	public static boolean verifyHomePageTitle() {
		String expectedTitle = "AOL - News, Sports";
		return getAOLHomePageTitle().startsWith(expectedTitle);
	}	
	
		

}