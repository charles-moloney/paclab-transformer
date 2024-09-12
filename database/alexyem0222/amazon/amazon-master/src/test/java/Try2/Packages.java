package Try2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class Packages {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void setup(){
        driver.get("http://www.personalityhotels.com");
    }

    @Test
    public void clickonpackages(){
        WebElement packages =driver.findElement(By.cssSelector("html body#home.tmpl-generic div.container div#container-content div#col-1 div.tab-menu ul li a#t-packages"));
        packages.click();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
