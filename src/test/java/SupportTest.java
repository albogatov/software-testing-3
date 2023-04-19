import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.SupportCenter;
import website.TestUtility;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupportTest {

    @BeforeAll
    public static void prepareDrivers() {
        TestUtility.prepareDrivers();
    }

    @Test
    void checkRequest() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SupportCenter support = new SupportCenter(webDriver);
            support.getSite(webDriver);
            support.getSupport();
            support.submitRequest();
            assertEquals("Security check", webDriver.getTitle());
            webDriver.quit();
        });
    }

    @Test
    void checkQuestion() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SupportCenter support = new SupportCenter(webDriver);
            support.getSite(webDriver);
            support.getSupport();
            support.selectQuestion();
            assertEquals("https://support.photobucket.com/hc/en-us/articles/", webDriver.getCurrentUrl().substring(0,50));
            webDriver.quit();
        });
    }

    @Test
    void checkSection() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SupportCenter support = new SupportCenter(webDriver);
            support.getSite(webDriver);
            support.getSupport();
            support.selectSection();
            assertEquals("https://support.photobucket.com/hc/en-us/categories/", webDriver.getCurrentUrl().substring(0,52));
            webDriver.quit();
        });
    }

    @Test
    void checkChat() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SupportCenter support = new SupportCenter(webDriver);
            support.getSite(webDriver);
            support.getSupport();
            support.useChat();
            assertEquals("Here are a few articles to help you with uploading.",
                    TestUtility.getElementBySelector(webDriver,
                            By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div/div[5]/div[1]/div[2]/div/span/span[2]"))
                            .getText());
            webDriver.quit();
        });
    }


}
