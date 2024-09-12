package SuperPersonality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class LoginBase {
    public WebDriver driver;

    @FindBy(id="loginEmail")
    @CacheLookup
    private WebElement loginEmailAddress;

    @FindBy(id="loginPassword")
    @CacheLookup
    private WebElement loginPassword;

    @FindBy(xpath="//*[@id=\"login\"]/fieldset/div/button")
    @CacheLookup
    private WebElement userLoginButton;

    @FindBy(xpath="//*[@id=\"menu\"]/li[6]/a")
    @CacheLookup
    private WebElement logout;

    @FindBy(xpath="/html/body/div/div[2]/div/form/fieldset/div/a")
    @CacheLookup
    private WebElement lostPassword;


    public LoginBase (WebDriver driver){
        this.driver = driver;
    }

    public PersonalityPerks login(String email, String password) {

        loginEmailAddress.sendKeys(email);
        loginPassword.sendKeys(password);
        userLoginButton.click();
        return PageFactory.initElements(driver, PersonalityPerks.class);
    }



    public static LoginBase navigateTo(WebDriver driver) {
        driver.get("http://www.personalityperks.com");
        return PageFactory.initElements(driver, LoginBase.class);
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

