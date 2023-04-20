package website;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SupportCenter extends Site{
    public SupportCenter(WebDriver driver) {
        super(driver);
    }

    public void getSupport() {
        Actions actions = new Actions(driver);
        WebElement support = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"root\"]/footer/div[1]/div[2]/div/div[2]/nav/ul/li[1]/a"));
        actions.moveToElement(support);
        TestUtility.waitUntilPageLoads(driver, 20);
        support.click();
    }

    public void selectSection() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/main/div/section/section[1]/ul/li[5]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void selectQuestion() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/main/div/section/section[2]/ul/li[1]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void submitRequest() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"user-nav\"]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 30);
        Actions actions = new Actions(driver);
        WebElement email = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"request_anonymous_requester_email\"]"));
        WebElement username = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"request_custom_fields_471642\"]"));
        WebElement planDropdown = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[3]/a"));
        WebElement categoryDropdown = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[4]/a"));
        WebElement subject = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"request_subject\"]"));
        WebElement input = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"request_description_ifr\"]"));
        WebElement submit = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/footer/input"));

        email.sendKeys(TestUtility.CORRECT_LOGIN + "@gmail.com");
        username.sendKeys(TestUtility.CORRECT_LOGIN);
        planDropdown.click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"lite\"]")).click();
        categoryDropdown.click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"subscription\"]")).click();
        actions.scrollToElement(subject);
        subject.sendKeys("Ooops");
        actions.scrollToElement(input);
        driver.switchTo().frame(input);
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("WHYYYYYYY");
        driver.switchTo().defaultContent();
        actions.scrollToElement(submit);
        submit.click();
        TestUtility.waitUntilPageLoads(driver, 30);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//*[contains(@id, \"cf-chl-widget\")]")));
    }

    public void useChat() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[3]/div[2]/iframe")).click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"home\"]")).click();
        driver.switchTo().frame(TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"home\"]/iframe")));
        //driver.switchTo().frame(TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[3]/div[1]/div/iframe")));
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"1val-field_1.3.10--input\"]")).sendKeys("Hi");
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/button")).click();
    }
}
