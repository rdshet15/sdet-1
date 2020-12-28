package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity_6 {
	
	 WebDriver driver;
 
  @BeforeTest
  public void openBrowser() {
		
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();
	}
  
  @Test
  public void login() throws InterruptedException {
	   
	   //login to application
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebElement home =driver.findElement(By.xpath("//h1[text()= 'Dashboard']"));
		Thread.sleep(5000);		
	 
		 //check Directory is visible and clickable
	  
		WebElement dir = driver.findElement(By.xpath("//*[@id=\'menu_directory_viewDirectory\']"));
		WebDriverWait wait = new WebDriverWait(driver,10);
	  	wait.until(ExpectedConditions.visibilityOf(dir));
	  	System.out.println("Directory is visible");
	  	
	  	dir.click();
		String search = driver.findElement(By.xpath("//h1[text()='Search Directory']")).getText();
		assertEquals(search, "Search Directory");
		System.out.println("heading of the page matches “Search Directory”.");
	  
  		}
		@AfterTest
		public void exitBrowser() {
				  driver.close();
			 }
			  
	   


}
