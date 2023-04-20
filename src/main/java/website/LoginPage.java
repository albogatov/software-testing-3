package website;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginPage extends Site {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignUp() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-signin\"]")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"root\"]/div/div/form/p[2]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);

    }

    public void goToLogin() {
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"appbar-signin\"]")).click();
    }

    public void doLogin() {
        tryLogin(TestUtility.CORRECT_LOGIN, TestUtility.CORRECT_PASSWORD);
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void doWrongLogin() {
        tryLogin(TestUtility.CORRECT_LOGIN, TestUtility.WRONG_PASSWORD);
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void doSignUp() {
        trySignUp(TestUtility.CORRECT_LOGIN, TestUtility.CORRECT_PASSWORD);
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    private void tryLogin(CharSequence login, CharSequence password) {
        WebElement loginInput = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"username\"]"));
        WebElement loginPassword = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"password\"]"));
        WebElement authButton = TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/button"));
        loginInput.clear();
        loginPassword.clear();
        loginInput.sendKeys(login);
        loginPassword.sendKeys(password);
        authButton.click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"hs_cos_wrapper_widget_1674774617303_\"]/img"));

    }

    private void trySignUp(CharSequence login, CharSequence password) {
        //TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/p[2]/a")).click();
        //TestUtility.waitUntilPageLoads(driver, 20);
        WebElement emailInput = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"email\"]"));
        WebElement loginInput = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"username\"]"));
        WebElement loginPassword = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"password\"]"));
        WebElement confirmPassword = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"mui-17\"]"));
        WebElement authButton = TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/button"));
        emailInput.clear();
        loginInput.clear();
        loginPassword.clear();
        confirmPassword.clear();
        emailInput.sendKeys("ale.ole.nine.six@gmail.com");
        loginInput.sendKeys(login);
        loginPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        WebElement acceptSomeGoddamnSpam = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"root\"]/div/div/form/label[5]/span"));

        acceptSomeGoddamnSpam.click();
        authButton.click();
        TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"hs_cos_wrapper_widget_1674774617303_\"]/img"));
    }
}
