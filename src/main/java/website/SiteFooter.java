package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteFooter extends Site {

    public SiteFooter(WebDriver driver) {
        super(driver);
    }

//    public void goToPayment() {
//        TestUtility.getElementBySelector(driver, By.xpath(".//*[@id=\"main\"]/div[1]/ul/li[3]")).click();
//        TestUtility.waitUntilPageLoads(driver, 20);
//    }

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

    public void goToBlog() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[3]/nav/ul/li[1]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }
}

