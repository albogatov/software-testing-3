package website;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestUtility {

    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String CHROME_SYSTEM_PROPERTY_PATH = "drivers/chromedriver";
    public static final String SAFARI_SYSTEM_PROPERTY_NAME = "webdriver.safari.driver";
    public static final String SAFARI_SYSTEM_PROPERTY_PATH = "/usr/bin/safaridriver";


    public static final String BASE_URL = "https://photobucket.com";


    public static final String CORRECT_LOGIN = "TpoLab3Abogatov";
    public static final String DISPLAY_NAME = "TpoLab3Abogatov";
    public static final String CORRECT_PASSWORD = "1234abcdlk";
    public static final String WRONG_PASSWORD = "4321abcdlk";

    public static List<WebDriver> getDrivers() {
        List<WebDriver> drivers = new ArrayList<>();
        try {
            drivers.add(getChromeDriver());
            drivers.add(getSafariDriver());
            return drivers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Web driver isssue");
    }

    private static ChromeDriver getChromeDriver() {
        if (!System.getProperties().containsKey(CHROME_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Chrome driver not set properly");
        }
        return new ChromeDriver();
    }

    private static SafariDriver getSafariDriver() {
        if (!System.getProperties().containsKey(SAFARI_SYSTEM_PROPERTY_NAME)) {
            throw new RuntimeException("Safari driver not set properly");
        }
        return new SafariDriver();
    }

    public static void prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH);
        System.setProperty(SAFARI_SYSTEM_PROPERTY_NAME, SAFARI_SYSTEM_PROPERTY_PATH);
    }

    public static WebElement getElementBySelector(WebDriver driver, By selector) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitUntilPageLoads(WebDriver driver, long timeout) {
        WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}