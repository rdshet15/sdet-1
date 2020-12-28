//7. Adding qualifications
//Goal: Add employee qualifications

package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Activity_7 {
  
  WebDriver driver;
	
  @BeforeTest
  public void openBrowser() {
			
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/orangehrm");
			driver.manage().window().maximize();
		}
  
  //login to application
  @Test (priority = 1)
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
  @Test (priority = 2)
  public void My_info() throws InterruptedException {
	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	driver.findElement(By.linkText("Qualifications")).click();
	Reporter.log("clicked on Qualification");
	System.out.println("clicked on Qualification");
		
  }
  @Test (priority = 3)
  public void expfromdate() throws InterruptedException {
	  driver.findElement(By.id("addWorkExperience")).click();
	  driver.findElement(By.id("experience_employer")).sendKeys("HPA");
	  driver.findElement(By.id("experience_jobtitle")).sendKeys("Engineer");
	  
	  //From year selection
	  driver.findElement(By.id("experience_from_date")).click();
	  WebElement fmdate = driver.findElement(By.className("ui-datepicker-year"));
	  Select objfmdate = new Select(fmdate);
	  objfmdate.selectByVisibleText("1990");
	  Thread.sleep(2000);
	  
	  //From month selection
	  
	  WebElement todate = driver.findElement(By.className("ui-datepicker-month"));
	  Select objtodate = new Select(todate);
	  objtodate.selectByVisibleText("Dec");
	  Thread.sleep(2000);
	 
	  //from date selection
	  driver.findElement(By.xpath("//tbody/tr[2]/td/a[text()='7']")).click();
	  
	  
	
  }
  @Test (priority = 4)
  public void exptodate() throws InterruptedException {
	  
	  //From year selection
	  driver.findElement(By.id("experience_to_date")).click();
	
	  WebElement todate = driver.findElement(By.className("ui-datepicker-year"));
	  Select objtodate = new Select(todate);
	  objtodate.selectByVisibleText("2000");
	  Thread.sleep(2000);
	  
	  //From month selection
	  
	  WebElement todate1 = driver.findElement(By.className("ui-datepicker-month"));
	  Select objtodate1 = new Select(todate1);
	  objtodate1.selectByVisibleText("Dec");
	  Thread.sleep(2000);
	 
	  //from date selection
	  driver.findElement(By.xpath("//tbody/tr[3]/td[4]/a[text()='14']")).click();
	  
	  driver.findElement(By.id("experience_comments")).sendKeys("Testing");
	  
	  driver.findElement(By.id("btnWorkExpSave")).click();
	  
  }
   
 
	@AfterTest
	public void exitBrowser() {
			  driver.close();
		 }

}
