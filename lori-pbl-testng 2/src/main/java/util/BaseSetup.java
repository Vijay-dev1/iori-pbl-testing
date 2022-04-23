package util;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static util.ConfigUtils.getElementValue;


public class BaseSetup extends GlobalVariables{

    public static void initDriver(String URL) throws IOException {
     //   WebDriverManager.chromedriver().setup();
     //   String driverFile="src/test/resources/webdriver/mac/chromedriver";

        String driverFile = "";
        device = getEnvDevice();
        switch (device){
            case "win":
                driverFile = envDriverPath + getElementValue("base","windriver");
                break;
            case "mac":
                driverFile = envDriverPath + getElementValue("base","macdriver");
                break;
        }
        System.setProperty("webdriver.chrome.driver",driverFile);
        ChromeOptions options = new ChromeOptions();
        //add the headless argument
       //options.addArguments("headless");
        driver= new  ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static String getEnvDevice(){
        if (System.getProperty("device") != null){
            device = System.getProperty("device").toLowerCase();
        }
        return device;
    }


}
