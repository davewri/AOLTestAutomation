package QATest.AOLPractice.pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

	protected static WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}	

	
	
	public static String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="AOL - News, Sports";
		return getPageTitle().startsWith(expectedPageTitle);
	}
	
}
