import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import website.SiteFooter;
import website.TestUtility;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutsideLinksTest {
    @BeforeAll
    public static void prepareDrivers() {
        TestUtility.prepareDrivers();
    }

    @Test
    void checkPrintShop() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.getSite(webDriver);
            siteFooter.goToPrintShop();
            ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://www.printshoplab.com", webDriver.getCurrentUrl().substring(0,28));
            webDriver.quit();
        });
    }

    @Test
    void checkSocial() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.getSite(webDriver);
            siteFooter.goToSocialMedia();
            ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://www.youtube.com/", webDriver.getCurrentUrl().substring(0,25));
            webDriver.quit();
        });
    }

    @Test
    void checkContact() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.getSite(webDriver);
            siteFooter.goToContact();
            assertEquals("https://zendesk.photobucket.com", webDriver.getCurrentUrl().substring(0, 31));
            webDriver.quit();
        });
    }

    @Test
    void checkBlog() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SiteFooter siteFooter = new SiteFooter(webDriver);
            siteFooter.getSite(webDriver);
            siteFooter.goToBlog();
            assertEquals("https://blog.photobucket.com", webDriver.getCurrentUrl().substring(0, 28));
            webDriver.quit();
        });
    }
}
