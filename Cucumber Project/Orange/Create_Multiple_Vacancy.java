package stepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class Create_Multiple_Vacancy extends Baseclass{
		String role = "Ajedips Engs2";


	@Given("^Open the OrangeHRM page and login with credentials provided$")
	public void open_the_orange_hrm_page_and_login_with_credentials_provided() {

		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("orange");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("orangepassword123");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@And("^Navigate to the Recruitment page$")
	public void navigate_to_the_recruitment_page() {
		
		driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
		driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();

	}

	@And("^Click on the Vacancies menu item to navigate to the vacancies page$")
	public void click_on_the_vacancies_menu_item_to_navigate_to_the_vacancies_page() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	}
	@And("^Click on the Add button to navigate to the Add Job Vacancy form$")
	public void Click_on_the_Add_button_to_navigate_to_the_Add_Job_Vacancy_form() {
		driver.findElement(By.id("btnAdd")).click();
	}

	@When("^Fill out the necessary details \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void fill_out_the_necessary_details(String Job_Title, String Vacancy_name, String Hiring_Manager, String Positions) {
		
		Select title1 = new Select(driver.findElement(By.cssSelector("select#addJobVacancy_jobTitle")));
		title1.selectByVisibleText(Job_Title);
		driver.findElement(By.cssSelector("#addJobVacancy_name")).sendKeys(Vacancy_name);
		driver.findElement(By.cssSelector("#addJobVacancy_hiringManager")).sendKeys(Hiring_Manager);
		driver.findElement(By.cssSelector("#addJobVacancy_noOfPositions")).sendKeys(Positions);
		

	}

	@And("^Click the Save button to save the vacancy$")
	public void click_the_save_button_to_save_the_vacancy() {
		driver.findElement(By.cssSelector("#btnSave")).click();}

	@Then("^Verify that the vacancy was created \"(.*)\"$")
	public void verify_that_the_vacancy_was_created(String Vacancy_name) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		Select 	joblist = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
		joblist.selectByVisibleText(Vacancy_name);

		
		
	}
//
//	@And("Close the browser.")
//	public void close_the_browser() {
//	}

}
