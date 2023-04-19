package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteHeader extends Site {

    public SiteHeader(WebDriver driver) {
        super(driver);
    }


    public void goToApp() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-mobile-app-dl-android\"]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }
}