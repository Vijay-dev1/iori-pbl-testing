package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static pages.LoginPage.performLogin;

import org.openqa.selenium.By;
import pages.LoginPage;
import util.GlobalVariables;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static util.BaseSetup.initDriver;
import static util.ConfigUtils.getEnvUrl;

public class LoginSteps extends GlobalVariables {
        LoginPage loginpage;
    @Given("user navigates to hylalori page")
    public void hyla_user_is_on_hylalori_page() throws IOException {
        String url = getEnvUrl();
        initDriver(url);
        loginpage=new LoginPage(driver);
    }

    @When("already registered user logs into the application")
    public void enter_Valid_Credentials(DataTable credentials) throws InterruptedException {
        List<Map<String, String>> list = credentials.asMaps(String.class, String.class);
        String email = list.get(0).get("email");
        String password = list.get(0).get("password");
        performLogin(email,password);
    }

    @Then("user should be able to verify following on the dashboard Page successfully")
    public void VerifyElementsOnThePage(DataTable objects) throws InterruptedException {
        List<String> list = objects.asList(String.class);

        for (int i = 0; i<list.size(); i++) {
            String objname = list.get(i).toString();
            switch (objname) {
                case "Your Device":
                    if(driver.findElement(By.xpath("//h2[text()='Your Device']")).isDisplayed()){
                        System.out.println(objname + " exists");
                    }else{
                        System.out.println(objname + " not exists");
                    }
                    break;
                case "Service Request":

                    if(driver.findElement(By.xpath("//a[text()='Service Request']")).isEnabled()){
                        System.out.println(objname + " button is enabled");
                    }else{
                        System.out.println(objname + " button is not enabled");
                    }
                    break;
            }
        }
    }

    @Then("user clicks on Service Request button")
    public void click_Service_Request_button() throws InterruptedException {
        //driver.wait(6000);
        // Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Service Request']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//button[@id='logout-button']")).click();
    }

    @And("user logout successfully")
    public void user_logout() throws InterruptedException {
        //driver.wait(6000);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='DropdownMenu_button__g8omM']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='logout-button']")).click();
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
