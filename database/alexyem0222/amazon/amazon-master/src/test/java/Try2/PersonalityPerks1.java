package Try2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class PersonalityPerks1 {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void setup(){
        driver.get("http://www.personalityperks.com");
        assertEquals("Get Perk'd - Reward your Personality at Personality Hotels",driver.getTitle());
    }

    @Test
    public void pillowtypebuttons(){
        WebElement pillowsFeatherbutton = driver.findElement(By.cssSelector("input[id=pillowType-Feather]"));
        WebElement pillowsFoambutton = driver.findElement(By.cssSelector("input[id=pillowType-Foam]")) ;
        if (pillowsFeatherbutton.isSelected()){
            pillowsFeatherbutton.click();
        }

        if (pillowsFoambutton.isSelected()){
            pillowsFoambutton.click();
        }
    }
    //assertFalse("Verify feather button not selected", pillowsFeatherbutton.isSelected());
    //assertFalse("Verify foam button not selected", pillowsFoambutton.isSelected());
    //assertEquals("Feather", pillowsFeatherbutton.getAttribute("value"));

    @Test
    public void specialrequesttext(){
        WebElement specialtexttry = driver.findElement(By.cssSelector("input[id=special]"));
        //assertEquals("", specialtexttry.getAttribute("value"));
        if (specialtexttry.getAttribute("value")!= ""){
            specialtexttry.clear();
        }
        specialtexttry.sendKeys("Yo moe");


    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}
