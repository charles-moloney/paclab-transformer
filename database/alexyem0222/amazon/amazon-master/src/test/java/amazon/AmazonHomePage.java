package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

    private WebDriver driver;

    @FindBy(name="p")
    private WebElement keywordsField;

    @FindBy(xpath="//*[@id=\"search-submit\"]")
    private WebElement goButton;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AmazonSearchResultsPage searchFor(String searchTerm) {
        keywordsField.sendKeys(searchTerm);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(goButton));
        goButton.click();
        new WebDriverWait(driver, 50);
        return PageFactory.initElements(driver, AmazonSearchResultsPage.class);
    }

    public static AmazonHomePage navigateTo(WebDriver driver) {
        driver.get("http://www.yahoo.com");
        return PageFactory.initElements(driver, AmazonHomePage.class);
    }
}