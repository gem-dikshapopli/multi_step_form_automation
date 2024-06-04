package runner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/", // Path to your feature files
        glue = "stepDefinition",// Package where your step definitions are located
        plugin = { "pretty" ,"html:src/Reports/cucumber-reports.html" },
        monochrome = true


)
public class Runner extends AbstractTestNGCucumberTests {
}
