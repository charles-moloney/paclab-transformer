package amazon;

import com.saucelabs.junit.Parallelized;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.LinkedList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parallelized.class)
public class AmazonSearchTestParallel {

    private String browser;
    private String os;
    private String version;

    public AmazonSearchTestParallel(String os, String version, String browser) {
        super();
        this.os = os;
        this.version = version;
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static LinkedList browsersStrings() throws Exception {
        LinkedList browsers = new LinkedList();
        browsers.add(new String[]{Platform.XP.toString(), "17", "firefox"});
        browsers.add(new String[]{Platform.MAC.toString(), "34", "chrome"});
        //add any additional browsers here
        return browsers;
    }

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        this.driver = new RemoteWebDriver(
                new URL("http://alex_yem22:e8760d07-6354-4530-b74f-c91e9556f7f6@ondemand.saucelabs.com:80/wd/hub"), capabilities);
    }

  /*  @Test
    public void search_amazon() throws InterruptedException {
        AmazonHomePage homePage = AmazonHomePage.navigateTo(driver);
        AmazonSearchResultsPage resultsPage = homePage.searchFor("robin");
        try{
            assertThat(resultsPage.getTopResultTitle(), is("Robin (comics) - Wikipedia, the free encyclopedi"));
        }catch (Throwable e){
            System.out.println("Result title expected and actual DO NOT MATCH");
        }
    }  */

    @Test
    public void search_yahoo() throws InterruptedException {
        AmazonHomePage amazonHomePage = AmazonHomePage.navigateTo(driver);
        AmazonSearchResultsPage amazonSearchResultsPage = amazonHomePage.searchFor("selenium");
        assertThat(amazonSearchResultsPage.getTopResultTitle(), is("Selenium - Web Browser Automation"));
    }

    @After

    public void printSessionId() {

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                (((RemoteWebDriver) driver).getSessionId()).toString(), "AmazonSearchTestParallel");
        System.out.println(message);
        driver.close();
        driver.quit();
    }


}