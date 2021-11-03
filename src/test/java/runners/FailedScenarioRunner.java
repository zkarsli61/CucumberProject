package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = { "src/test/resources/features" }, glue = {
//        "src/test/java/stepdefinitions" })
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun: target/failedRerun.txt"
        },
        //Running path
        features = "@target/failedRerun.txt",
        glue = "stepdefinitions",
//        tags = "@room_reservation",
        dryRun = false
)
public class FailedScenarioRunner {
}
