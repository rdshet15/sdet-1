package stepDefinations;

import static org.testng.Assert.assertTrue;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class AddMulEmployee extends Baseclass{
	String userName;

	@Given("^Open the Orange HRM page and login with credentials provided$")
	public void open_the_orange_hrm_page_and_login_with_credentials_provided() {
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("orange");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("orangepassword123");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Find the PIM option in the menu and click it$")
	public void find_the_pim_option_in_the_menu_and_click_it() {
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b[text()='PIM']")).click();

		driver.findElement(By.xpath("//b[text()='PIM']")).click();


	}

	@And("^Click the Add button to add a new Employee$")
	public void click_the_add_button_to_add_a_new_employee() {

		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
	}

	@Then("^Fill the required fieds using data from Examples and repeatand click save \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" verify result$")

	public void fill_in_the_required_fields_using_the_data_from_the_examples_table_and_click_save(String FirstName, String lastNmae, String EmpID,String userName, String password, String confirmPassword) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("D");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastNmae); 

		driver.findElement(By.xpath("//input[@name='employeeId']")).clear();
		driver.findElement(By.xpath("//input[@name='employeeId']")).sendKeys(EmpID);

		driver.findElement(By.name("chkLogin")).click();
		driver.findElement(By.cssSelector("#user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.name("re_password")).sendKeys(confirmPassword);
		WebElement sel = driver.findElement(By.name("status"));
		Select sel1 = new Select(sel);
		sel1.selectByVisibleText("Enabled");


		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@class='firstLevelMenu']/b[text()='Admin']")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(userName);
		driver.findElement(By.id("searchBtn")).click();

		List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']"));

		assertTrue(list.size()>0);
	}

	
}

