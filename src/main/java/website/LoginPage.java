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

    public void doLogin() {
        tryLogin(TestUtility.CORRECT_LOGIN, TestUtility.CORRECT_PASSWORD);
        TestUtility.waitUntilPageLoads(driver, 20);
    }

    public void doWrongLogin() {
        tryLogin(TestUtility.CORRECT_LOGIN, TestUtility.WRONG_PASSWORD);
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
    }

    private void trySignUp(CharSequence login, CharSequence password) {
        TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/p[2]/a")).click();
        TestUtility.waitUntilPageLoads(driver, 20);
        WebElement loginInput = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"username\"]"));
        WebElement loginPassword = TestUtility.getElementBySelector(driver, By.xpath("//*[@id=\"password\"]"));
        WebElement authButton = TestUtility.getElementBySelector(driver, By.xpath("/html/body/div[2]/div/div/form/button"));
        loginInput.clear();
        loginPassword.clear();
        loginInput.sendKeys(login);
        loginPassword.sendKeys(password);
        authButton.click();
    }
}
