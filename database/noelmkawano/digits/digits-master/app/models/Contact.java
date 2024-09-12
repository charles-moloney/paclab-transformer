package models;

/**
 * Mockup model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private String address;
  private long id;
  private String telephoneType;

  /**
   * Creates a contact instance.
   *
   * @param id            the id.
   * @param firstName     The first name.
   * @param lastName      The last name.
   * @param telephone     The telephone.
   * @param address       The address.
   * @param telephoneType The telephone type.
   */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType, String address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.address = address;
  }

  /**
   * Returns first name.
   *
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name.
   *
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns the telephone number.
   *
   * @return the telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Returns the address.
   *
   * @return the address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Returns the Id.
   *
   * @return the Id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns telephone type.
   * @return the telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }
}