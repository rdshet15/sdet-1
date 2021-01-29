package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/java/Feature",
			glue = {"stepDefinations"},
			tags = "@Activity4",
			plugin = {"pretty","html:target/cucumber-reports/report1.html","json:target/cucumber-reports/report.json"},
			monochrome = true
	)
	public class testrunner {

	}