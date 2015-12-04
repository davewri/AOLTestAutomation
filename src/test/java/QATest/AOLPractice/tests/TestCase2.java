package QATest.AOLPractice.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import QATest.AOLPractice.base.TestBaseSetup;
import QATest.AOLPractice.pageobjects.BasePage;


/* 
1. Using Firefox go to http://www.aol.com	 
2. Update the location([1]) to New York
3. Then verify the location is updated correctly in [1]
4. Then Go to the link WEATHER [2], and verify the weather page shows the Weather for New York.

*/

public class TestCase2 extends TestBaseSetup{
private static WebDriver driver;
private BasePage basePage;

	@BeforeClass
	public static void setUp() {
		driver=getDriver();
	}

	@Test
	public void verifyTC1Requirements() throws Exception{
		
		String location = "New York";
		
		System.out.println("Navigating to AOL Home Page...");
		
		basePage = new BasePage(driver);
		
		//Verify navigation to AOL Home page 
		Assert.assertTrue(basePage.verifyBasePageTitle());
		
		//Edit the location field
		driver.findElement(By.id("weather")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("wz")).click();  
		driver.findElement(By.id("wz")).sendKeys(location);	
		driver.findElement(By.id("weathersubmit")).click();	
		driver.findElement(By.id("weather")).click(); 
		
		//Verify location is updated correctly
		System.out.println(driver.findElement(By.id("weatheredit")).getText());
		Assert.assertTrue(driver.findElement(By.id("weatheredit")).getText().matches("NEW YORK, NY"));
		driver.findElement(By.id("ghnav-weather")).click();
		
		//Verify weather page shows the Weather for New York
		if(driver.findElement(By.xpath("//span[@data-fullname = 'New York']")).getSize().equals(0)){
			   System.out.println("Location is not New York");
		} else {
			  System.out.println("Location is New York");
		}
		
	}
    @After
    public void closeBrowsers() throws Exception {
	driver.close();
	}

}
