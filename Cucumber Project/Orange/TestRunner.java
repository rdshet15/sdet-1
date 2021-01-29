package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)

@CucumberOptions(
features = "src/test/java/Features",
glue = {"stepDefinations"},
tags = "@CreateMulVacancy",
plugin = { "pretty", "html:target/cucumber-reports/reports.html","junit:target/cucumber-reports/cucumber.xml","json:target/cucumber-reports/Cucumber.json" },
monochrome = false,
dryRun = false

)
public class TestRunner {}
