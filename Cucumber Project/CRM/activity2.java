package stepDefinations;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class activity2 extends Baseclass {
	@Then("^Navigate to Sales Leads and CreateLead$")
	public void navigate_to_sales_leads_create_lead() throws InterruptedException {
		
		driver.get("https://alchemy.hguy.co/crm/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'dashlet_entire')]")));
		
		
		WebElement menu = driver.findElement(By.id("grouptab_0"));
		WebElement lead = driver.findElement(By.id("moduleTab_9_Leads"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).click(lead).build().perform();
		
		WebElement menuSales = driver.findElement(By.id("grouptab_0"));
		menuSales.click();
		
		WebElement menuLeads = driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads' and text()='Leads' and contains(@href,'Sales')]"));
		
		System.out.println(menuLeads.getText());
		menuLeads.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(@class,'module-title')]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
		
		
	}

	@Then("^Fill the details \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\"$")
	public void fill_the_details(String salutation, String fname, String lname) throws InterruptedException {
		Thread.sleep(10000);
		
		Select salution = new Select(driver.findElement(By.id("salutation")));
		salution.selectByVisibleText(salutation);
		driver.findElement(By.id("first_name")).sendKeys(fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		driver.findElement(By.id("SAVE")).click();
		
	    
	}
	
	@Then("^Navigate to View Leads page to see results \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\"$")
	public void navigate_to_view_leads_page_to_see_results(String salutation,String fname, String lname) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Leads']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("ul.listViewLinkButton_top:nth-child(5) > li:nth-child(1) > a:nth-child(1)")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first_name_advanced")));
		driver.findElement(By.id("first_name_advanced")).clear();
		driver.findElement(By.id("first_name_advanced")).sendKeys(fname);
		driver.findElement(By.id("last_name_advanced")).clear();
		driver.findElement(By.id("last_name_advanced")).sendKeys(lname);
		driver.findElement(By.id("search_form_submit_advanced")).click();
		Thread.sleep(5000);
		List<WebElement> filterElements = driver.findElements(By.xpath("//td[@class=' inlineEdit']/b/a"));
		assertEquals(salutation+fname+" "+lname,filterElements.get(0).getText());
	}
}