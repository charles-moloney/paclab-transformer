package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

/**
 * Provides testing support for the Index page.
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newContact";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("NewContact (digits)");
  }


  /**
   * This method will fill in contact information for the integration test.
   * @param firstName this is the first name.
   * @param lastName this is the last name.
   * @param telephone this is the telephone.
   * @param telephoneType thsi is the telephone type.
   * @param address this is the address.
   */
  public void createContact(String firstName, String lastName, String telephone, String telephoneType, String address) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#telephone").with(telephone);
    find("select", withId("telephoneType")).find("option", withId(telephoneType)).click();
    fill("#address").with(address);
    submit("#submit");
  }
  
  
}
