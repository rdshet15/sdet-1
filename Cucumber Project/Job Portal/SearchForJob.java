package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import io.cucumber.java.en.*;

public class SearchForJob extends Baseclass {
	
//	WebDriver driver;
//	WebDriverWait wait;
	
	@Given("^Open browser with Alchemy Jobs site and navigate to Jobs page$")
	public void open_browser_with_alchemy_jobs_site_and_navigate_to_jobs_page() {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.findElement(By.cssSelector("#user_login")).sendKeys("root");
		driver.findElement(By.cssSelector("#user_pass")).sendKeys("pa$$w0rd");;
		driver.findElement(By.cssSelector("#wp-submit")).click();
		driver.findElement(By.linkText("Alchemy Jobs")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Jobs")).click();
	}

	@When("^Enter keyword and filter job type to show only Full Time jobs$")
	public void enter_keyword_and_filter_job_type_to_show_only_full_time_jobs() {
		driver.findElement(By.cssSelector("#job_type_freelance")).click();
		driver.findElement(By.cssSelector("#job_type_internship")).click();
		driver.findElement(By.cssSelector("#job_type_part-time")).click();
		driver.findElement(By.cssSelector("#job_type_temporary")).click();
		driver.findElement(By.cssSelector("#search_keywords")).sendKeys("Testlead");
		driver.findElement(By.xpath("//div[@class='search_submit']//input[@type='submit']")).click();



	}

	@Then("^select a job see job details$")
	public void select_a_job_see_job_details() {
		driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/job/ibmibmibmibmibm-hyderabad-2-testlead-2/']//div[@class='position']//h3[contains(text(),'TestLead')]")).click();
		String desc = driver.findElement(By.xpath("//div[@class='job_description']")).getText();
		System.out.println(desc);
	}

	@And("^Find the title of the job  and print it to the console$")
	public void find_the_title_of_the_job_and_print_it_to_the_console() {

		String element = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		System.out.println(element);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //input[


	}

	@And("^Click on the Apply for job button$")
	public void click_on_the_apply_for_job_button() {
		driver.findElement(By.xpath("//input[@type='button']")).click();

	}


}
