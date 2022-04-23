package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalVariables {
    public static WebDriver driver;
    public static WebDriverWait webWait;
    public static int Error_log;
    public static boolean fail = false;
    public static String comments = "";
    public static String envConfigFile = "src/main/resources/env/" + System.getProperty("env") + ".xml";
    public static String envDriverPath = "src/test/resources/webdriver/";
    public String env = "stg";
    public static String device = "win";
}
