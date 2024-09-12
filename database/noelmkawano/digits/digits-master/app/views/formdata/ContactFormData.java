package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * The backing class for the Contact form.
 */
public class ContactFormData {
  /**
   * The first name.
   */
  public String firstName;
  /**
   * The last name.
   */
  public String lastName;
  /**
   * The telephone number in xxx-xxx-xxxx format.
   */
  public String telephone;
  /**
   * The address.
   */
  public String address;
  /**
   * The id.
   */
  public long id;
  /**
   * The telephone type.
   */
  public String telephoneType;

  /**
   * The public no-arg constructor required by Play.
   */
  public ContactFormData() {
    // no arg constructor.
  }

  /**
   * Constructs a ContactFormData from a contact.
   * @param contact the contact.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.address = contact.getAddress();
    this.id = contact.getId();
    this.telephoneType = contact.getTelephoneType();
  }

  /**
   * Creates test data during initialization.
   * @param firstName The first name.
   * @param lastName the last name.
   * @param telephone the telephone.
   * @param address the address.
   * @param telephoneType the telephone type.
   */
  public ContactFormData(String firstName, String lastName, String telephone, String telephoneType, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.address = address;
  }

  /**
   * Validate that all fields are non-empty and that telephone field has 12 characters.
   *
   * @return Null is no errors, list of ValidationError otherwise.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    if ((firstName == null) || (firstName.length() == 0)) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    if ((lastName == null) || (lastName.length() == 0)) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    if ((telephone == null) || (telephone.length() == 0)) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    if ((telephone != null) && (telephone.length() != 12)) {
      errors.add(new ValidationError("telephone", "Telephone must have format xxx-xxx-xxxx"));
    }
    if ((address == null) || (address.length() == 0)) {
      errors.add(new ValidationError("address", "Address is required."));
    }
    if ((address != null) && (address.length() < 24)) {
      errors.add(new ValidationError("address", "Address must be at least 24 characters long."));
    }
    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type is invalid."));
    }
    return errors.isEmpty() ? null : errors;
  }

}
