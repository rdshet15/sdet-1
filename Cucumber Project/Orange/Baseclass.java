package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	static WebDriver driver = new FirefoxDriver();
	WebDriverWait wait= new WebDriverWait(driver, 15);
	
	
	
	
}

