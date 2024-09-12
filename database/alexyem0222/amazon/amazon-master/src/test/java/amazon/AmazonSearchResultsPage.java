package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchResultsPage {

    private WebDriver driver;

    //@FindBy(css="#result_0.fstRow h3.newaps a")
    @FindBy(xpath="//*[@id=\"link-1\"]")
    private WebElement topResultTitle;

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTopResultTitle() throws InterruptedException {
        Thread.sleep(5000);
        return topResultTitle.getText();
    }

}