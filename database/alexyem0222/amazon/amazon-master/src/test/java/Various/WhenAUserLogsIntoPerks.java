package Various;
import org.databene.benerator.anno.Source;
import org.databene.feed4junit.Feeder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Feeder.class)
public class WhenAUserLogsIntoPerks {
    private PerksLoginBase loginPage;

    @Before
    public void openBrowserWithLink(){
        loginPage = PageFactory.initElements(new FirefoxDriver(), PerksLoginBase.class);
        loginPage.open("http://www.personalityperks.com");
    }

    @Test
    @Source("C:\\\\Users\\\\Alex\\\\Desktop\\\\personalityperks.xls")
    public void loginwithExcel(String email, String password, String message) {
        loginPage.loginUsingEmailAndPassword(email, password, message);
    }

    @After
    public void closeSelenium(){
        loginPage.close();
    }
   /*
    @Test
        public void loginRegisteredUser(){
            loginPage.loginUsingEmailAndPassword("love2@love.com", "love@22", "Welcome Larisa Ivanovna!");
            loginPage.logout();
    }

    @Test
    public void loginWithError(){
        loginPage.loginUsingEmailAndPassword("love@love.com", "love@22", "We're sorry, but we were unable to log you in to your Personality Perks account!");

    }


    @Test
    public void invalidLoginNoEmail(){
        loginPage.invalidLogin("", "love2@love.com");
        assertTrue(loginPage.isAlertPresentWithText().contains("The E-mail Address field is required"));
    }

    @Test
    public void invalidLoginNoPassword(){
        loginPage.invalidLogin("love2@love.com", "");
        assertTrue(loginPage.isAlertPresentWithText().contains("The Password field is required"));
    }

    @Test
    public void invalidLoginNoEmailPassword(){
        loginPage.invalidLogin("", "");
        assertTrue(loginPage.isAlertPresentWithText().contains(""));

    }
    */

 }
