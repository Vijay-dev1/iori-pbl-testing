package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.FindBy;
import util.CommonWrappers;
import util.GlobalVariables;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GlobalVariables {


    @FindBy(xpath="//*[@id='username']")
    static WebElement username;

    @FindBy(xpath="//*[@id='password']")
    static WebElement password;

    @FindBy(xpath="//button[text()='Sign In']")
    static WebElement signinbutton;

    @FindBy(xpath="//a[text()='Service Request']")
    static WebElement servicerequestbutton;

    @FindBy(xpath="//h2[text()='Your Device']")
    static WebElement yourdevicelabel;

    @FindBy(xpath="//button[@class='DropdownMenu_button__g8omM']")
    static WebElement dropdownmenubutton;

    @FindBy(xpath="//button[@id='logout-button']")
    static WebElement logoutbutton;


    public LoginPage(WebDriver driver)
    {
        GlobalVariables.driver = driver;
        PageFactory.initElements(driver, this);
        CommonWrappers WebWrappers = new CommonWrappers(driver);
    }

    public static void performLogin(String usernameData, String passwordData) throws InterruptedException {
       // Thread.sleep(2000);
       // driver.wait(2000);
         CommonWrappers.enterText(username,usernameData);
         CommonWrappers.enterText(password,passwordData);
        CommonWrappers.clickButton(signinbutton);
    }

    public static void verifyTextPresent(String label) throws InterruptedException {
        driver.wait(3000);
       // CommonWrappers.verifyLabel(label);
    }
}
