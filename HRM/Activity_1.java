package OrangeHRM;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1 {
	WebDriver driver;
	
	@BeforeMethod
	public void beforemethod() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void website_title() {
		String title = driver.getTitle();
		
	   AssertJUnit.assertEquals(title, "OrangeHRM");
					
	}
	@AfterMethod
	public void closeBrow()
	{ 
		   driver.close();	
	}
				
	
}
