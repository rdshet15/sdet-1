package stepDefinations;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class createANewUser extends Baseclass {

//	WebDriver driver;
//	WebDriverWait wait;
	String temp = "Saukra14";

	@Given("^Open a browser$")
	public void OpenABrowser() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);

	}

	@And("^Navigate to Alchemy Jobs site and log in$")
	public void NavigateToAlchemyJobsSiteAndLogIn() {
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.findElement(By.cssSelector("#user_login")).sendKeys("root");
		driver.findElement(By.cssSelector("#user_pass")).sendKeys("pa$$w0rd");
		;
		driver.findElement(By.cssSelector("#wp-submit")).click();
	}

	@When("^Locate the left hand menu and click the menu item that says Users$")
	public void LocateTheLeftHandMenuAndClickTheMenuItem() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Users')]")));

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Users')]")).click();

	}

	@And("^Locate the Add New button and click it$")
	public void LocateTheAddNewBbuttonAndClickIt() {
		driver.findElement(By.linkText("Add New")).click();
	}

	@And("^Fill in the necessary details$")
	public void AndFillInTheNecessaryDetails() {
		driver.findElement(By.cssSelector("#user_login")).sendKeys(temp);
		driver.findElement(By.cssSelector("#email")).sendKeys(temp + "@gmail.com");
		driver.findElement(By.cssSelector("#first_name")).sendKeys("Saukr");
		driver.findElement(By.cssSelector("#last_name")).sendKeys("Saukracom");
		driver.findElement(By.xpath("//button[contains(text(),'Show password')]")).click();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#pass1")));
//		driver.findElement(By.cssSelector("#pass1")).clear();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.cssSelector("#pass1")).sendKeys("Fool1233");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select role = new Select(driver.findElement(By.cssSelector("#role")));
		role.selectByValue("subscriber");
//		driver.findElement(By.name("pw_weak")).click();
		driver.findElement(By.cssSelector("#createusersub")).click();

	}

	@Then("^Verify that the user was created$")
	public void VerifyThatTheUserWasCreated() {
		driver.findElement(By.cssSelector("#user-search-input")).sendKeys(temp);
		driver.findElement(By.cssSelector("#search-submit")).click();
		WebElement text = driver.findElement(By.linkText(temp));
		String record = text.getText();

		// org.junit.Assert.assertEquals(record, "Saukra3");
		assertEquals(record, temp);

	}

//	@And("^Close the browser$")
//	public void closeTheBrowser(){
//		driver.close();
//	}

}
