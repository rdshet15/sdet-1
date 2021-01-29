package stepDefinations;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class AddRecruitmentCandidate extends Baseclass {
	
	File file = new File("C:/Users/RaghavendraShet/Desktop/check.txt");
	String fname = "Agold";
	String lname = "Sha";
	String email = "Takdi@gmail.com";

		@Given("^Open the ​OrangeHRM​ page and login with credentials provided$")
		public void open_the_OrangeHRM_page_and_login_with_credentials_provided() {
			driver.get("http://alchemy.hguy.co/orangehrm");
			driver.findElement(By.cssSelector("#txtUsername")).sendKeys("orange");
			driver.findElement(By.cssSelector("#txtPassword")).sendKeys("orangepassword123");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("#btnLogin")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}


		
		@Given("^Navigate to the Recruitment page and click on the Add button to add candidateinformation$")
		public void navigate_to_the_recruitment_page_and_click_on_the_add_button_to_add_candidateinformation() {
			driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
			driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
			driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
			driver.findElement(By.id("btnAdd")).click();
		}
		@When("^On the next page, fill in the details of the candidate$")
		public void on_the_next_page_fill_in_the_details_of_the_candidate() {
			driver.findElement(By.cssSelector("#addCandidate_firstName")).sendKeys(fname);
			
//			String fname = driver.findElement(By.cssSelector("#addCandidate_firstName")).getText();
			
			driver.findElement(By.cssSelector("#addCandidate_lastName")).sendKeys(lname);
//			String lname = driver.findElement(By.cssSelector("#addCandidate_lastName")).getText();
			
			driver.findElement(By.cssSelector("#addCandidate_email")).sendKeys(email);
			
			Select vacancy = new Select(driver.findElement(By.id("addCandidate_vacancy")));
			vacancy.selectByIndex(5);

		   
		}
		@When("^Upload a resume to the form and click SAVE$")
		public void upload_a_resume_docx_or_pdf_to_the_form_and_click_save() throws Throwable {
						
			WebElement upload = driver.findElement(By.id("addCandidate_resume"));
			upload.sendKeys(file.getAbsolutePath());
			
			
			driver.findElement(By.id("addCandidate_consentToKeepData")).click();
			driver.findElement(By.id("btnSave")).click();
		    
		}	
		@Then("^Navigate back to the Recruitments page to confirm candidate entry$")
		public void navigate_back_to_the_recruitments_page_to_confirm_candidate_entry() {
			driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
			driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(fname+" "+lname);
			driver.findElement(By.id("btnSrch")).click();
			String search = driver.findElement(By.cssSelector("div.box.noHeader:nth-child(2) div.inner div:nth-child(5) table.table.hover tbody:nth-child(2) tr.odd:nth-child(1) > td.left:nth-child(3)")).getText();
			assertEquals(search, fname+" "+lname);
		}	
		



}
