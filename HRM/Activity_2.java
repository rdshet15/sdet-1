package OrangeHRM;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_2 {
	WebDriver driver;
	
	@BeforeTest
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/orangehrm");
	}
		
	@Test
	public void urlHeader() {
		WebElement img= driver.findElement(By.tagName("img"));
		
			System.out.println(img.getAttribute("src"));
		}
				
	
	@AfterTest
	public void closeBrow()	{ 
		   driver.close();	
	}
				
	
}
