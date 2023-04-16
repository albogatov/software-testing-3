import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import website.SiteHeaderFooter;
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
        //WebDriver webDriver = drivers.get(0);
        drivers.parallelStream().forEach(webDriver -> {
            SupportCenter support = new SupportCenter(webDriver);
            webDriver.get(TestUtility.BASE_URL);
        webDriver.manage().window().maximize();
            TestUtility.getElementBySelector(webDriver, By.xpath("/html/body/div[1]/div/a")).click();
        TestUtility.waitUntilPageLoads(webDriver, 40);
            support.getSupport();
//            support.selectQuestion();
            support.submitRequest();
//            WebElement text = TestUtility.getElementBySelector(webDriver, By.xpath("/html/body/div[1]/div/div/strong"));
            assertEquals("Security check", webDriver.getTitle());
            webDriver.quit();
        });
    }

}
