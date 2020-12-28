package OrangeHRM;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_3 {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/orangehrm");
		driver.manage().window().maximize();
	}
	
	@Test
  public void login() {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("orange");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		WebElement home =driver.findElement(By.xpath("//h1[text()= 'Dashboard']"));
		
		if (home.isDisplayed()) {
			Reporter.log("your are in home page");
		} else {
			Reporter.log("Your are not in home page");

		}
	  }
	@AfterTest
	public void exitBrowser() {
		driver.close();
	}
}
