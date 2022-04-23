package runners;

import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;



import java.io.File;
import java.io.IOException;

import static util.GlobalVariables.driver;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,monochrome = true
        ,publish = true
)

public class RunnerTest extends AbstractTestNGCucumberTests {

  //  static ExtentReport extentReportObject = new ExtentReport();

   @Parameters({"env","device"})
   @BeforeMethod
   public static void setUp(String val1, String val2) throws IOException {

    //   extentReportObject.publishReports();

       System.setProperty("env",val1);
       System.setProperty("device",val2);
        System.out.println(System.getProperty("env"));
       System.out.println(System.getProperty("device"));
    }

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//

//    @AfterStep
//    public void addScreenshot(Scenario scenario) throws IOException {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
//        scenario.attach(fileContent, "image/png", "screenshot");
//    }
//
    @Override
    public void tearDownClass() {
//        ExtentReport.extent.flush();
//        Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
//        Reporter.setSystemInfo("user", "Admin");
//        Reporter.setSystemInfo("Device", "Chrome");
//        Reporter.setTestRunnerOutput("Test Runner Output Logs");
    }
}
