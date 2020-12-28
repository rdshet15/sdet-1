//5. Edit user information
//Goal: Edit a user’s information

package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Activity_5 {
  
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
  public void name() throws InterruptedException {
	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("btnSave")).click();
	driver.findElement(By.id("personal_txtEmpFirstName")).clear();
	driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("test12");
	driver.findElement(By.id("personal_optGender_1")).click();
	WebElement nation = driver.findElement(By.id("personal_cmbNation"));
	Select sel = new Select(nation);
	sel.selectByVisibleText("Indian");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id='personal_DOB']")).click();
	
	//select year
	WebElement date = driver.findElement(By.className("ui-datepicker-year"));
	Select dat = new Select(date);
	dat.selectByVisibleText("1988");
	Thread.sleep(1000);
	
	//select month
	WebElement moth = driver.findElement(By.className("ui-datepicker-month"));
		Select month = new Select(moth);
		month.selectByVisibleText("May");
		Thread.sleep(1000);

	// select date
	//driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[contains(text(),'1')]")).click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[(text() ='1')]")).click();
		
		driver.findElement(By.id("btnSave")).click();
		
  }
    
   
 
	@AfterTest
	public void exitBrowser() {
			  driver.close();
		 }

}
