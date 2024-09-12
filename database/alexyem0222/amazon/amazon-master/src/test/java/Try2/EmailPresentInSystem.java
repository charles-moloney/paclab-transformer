package Try2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThat;

public class EmailPresentInSystem {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void setup(){
        driver.get("http://www.personalityperks.com/")  ;
        Assert.assertEquals("Get Perk'd - Reward your Personality at Personality Hotels",driver.getTitle());
}
    @Test
    public void userexists(){
        WebElement firstname = driver.findElement(By.id("firstName"));
        WebElement lastname = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("enrollEmail"));
        WebElement password = driver.findElement(By.id("setpassword"));
        WebElement confirmpass= driver.findElement(By.id("match-setpassword"));
        WebElement submitbtn = driver.findElement(By.xpath("/html/body/div/div[2]/div/form[2]/fieldset[3]/div/button"));

        firstname.sendKeys("Larisa");
        lastname.sendKeys("Ivanovna") ;
        email.sendKeys("love2@love.com") ;
        password.sendKeys("love@22") ;
        confirmpass.sendKeys("love@22");
        submitbtn.click();

        Assert.assertTrue(driver.getPageSource().contains("The e-mail address, love2@love.com, is already in use!")) ;
}
    @After
    public void tearDown() throws Exception {
        driver.quit();
}
}