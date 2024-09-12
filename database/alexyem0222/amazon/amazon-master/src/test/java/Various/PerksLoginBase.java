package Various;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerksLoginBase {
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


    public PerksLoginBase (WebDriver driver){
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void invalidLogin(String emailaddress, String password){
        loginEmailAddress.sendKeys(emailaddress);
        loginPassword.sendKeys(password);
        userLoginButton.click();
    }


    public String isAlertPresentWithText(){
        //boolean presentFlag = false;
       // try {
            // Check the presence of alert
            Alert alert = driver.switchTo().alert();
            // Alert present; set the flag
            //presentFlag = true;
           String AlertText = alert.getText();
           return AlertText;
       //System.out.println(AlertText);

           // alert.accept();

   // }    catch (NoAlertPresentException ex){
     //       //Alert not present
       //     ex.printStackTrace();
       // }
        //return presentFlag;
    }

    public void loginUsingEmailAndPassword(String userEmailAddress, String userPassword, String message){
        loginEmailAddress.sendKeys(userEmailAddress);
        loginPassword.sendKeys(userPassword);
        userLoginButton.click();
        getPageSource().contains(message);
        return;
    }

    public void lostPassword(){
        lostPassword.click();
    }

    public void logout(){
        logout.click();
    }

}
