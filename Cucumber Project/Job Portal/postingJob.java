package stepDefinations;


import static org.testng.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class postingJob extends Baseclass {
	
//	WebDriver driver;
//	WebDriverWait wait;
	
		@Given("^Open browser with Alchemy Jobs site$")
		public void open_browser_with_alchemy_jobs_site() {
			driver.get("https://alchemy.hguy.co/jobs/wp-admin");
			driver.findElement(By.cssSelector("#user_login")).sendKeys("root");
			driver.findElement(By.cssSelector("#user_pass")).sendKeys("pa$$w0rd");;
			driver.findElement(By.cssSelector("#wp-submit")).click();
			driver.findElement(By.linkText("Alchemy Jobs")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}


		@And("^Go to post a job page$")
		public void go_to_post_a_job_page() {
			driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]")).click();
			
			
		   
		}
		@And("^Fill the job details (.*) and (.*) and (.*) and (.*)$")
		public void read_job_information_from_the_feature_file_table_and_fill_in_the_details(String JobTitle, String Location, String JobType, String Description) {
			driver.findElement(By.cssSelector("#job_title")).sendKeys(JobTitle);
			driver.findElement(By.cssSelector("#job_location")).sendKeys(Location);
			driver.findElement(By.cssSelector("#job_type")).sendKeys(JobType);
			driver.findElement(By.cssSelector("#job_description_ifr")).sendKeys(Description);
		   
		}
		@When("^Click submit$")
		public void click_submit() {
			driver.findElement(By.name("submit_job")).click();
			driver.findElement(By.id("job_preview_submit_button")).click();
		   
		}
		@And("^Go to jobs page$")
		public void go_to_jobs_page() {
			driver.findElement(By.linkText("Jobs")).click();
		}
		@Then("^Confirm job listing is shown on page (.*)$")
		public void confirm_job_listing_is_shown_on_page(String JobTitle) {
			driver.findElement(By.cssSelector("#search_keywords")).sendKeys(JobTitle);
			driver.findElement(By.xpath("//div[@class='search_submit']")).click();
			String element1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/div[1]/h3[1]")).getText();
			assertEquals(element1,JobTitle);
//			assertEquals(element1, expected);
		}





}
