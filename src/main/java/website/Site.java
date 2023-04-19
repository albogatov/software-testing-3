package website;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Site {

    protected WebDriver driver;

    public Site(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void getSite(WebDriver webDriver) {
        webDriver.get(TestUtility.BASE_URL);
        webDriver.manage().window().maximize();
        TestUtility.getElementBySelector(webDriver, By.xpath("/html/body/div[1]/div/a")).click();
        TestUtility.waitUntilPageLoads(webDriver, 40);
    }
}

