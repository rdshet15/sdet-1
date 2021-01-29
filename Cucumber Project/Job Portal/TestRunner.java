package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)

@CucumberOptions(
features = "src/test/java/Features",
glue = {"stepDefinations"},
tags = "@Posting_job_using_examples_parameterization",
plugin = { "pretty", "html:target/cucumber-reports/reports","junit:target/cucumber-reports/cucumber.xml","json:target/cucumber-reports/Cucumber.json" },
monochrome = true

)
public class TestRunner {}
