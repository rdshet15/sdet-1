package APPIUM_Project;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class ChromeActivity1 {
	
	private static final TimeUnit SECONDS = null;
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  
	  //set the desired capabilities
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("devicename", "Pixel");
	  caps.setCapability("platform", "Android");
	  caps.setCapability("addActivity", "com.google.android.apps.chrome.Main");
	  caps.setCapability("addPackage",  "com.android.chrome");
	  caps.setCapability("noReset", true);
	  caps.setCapability("webviewDevtoolsPort", 9543);
	  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	  
	  //instantiate appium driver
	  URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appserver,caps);
	  wait = new WebDriverWait(driver, 5);
  }
  
  
  @Test
  public void gChrome1() throws InterruptedException {
		
	  driver.navigate().to("https://www.training-support.net/selenium");
	  driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    
//	  String UiScrollableObject = "UiScrollable(UiSelector().scrollable(true))";
	 driver.findElementByXPath("//*[contains(text(),'Started!')]").click();
//	 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));
	 
		/*
		 * driver.findElement(MobileBy.AndroidUIAutomator(
		 * "UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)")); MobileElement
		 * listitem=driver.
		 * findElementByXPath("//android.view.View[contains(@text,'To-Do List')]");
		 * listitem.click();
		 */
	 
////     driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."+"scrollable(true)).scrollIntoView(new UiSelector().text('To-Do List'))"));
//     MobileElement listItem=(MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
//             + ".scrollable(true)).scrollIntoView("
//             + "new UiSelector().text(\"To-Do List\"))"));
//     
     driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(10).scrollIntoView(UiSelector().textContains(\"To-Do List\"))")).click();
     
     
//	 MobileElement listitem = driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]");
//	 listitem.click();
//	 MobileElement listitem = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByText(UiSelector().className(\"android.widget.TextView\"), \"To-Do List\")"));
//    System.out.println(listitem.getLocation());
    
	}
  }
	   
	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */


