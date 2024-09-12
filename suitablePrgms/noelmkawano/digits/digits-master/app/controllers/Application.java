package controllers;

import gov.nasa.jpf.symbc.Debug;
import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Object index() {
    return new Object();
  }

  /**
   * Returns newContact, a simple example of a second page to illustrate navigation.
   * @param id input this thing.
   * @return The newContact.
   */
  public static Object newContact(long id) {
    return new Object();

  }

  /**
   * Returns a postContact.
   * @return the postContact.
   */
  public static Object postContact() {
    if (Debug.makeSymbolicBoolean("x0")) {
      return new Object();
    }
    else {
      return new Object();
    }
  }
}