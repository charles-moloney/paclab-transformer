package Try2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class RegisteredUserLogin {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Before
    public void setup() {
        driver.get("http://www.personalityperks.com");

    }

    @Test
    public void login() {
        WebElement email = driver.findElement(By.id("loginEmail"));
        WebElement password = driver.findElement(By.id("loginPassword"));
        WebElement loginbutton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/fieldset/div/button"));
        email.sendKeys("love2@love.com");
        password.sendKeys("love@22");
        loginbutton.click();
        //WebElement logoutlink = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/ul/li[5]/a"));
        //Assert.assertTrue("Verify logout link is displayed", logoutlink.isDisplayed());
        WebElement logoutlink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/ul/li[5]/a")));
        logoutlink.click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
