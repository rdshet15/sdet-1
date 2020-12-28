package OrangeHRM;


import java.util.UUID;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_4 {
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
 		
 		if (home.isDisplayed()) {
 			Reporter.log("your are in home page");
 		} else {
 			Reporter.log("Your are not in home page");
 			Thread.sleep(5000);
 		}
 		
 	  // click on PIM
 		
 	  driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b[text()='PIM']")).click();
 	 
	  driver.findElement(By.xpath("//b[text()='PIM']")).click();
	  driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
	  
	  //adding employee info in PIM page
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Raghu20");
	  driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("D");
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Shet");
	  
	  driver.findElement(By.xpath("//input[@name='employeeId']")).clear();
	  driver.findElement(By.xpath("//input[@name='employeeId']")).sendKeys("423480");
	  
	  driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\RaghavendraShet\\Desktop\\orange.jpg");
	  Thread.sleep(5000);
	  
	  driver.findElement(By.name("chkLogin")).click();
	  driver.findElement(By.name("user_name")).sendKeys("raghuik10");
	  driver.findElement(By.name("user_password")).sendKeys("raghuikk");
	  driver.findElement(By.name("re_password")).sendKeys("raghuikk");
	  WebElement sel = driver.findElement(By.name("status"));
	  Select sel1 = new Select(sel);
	  sel1.selectByVisibleText("Enabled");
	  
	    
	  driver.findElement(By.id("btnSave")).click();
	  //Thread.sleep(5000);
	  
	 
	  //Navigate to Admin page
	  driver.findElement(By.xpath("//a[@class='firstLevelMenu']/b[text()='Admin']")).click();
	  driver.findElement(By.id("searchSystemUser_userName")).sendKeys("raghuik10");
	  driver.findElement(By.id("searchBtn")).click();
	  WebElement uname = driver.findElement(By.xpath("//a[text()= 'raghuik10']"));
	  String un = uname.getText();
	  
	  Assert.assertEquals(un,"raghuik10");
   	}
   
   
	  @AfterTest
	  public void exitBrowser() {
		  driver.close();
	  }
	
	
	  
  
  
}
