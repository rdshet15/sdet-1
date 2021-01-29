package stepDefinations;
import static org.junit.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
public class activity3 extends Baseclass{
	
	@Given("^Navigate to Activities Meetings ScheduleaMeeting$")
	public void navigate_to_activities_meetings_schedulea_meeting() {
		
		driver.get("https://alchemy.hguy.co/crm/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'dashlet_entire')]")));
		
		Actions actions = new Actions(driver);
		WebElement menu = driver.findElement(By.id("grouptab_3"));
		WebElement meet = driver.findElement(By.id("moduleTab_9_Meetings"));
		actions.moveToElement(menu).click(meet).build().perform();
		
		
		
		WebElement menuActivities = driver.findElement(By.id("grouptab_3"));
		menuActivities.click();
		
		WebElement menuMeeting = driver.findElement(By.xpath("//a[@id='moduleTab_9_Meetings' and text()='Meetings']"));
		
		System.out.println(menuMeeting.getText());
		menuMeeting.click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," MEETINGS"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Schedule Meeting']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Schedule Meeting']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
		
	}
	
	@Given("^Enter the details of the meeting$")
	public void enter_the_details_of_the_meeting() {
		
		driver.findElement(By.id("name")).sendKeys("Meeting scheduled for activty3");

	}
	
	@Given("^Search for members and add them to the meeting$")
	public void search_for_members_and_add_them_to_the_meeting(DataTable searchData) throws InterruptedException {
	
		List<List<String>> search = searchData.asLists();
		
		System.out.println("number of rows " +search.size());
		for(int i=1;i<search.size();i++) {
			driver.findElement(By.id("search_first_name")).sendKeys(search.get(i).get(0));
			driver.findElement(By.id("search_last_name")).sendKeys(search.get(i).get(1));
			driver.findElement(By.id("search_email")).sendKeys(search.get(i).get(2));
			
			driver.findElement(By.id("invitees_search")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("invitees_add_1")).click();
			
			driver.findElement(By.id("search_first_name")).clear();
			driver.findElement(By.id("search_last_name")).clear();
			driver.findElement(By.id("search_email")).clear();
		}
			
		driver.findElement(By.id("SAVE_HEADER")).click();
		
	}
	
	@Then("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void gotoviewmeetingspageandconfirmcreation() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Meetings']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Meetings']")).click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," MEETINGS"));
		assertEquals(driver.findElement(By.xpath("//td[@field='name']")).getText(),"Meeting scheduled for activty3");
	}


}