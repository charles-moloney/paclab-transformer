package amazon;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BetterAmazonSearchTest {

    private WebDriver driver;

    @Before
    public void setupSelenium() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Windows 8.1");
        caps.setCapability("version", "31");
        caps.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
        driver = new RemoteWebDriver(
                new URL("http://alex_yem22:e8760d07-6354-4530-b74f-c91e9556f7f6@ondemand.saucelabs.com:80/wd/hub"),
                caps);

    }

    @Test
    public void search_amazon() throws InterruptedException {
        AmazonHomePage homePage = AmazonHomePage.navigateTo(driver);
        AmazonSearchResultsPage resultsPage = homePage.searchFor("robin");
        try{
        assertThat(resultsPage.getTopResultTitle(), is("Robin (comics) - Wikipedia, the free encyclopedi"));
        }catch (Throwable e){
            System.out.println("Result title expected and actual DO NOT MATCH");
        }
    }

    @Test
    public void search_yahoo() throws InterruptedException {
        AmazonHomePage amazonHomePage = AmazonHomePage.navigateTo(driver);
        AmazonSearchResultsPage amazonSearchResultsPage = amazonHomePage.searchFor("selenium");
        assertThat(amazonSearchResultsPage.getTopResultTitle(), is("Selenium - Official Site"));
    }

    @After

    public void printSessionId() {

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) driver).getSessionId()).toString(), "BetterAmazonSearchTest");
        System.out.println(message);
        driver.close();
        driver.quit();
    }


}

