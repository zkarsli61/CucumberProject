package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DefaultPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class Day19_Login_Step_Definitions {
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();

    @Given("user is on the application page")
    public void user_is_on_the_application_page() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        Thread.sleep(1000);
//        if (loginPage.advancedLink.isDisplayed()){
        try {
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }
    }

    @Given("enter id {string}")
    public void enter_id(String string) {
        loginPage.username.sendKeys(string);
    }

    @Given("enter password {string}")
    public void enter_password(String string) {
        loginPage.password.sendKeys(string);
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify the {string} is displayed")
    public void verify_the_is_displayed(String string) {
        Assert.assertEquals(defaultPage.userId.getText(), string);
    }

    @Given("user enters manager_id and manager_password")
    public void user_enters_manager_id_and_manager_password(DataTable credentials) {
// Getting the data as List<String>
// List<String> managerCredentials = credentials.row(0);
// loginPage.username.sendKeys(managerCredentials.get(0));
// loginPage.password.sendKeys(managerCredentials.get(1));

// Getting the data as List<List<String>>
//    List<List<String>> managerCredentials = credentials.asLists();

        //        for (List<String> each : managerCredentials) {
        //            if(!each.get(0).equals("id")){
        //                loginPage.username.sendKeys(each.get(0));
        //                loginPage.password.sendKeys(each.get(1));
        //            };
        //        }

        // Use lambda
//        managerCredentials.stream()
//                .filter(x-> !x.get(0).equals("id"))
//                .forEach(x-> {
//                            loginPage.username.sendKeys(x.get(0));
//                            loginPage.password.sendKeys(x.get(1));
//                        }
//                );

//        3. List<Map<String,String>>
        List<Map<String, String>> managerCredentials = credentials.asMaps(String.class, String.class);
        System.out.println(managerCredentials);
        for (Map<String, String> each : managerCredentials) {
            loginPage.username.sendKeys(each.get("id"));
            loginPage.password.sendKeys(each.get("password"));
        }
    }

    ExcelUtil excelUtil;
    List<Map<String, String>> testData;

    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("app_qa_environment"));
        loginPage = new LoginPage();
        Thread.sleep(1000);
        try {
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }
    }

    @Given("user log in the application using excel admin")
    public void user_log_in_the_application_using_excel_admin() throws InterruptedException {
        String path = "src/test/resources/testdata/smoketestdata.xlsx";
        String sheetName = "admin_login_info";
        excelUtil = new ExcelUtil(path, sheetName);
        testData = excelUtil.getDataList();
        System.out.println(testData);//[{password=Techproed123!, username=admin}]
        for (Map<String, String> eachData : testData) {//eachData represent each username-password pairs
            setUp();//login in each loop
            loginPage.username.sendKeys(eachData.get("username"));//admin
            loginPage.password.sendKeys(eachData.get("password"));//Techproed123!
            loginPage.loginButton.click();
        }
    }

    @Given("user log in the application using excel manager")
    public void user_log_in_the_application_using_excel_manager() throws InterruptedException {
        String path ="./src/test/resources/testdata/smoketestdata.xlsx";
        String sheetName="manager_login_info";
        excelUtil= new ExcelUtil(path,sheetName);
        testData=excelUtil.getDataList();
        System.out.println(testData);//[{password=Techproed123!, username=admin}]
        for(Map<String,String> eachData : testData ){//eachData represent each username-password pairs
            setUp();//login in each loop
            loginPage.username.sendKeys(eachData.get("username"));//admin
            loginPage.password.sendKeys(eachData.get("password"));//Techproed123!
            loginPage.loginButton.click();
        }
    }
}
