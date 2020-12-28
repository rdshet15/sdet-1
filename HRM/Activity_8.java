//8. Applying for a leave
//Goal: Login and apply for a leave on the HRM site

package OrangeHRM;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Activity_8 {
  
  WebDriver driver;
	
  @BeforeTest
  public void openBrowser() {
			
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/orangehrm");
			driver.manage().window().maximize();
		}
  
  //login to application
  @Test (priority = 1)
  public void login()  {
	   
	   //login to application
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebElement home =driver.findElement(By.xpath("//h1[text()= 'Dashboard']"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (home.isDisplayed()) {
			Reporter.log("your are in home page");
		} else {
			Reporter.log("Your are not in home page");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
  }
  
  //click on Dashboard in menu
  @Test (priority = 3)
  public void Dashboard() throws InterruptedException {
	driver.findElement(By.id("menu_dashboard_index")).click();
	
	Reporter.log("clicked on dashboard");
	System.out.println("clicked on dashboard");
	

	//apply leave
	
	driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']/b[contains(text(),'Leave')]")).click();
	Thread.sleep(5000);
	Reporter.log("clicked on leave menu");
	
	WebElement leave = driver.findElement(By.id("menu_leave_applyLeave"));
	
	WebDriverWait wait =new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(leave));
	leave.click();
	Reporter.log("clicked on Apply leave");
	
	WebElement leave1 = driver.findElement(By.id("applyleave_txtLeaveType"));
	Select leaveSel = new Select(leave1);
	leaveSel.selectByVisibleText("Paid Leave");
	
	driver.findElement(By.id("applyleave_txtFromDate")).click();
	
	Thread.sleep(3000);
	
	//year selection
	WebElement fromyr = driver.findElement(By.className("ui-datepicker-year"));
	Select frmyr = new Select(fromyr);
	frmyr.selectByVisibleText("2020");
	
	Thread.sleep(3000);
	//month selection
		
	WebElement frommt = driver.findElement(By.className("ui-datepicker-month"));
	Select frmmt = new Select(frommt);
	frmmt.selectByVisibleText("Apr");
	Thread.sleep(3000);
	
	//date selection
	driver.findElement(By.xpath("//tbody/tr/td/a[contains(text(),'24')]")).click();
	
	Thread.sleep(3000);

	
		driver.findElement(By.id("applyleave_txtToDate")).click();
		
		//year selection
		WebElement toyr = driver.findElement(By.className("ui-datepicker-year"));
		Select Toyr = new Select(toyr);
		Toyr.selectByVisibleText("2020");
		
		Thread.sleep(3000);
		//month selection				
		WebElement tomt = driver.findElement(By.className("ui-datepicker-month"));
		Select tommt = new Select(tomt);
		tommt.selectByVisibleText("Apr");
		
		Thread.sleep(3000);
		//date selection
		driver.findElement(By.xpath("//tbody/tr/td/a[contains(text(),'24')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("applyBtn")).click();
		Thread.sleep(3000);
		
  }
  
  //check in My leave page and get the status
  @Test (priority = 3)
  public void myleavepage() throws InterruptedException {
	  
	  driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("calFromDate")).click();
	  
	  Thread.sleep(3000);
		//From year selection
		WebElement fromyr = driver.findElement(By.className("ui-datepicker-year"));
		Select frmyr = new Select(fromyr);
		frmyr.selectByVisibleText("2020");
		
		Thread.sleep(3000);
		//From month selection
			
		WebElement frommt = driver.findElement(By.className("ui-datepicker-month"));
		Select frmmt = new Select(frommt);
		frmmt.selectByVisibleText("Apr");
		Thread.sleep(3000);
		
		//from date selection
		driver.findElement(By.xpath("//html/body/div[3]/table/tbody/tr/td/a[contains(text(),'24')]")).click();
		
		//Thread.sleep(3000);
		
	
		driver.findElement(By.xpath("//*[@id='calToDate']")).click();
		//driver.findElement(By.id("calToDate")).click();	
		//driver.findElement(By.cssSelector("#calToDate")).click();
				
		//To year selection
		WebElement toyr = driver.findElement(By.className("ui-datepicker-year"));
		Select Toyr = new Select(toyr);
		Toyr.selectByVisibleText("2020");
			
		Thread.sleep(3000);
			//To month selection				
		WebElement tomt = driver.findElement(By.className("ui-datepicker-month"));
		Select tommt = new Select(tomt);
		tommt.selectByVisibleText("Apr");
		Thread.sleep(3000);
			
			//To date selection
		driver.findElement(By.xpath("//html/body/div[3]/table/tbody/tr/td/a[contains(text(),'24')]")).click();
			
		Thread.sleep(3000);
		
		//driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck")).clear();
		
		if (driver.findElement(By.xpath("//input[contains(@id,'allcheck')]")).isSelected()) {
			
			driver.findElement(By.xpath("//input[contains(@id,'allcheck')]")).click();
		}
		
		driver.findElement(By.xpath("//input[@id='leaveList_chkSearchFilter_1']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(3000);
			
			//getting the leave status
		String status = driver.findElement(By.xpath("//a[contains(text(),'2020-04-24')]/parent::td//following-sibling::td//a[contains(text(),'Pending Approval')]")).getText();
		System.out.println("Leave status is "+ status);
	  
  		}
	@AfterTest
	public void exitBrowser() {
			  driver.close();
		 }

}
