package SuperPersonality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PersonalityPerks {

    private WebDriver driver;

   @FindBy(xpath="/html/body/div/div[2]/ul/li[2]/a")
   private  WebElement updateYourProfile;


    public PersonalityPerks(WebDriver driver) {
        this.driver = driver;
    }

    public String getTopResultTitle() throws InterruptedException {
        Thread.sleep(2000);
        return updateYourProfile.getText();
}

    public boolean isTextPresent(String text){
        return driver.getPageSource().contains(text);
    }

    public boolean isElementPresent(WebDriver driver, By by){
        try{
            driver.findElement(by);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }
}




