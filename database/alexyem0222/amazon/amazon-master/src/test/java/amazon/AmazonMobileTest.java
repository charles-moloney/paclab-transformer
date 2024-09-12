package amazon;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static junit.framework.Assert.assertEquals;

/**
 * Simple {@link RemoteWebDriver} test that demonstrates how to run your Selenium tests with <a href="http://ondemand.saucelabs.com/ondemand">Sauce OnDemand</a>.
 * *
 * @author Ross Rowe
 */
public class AmazonMobileTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabillities = DesiredCapabilities.iphone();
        capabillities.setCapability("version", "5.0");
        capabillities.setCapability("platform", Platform.MAC);
        this.driver = new RemoteWebDriver(
                new URL("http://alex_yem22:e8760d07-6354-4530-b74f-c91e9556f7f6@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);
    }

    @Test
    public void basic() throws Exception {
        driver.get("http://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.sendKeys("test");
    }

    @After
    public void printSessionId() {
        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) driver).getSessionId()).toString(), "AmazonMobileTest");
        System.out.println(message);
       // driver.close();
        driver.quit();
    }
}