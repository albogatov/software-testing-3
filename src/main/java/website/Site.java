package website;


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
}

