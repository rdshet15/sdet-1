//9. Retrieve emergency contacts
//Goal: Login and retrieve the emergency contacts for the user

package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity_9 {
  
  WebDriver driver;
	
  @BeforeTest
  public void openBrowser() {
			
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/orangehrm");
			driver.manage().window().maximize();
		}
  
  //login to application
  @Test
  public void login() throws InterruptedException {
	   
	   //login to application
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebElement home =driver.findElement(By.xpath("//h1[text()= 'Dashboard']"));
		Thread.sleep(5000);
		if (home.isDisplayed()) {
			Reporter.log("your are in home page");
		} else {
			Reporter.log("Your are not in home page");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
  }
  
  //click on My Info in menu
  @Test
  public void names() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Emergency Contacts")).click();
	Thread.sleep(3000);
	
	//get the row and colunm counts from the table
	int rowcount = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr")).size();
	int colonmcount = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr[1]/td/input[@class='checkbox']//parent::td//following-sibling::td")).size();
	
	//divide the xpath in to three parts
	String firstpart = "//table[@id='emgcontact_list']/tbody/tr[";
	String seconfpart = "]/td/input[@class='checkbox']//parent::td//following-sibling::td[";
	String thirdpart = "]";
	
	
	//Used for loop for number of rows.
		for (int i = 1; i <=rowcount; i++) {
			
			//Used for loop for number of columns.
		for (int j = 1; j <= colonmcount; j++) {
			
			//Prepared final xpath of specific cell as per values of i and j.
			String finalpath = firstpart+i+seconfpart+j+thirdpart;
			
			  //Will retrieve value from located cell and print It.
			String tabledata = driver.findElement(By.xpath(finalpath)).getText();
			
			if (tabledata.isEmpty()) {
				System.out.println("");
			}
			else {
				System.out.println("Emergency conact    "+tabledata+"     ");
			}			
			
		}
		System.out.println("=============");	
		
	}
  }
	@AfterTest
	public void exitBrowser() {
			  driver.close();
		 }
}
    
   
 
	
		

