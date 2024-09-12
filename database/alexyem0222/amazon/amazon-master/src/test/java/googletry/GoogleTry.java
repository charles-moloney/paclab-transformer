package googletry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTry {

    public WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.navigate().to("http://www.google.com");
    }
     @Test
    public void searchGoogle(){
        WebElement searchBox = driver.findElement(By.name("x"));
        searchBox.sendKeys("hello");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
