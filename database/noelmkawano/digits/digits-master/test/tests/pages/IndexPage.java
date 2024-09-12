package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Provides testing support for the Index page.
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home (digits)");
  }


  /**
   * Checks that the page has a set of contact information.
   * @param firstName this is the first name.
   * @param lastName this is the last name.
   * @param telephone this is the telephone number.
   * @param telephoneType this is the telephone type.
   * @param address this is the address.
   */
  public void hasContacts(String firstName, String lastName, String telephone, String telephoneType, String address) {
    assertThat(pageSource()).contains(firstName);
    assertThat(pageSource()).contains(lastName);
    assertThat(pageSource()).contains(telephone);
    assertThat(pageSource()).contains(telephoneType);
    assertThat(pageSource()).contains(address);
  }
  
  
}
