package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Day17_GoogleSearchStepDefinitions {
// This step definition class will have JAVA CODE

    GooglePage googlePage = new GooglePage();

    @Given("user is on the google page")
    public void userInOnTheGooglePage() {

        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
    }

    @Given("user search for iPhone")
    public void userSearchForIPhone() {

        googlePage.googleSearchBox.sendKeys("iPhone" + Keys.ENTER);
    }

    @Then("verify the result has iPhone")
    public void verifyResultHasIPhone() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("iPhone"));
    }

    @Then("close the application")
    public void closeTheApp() {
        Driver.closeDriver();
    }

    @And("user search for tea pot")
    public void userSearchForTeaPot() {
        googlePage.googleSearchBox.sendKeys("tea pot" + Keys.ENTER);
    }

    @Then("verify the result has tea pot")
    public void verifyTheResultHasTeaPot() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("tea pot"));
    }

    @And("user search for flower")
    public void userSearchForFlower() {
        googlePage.googleSearchBox.sendKeys("flower" + Keys.ENTER);
    }

    @Then("verify the result has flower")
    public void verifyTheResultHasFlower() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("flower"));
    }

    @And("user search for tesla")
    public void userSearchForTesla() {
        googlePage.googleSearchBox.sendKeys("tesla" + Keys.ENTER);
    }

    @Then("verify the result has tesla")
    public void verifyTheResultHasTesla() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("tesla"));
    }

    @And("user search for {string}")
    public void userSearchFor(String arg0) {
        googlePage.googleSearchBox.sendKeys(arg0 + Keys.ENTER);
   }

    @Then("verify the result has {string}")
    public void verifyTheResultHas(String arg0) {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(arg0));
    }
}
