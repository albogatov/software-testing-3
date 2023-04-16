package website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupportCenter extends Site{
    public SupportCenter(WebDriver driver) {
        super(driver);
    }

    public void getSupport() {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/footer/div[1]/div[2]/div/div[2]/nav/ul/li[1]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
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
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/header/div[2]/nav/a")).click();
        TestUtility.waitUntilPageLoads(driver, 30);
        WebElement email = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[1]"));
        WebElement username = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[2]"));
        WebElement planDropdown = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[3]"));
        WebElement categoryDropdown = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[4]"));
        WebElement subject = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[5]"));
        WebElement input = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/div[7]"));
        WebElement submit = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"new_request\"]/footer/input"));

//        email.clear();
//        username.clear();
//        subject.clear();
//        input.clear();
        email.sendKeys(TestUtility.CORRECT_LOGIN + "@gmail.com");
        username.sendKeys(TestUtility.CORRECT_LOGIN);
        subject.sendKeys("Ooops");
        input.sendKeys("Why do i have to pay");
        planDropdown.click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"lite\"]")).click();
        categoryDropdown.click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"subscription\"]")).click();
        submit.click();
    }
}
