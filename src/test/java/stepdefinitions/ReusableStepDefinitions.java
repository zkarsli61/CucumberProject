package stepdefinitions;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

import java.io.IOException;

public class ReusableStepDefinitions {
    @Then("take the screenshot")
    public void take_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("capturing_screenshot");
    }
}
