package amazon;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.Assert.*;

public class PersonalityMobileTry {

    private WebDriver driver;


    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone Simulator");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "7.1");
        capabilities.setCapability("browserName", "safari");
        driver = new RemoteWebDriver(new URL("http://alex_yem22:e8760d07-6354-4530-b74f-c91e9556f7f6@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);

    }


    @Test
    public void runTest() throws Exception {
        driver.get("http://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("test");
    }

    @After
    public void printSessionId() {
        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) driver).getSessionId()).toString(), "PersonalityMobileTest");
        System.out.println(message);
       driver.close();
        driver.quit();
    }
}
