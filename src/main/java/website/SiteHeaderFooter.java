package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SiteHeaderFooter extends Site {

    public SiteHeaderFooter(WebDriver driver) {
        super(driver);
    }

    public void goToSignIn() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-signin\"]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
        TestUtility.getElementBySelector(driver, By.xpath(".//div[@id='main']/div/div[2]/div/ul/li/ul/li/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);

    }

    public void goToLogin() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-signup\"]")).click();
    }

    public void goToApp() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-mobile-app-dl-android\"]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToPayment() {
        TestUtility.getElementBySelector(driver, By.xpath(".//*[@id=\"main\"]/div[1]/ul/li[3]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToPrintShop() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[1]/nav/ul/li[1]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToSocialMedia() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[1]/nav/a[5]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToContact() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[2]/nav/ul/li[3]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToSupport() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[2]/nav/ul/li[1]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void goToBlog() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[3]/nav/ul/li[1]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }
}

