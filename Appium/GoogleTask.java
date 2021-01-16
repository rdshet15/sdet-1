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

public class GoogleTask {
	
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
  public void gTask() {
	  driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Search\"]").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.googlequicksearchbox:id/search_box")));
	  driver.findElementById("com.google.android.googlequicksearchbox:id/search_box").sendKeys("task");
	  driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\'Open Tasks.\']/android.widget.FrameLayout/android.widget.TextView").click();
	  //driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\"Open Tasks.\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout").click();;
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	 
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\'Create new task\']").click();
	  
	  //creating the new tasks
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").click();
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").clear();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  MobileElement task1_1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  task1_1.sendKeys("Complete Activity with Google Tasks");
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
	  //creating second task
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  //driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").clear();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  MobileElement task2_1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  task2_1.sendKeys("Complete Activity with Google Keep");
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
	  //creating 3rd task
	  //creating second task
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  //driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").clear();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  MobileElement task3_1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  task3_1.sendKeys("Complete the second Activity Google Keep");
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  
	  
	  //Assertions
	 // String task3 = driver.findElementByXPath("//android.widgetCo.TextView[@text ='Complete the second Activity Google Keep']").getText();
	  String task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\'Complete the second Activity Google Keep\']/android.widget.LinearLayout/android.widget.TextView']").getText();
	  Assert.assertEquals(task3, "Complete the second Activity Google Keep");
	  Reporter.log("task 3 completed");
	  
	// String task2 = driver.findElementByXPath("//android.widget.TextView[@text ='Complete Activity with Google Keep']").getText();
	  String task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\'Complete Activity with Google Keep\']/android.widget.LinearLayout/android.widget.TextView']").getText();
	  
	  Assert.assertEquals(task2, "Complete Activity with Google Keep");
	  Reporter.log("task 2 completed");
	  
	  String task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\'Complete Activity with Google Tasks\']/android.widget.LinearLayout/android.widget.TextView").getText();
	  Assert.assertEquals(task1, "Complete Activity with Google Tasks");
	  Reporter.log("task 1 completed");
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
