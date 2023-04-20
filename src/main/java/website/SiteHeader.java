package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteHeader extends Site {

    public SiteHeader(WebDriver driver) {
        super(driver);
    }


    public void goToAppAndroid() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-mobile-app-dl-android\"]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToAppIos() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-mobile-app-dl-apple\"]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }
}