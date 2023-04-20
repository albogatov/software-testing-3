import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import website.SiteFooter;
import website.SiteHeader;
import website.TestUtility;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            //assertTrue(webDriver.getCurrentUrl().contains("https://www.printshoplab.com"));
            assertEquals("https://www.printshoplab.com", webDriver.getCurrentUrl().substring(0, 28));
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
            //assertTrue(webDriver.getCurrentUrl().contains("https://www.youtube.com/"));
            assertEquals("https://www.youtube.com/", webDriver.getCurrentUrl().substring(0, 24));
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
            //assertTrue(webDriver.getCurrentUrl().contains("https://zendesk.photobucket.com"));
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
            //assertTrue(webDriver.getCurrentUrl().contains("https://blog.photobucket.com"));
            assertEquals("https://blog.photobucket.com", webDriver.getCurrentUrl().substring(0, 28));
            webDriver.quit();
        });
    }

    @Test
    void checkAppAndroid() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SiteHeader siteHeader = new SiteHeader(webDriver);
            siteHeader.getSite(webDriver);
            siteHeader.goToAppAndroid();
            ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            assertEquals("https://play.google.com/store/apps/details?id=com.photobucket.android", webDriver.getCurrentUrl().substring(0, 68));
            //assertTrue(webDriver.getCurrentUrl().contains("https://play.google.com/store/apps/details?id=com.photobucket.android"));
            webDriver.quit();
        });
    }

    @Test
    void checkAppIos() {
        List<WebDriver> drivers = TestUtility.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            SiteHeader siteHeader = new SiteHeader(webDriver);
            siteHeader.getSite(webDriver);
            siteHeader.goToAppIos();
            ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            String url = webDriver.getCurrentUrl();
            assertEquals("https://apps.apple.com/us/app/photobucket-backup/", webDriver.getCurrentUrl().substring(0, 58));
            //assertTrue(webDriver.getCurrentUrl().contains("https://apps.apple.com/us/app/photobucket-backup/"));
            webDriver.quit();
        });
    }

}
