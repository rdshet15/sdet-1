package APPIUM_Project;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class GoogleNotes {
	
	private static final TimeUnit SECONDS = null;
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  
	  //set the desired capabilities
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("devicename", "Pixel");
	  caps.setCapability("platform", "Android");
	  caps.setCapability("addActivity", ".ui.TaskListsActivity");
	  caps.setCapability("addPackage",  "com.google.android.apps.tasks");
	  caps.setCapability("noReset", true);
	  caps.setCapability("webviewDevtoolsPort", 9543);
	  
	  //instantiate appium driver
	  URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AndroidDriver<MobileElement>(appserver,caps);
	  wait = new WebDriverWait(driver, 5);
  }
  
  
  @Test
  public void gNotes() {
	  driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Search\"]").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.googlequicksearchbox:id/search_box")));
	  driver.findElementById("com.google.android.googlequicksearchbox:id/search_box").sendKeys("note");
	  driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\'Open Keep Notes.\']/android.widget.FrameLayout/android.widget.TextView").click();
	  //driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Open Tasks.\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout").click();;
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	 
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\'New text note\']").click();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
	  
	  //creating the new notes
	  
	  driver.findElementById("com.google.android.keep:id/editable_title").click();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Testing Google Notes");
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
	  //entering the description
	  driver.findElementById("com.google.android.keep:id/edit_note_text").click();
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Description of google notes");
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
	  
	  //assertion
	  String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
	  Assert.assertEquals(title, "Testing Google Notes");
	  System.out.println("Printed title");
	  
	  String desc =driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
	  Assert.assertEquals(desc, "Description of google notes");
	  System.out.println("Printed Description");
	  
  }
  @AfterClass
  public void afterClass() {
  driver.quit();
 }

}
