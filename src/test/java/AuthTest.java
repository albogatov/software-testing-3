import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.LoginPage;
import website.SiteHeader;
import website.TestUtility;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest {

    @BeforeAll
    public static void prepareDrivers() {
        TestUtility.prepareDrivers();
    }

    @Test
    void checkSignUp() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.getSite(webDriver);
            loginPage.goToSignUp();
            loginPage.doSignUp();
            assertEquals("An account with this email already exists", TestUtility.getElementBySelector(webDriver, By.xpath("//*[@id=\"email-helper-text\"]")).getText());
            webDriver.quit();
        });
    }

    @Test
    void checkLogin() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.getSite(webDriver);
            loginPage.goToLogin();
            loginPage.doLogin();
            assertEquals("https://my.photobucket.com/lp/deactivation", webDriver.getCurrentUrl());
            webDriver.quit();
        });
    }

    @Test
    void checkWrongLogin() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.getSite(webDriver);
            loginPage.goToLogin();
            loginPage.doWrongLogin();
            assertEquals("Error logging in", TestUtility.getElementBySelector(webDriver, By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/div[2]/div")).getText());
            webDriver.quit();
        });
    }
}
