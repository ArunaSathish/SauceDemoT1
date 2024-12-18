package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Dell\\eclipse-workspace\\SauceDemo_TestingProject\\Features.feature",
    glue = {"StepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports"}
    
)
public class testrunner {

}
