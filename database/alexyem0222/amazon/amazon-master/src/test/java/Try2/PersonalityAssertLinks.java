package Try2;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;


public class PersonalityAssertLinks {
WebDriver driver = new FirefoxDriver();
    @Before
    public void setup(){

        driver.get("http://www.personalityhotels.com");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //assertEquals("Get Perk'd - Reward your Personality at Personality Hotels",driver.getTitle());
    }
    @Test
    public void jumptoanotherpage(){
        driver.findElement(By.cssSelector("input[class='button']")).click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
