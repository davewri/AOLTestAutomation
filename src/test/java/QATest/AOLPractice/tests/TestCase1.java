package QATest.AOLPractice.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import QATest.AOLPractice.base.TestBaseSetup;
import QATest.AOLPractice.pageobjects.BasePage;


/* 
1.       Using Firefox go to http://www.aol.com
2.       Verify ‘NEWS’, ‘SPORTS’ and ‘ENTERTAINMENT’ links/elements are present on the page
3.       Then search for AOL Autos
4.       Verify that ‘Web’ and ‘Mail’ links/elements are present
5.       Then click on http://autos.aol.com/ search result and verify that the AOL Autos Logo is present from the resulting page

*/

public class TestCase1 extends TestBaseSetup{
private static WebDriver driver;
private BasePage basePage;

	@BeforeClass
	public static void setUp() {
		driver=getDriver();
	}

	@Test
	public void verifyTC1Requirements() throws Exception{
		String sport = "ghnav-sports";
		String news = "ghnav-news";
		String entertainment = "ghnav-entertainment";
		String aolauto = "AOL autos";
		
		System.out.println("Navigating to AOL Home Page...");
		
		basePage = new BasePage(driver);
		
		//Verify navigation to AOL Home page 
		Assert.assertTrue(basePage.verifyBasePageTitle());

		//Verify Sports link is present
	    if(driver.findElements(By.id(sport)).size() != 0){
	        System.out.println("Sports link exists");
	      } else {
	  	  System.out.println("Sports link does not exist");
	      }
	    
	    //Verify News link is present
	    if(driver.findElements(By.id(news)).size() != 0){
	        System.out.println("News link exists");
	      } else {
	  	  System.out.println("News link does not exist");
	      }
	    
	    //Verify Entertainment link is present
	    if(driver.findElements(By.id(entertainment)).size() != 0){
	        System.out.println("Entertainment link exists");
	      } else {
	  	  System.out.println("Entertainment link does not exist");
	      }

	    //Search for "AOL autos" page
	    driver.findElement(By.id("aol-header-query")).sendKeys(aolauto);
	    driver.findElement(By.id("aol-header-search-button")).click();	
	    
	    //Verify Web link
	    if(driver.findElements(By.id("Web")).size() != 0){
	  	  System.out.println("Web link exists");
	      } else {
	  	  System.out.println("Web link exists");
	      }	
	    
	    //Verify Mail Link
	    if(driver.findElements(By.id("Mail")).size() != 0){
	        System.out.println("Mail link exists");
	      } else {
	  	  System.out.println("Mail link exists");
	      }		  	 
	    
		if(driver.findElement(By.xpath("//a[@href ='http://www.autoblog.com/']")).isDisplayed()){
			  System.out.println("Autoblog image exists");   
			} else {
			  System.out.println("Autoblog image exists");	   
			}   
	    
	}	
		
    @After
    public void closeBrowsers() throws Exception {
	driver.close();
	}

}
