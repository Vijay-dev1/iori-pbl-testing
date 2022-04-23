package util;

//import com.cucumber.listener.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.logs.Log;
import org.testng.ITestListener;


import java.time.Duration;

public class CommonWrappers extends GlobalVariables{
    public static WebDriverWait webWait;
    public CommonWrappers(WebDriver driver) {
        //System.out.println("Testing1");
        GlobalVariables.driver = driver;
        PageFactory.initElements(driver, this);
        webWait = new WebDriverWait(driver, Duration.ofMinutes(60));
    }


    /**
     * This method for Entering the text in the Mobile text field
     *
     * @throws Exception
     **/
    public static void enterText(WebElement xpath, String msg) {
        try {
            webWait.until(ExpectedConditions.elementToBeClickable(xpath));
            xpath.clear();
            xpath.sendKeys(msg);
            if (!msg.isEmpty()) {
                Log.info("The " + msg + "' is entered");

              //  Reporter.log("The " + msg + "' is entered");
            }
        } catch (Exception e) {
            Log.error("The " + msg + "' could not enter in the field. Please check the screenshot ");
            //Reporter.addStepLog("The " + msg + "' could not enter in the field. Please check the screenshot ");
          //  Reporter.log("The " + msg + "' could not enter in the field. Please check the screenshot ");
        }
    }

    public static void clickButton(WebElement xpath) {
        try {
            webWait.until(ExpectedConditions.elementToBeClickable(xpath));
            xpath.click();
        } catch (Exception e) {
            Log.error("Could not click");
            //Reporter.addStepLog("The " + msg + "' could not enter in the field. Please check the screenshot ");
           // Reporter.log("Could not click");
        }
    }

    public static void verifyLabel(WebElement xpath) {
        try {
            //webWait.until(ExpectedConditions.elementToBeClickable(xpath));
          //  webWait.until(ExpectedConditions.presenceOfElementLocated(xpath));
            xpath.isDisplayed();
        } catch (Exception e) {
            Log.error("Could not find element");
            //Reporter.addStepLog("The " + msg + "' could not enter in the field. Please check the screenshot ");
            //Reporter.log("Could not find element");
        }
    }




}
