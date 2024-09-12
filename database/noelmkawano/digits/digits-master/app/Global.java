import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Initialize system with four contacts.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ContactDB.addContact(new ContactFormData("Noel", "Kawano", "808-111-1111",
        "Mobile", "11-1111 Ala Moana Boulevard"));
    ContactDB.addContact(new ContactFormData("Noel", "Kawano", "808-111-1111",
        "Mobile", "11-1111 Ala Moana Boulevard"));
    ContactDB.addContact(new ContactFormData("Noel", "Kawano", "808-111-1111",
        "Mobile", "11-1111 Ala Moana Boulevard"));
    ContactDB.addContact(new ContactFormData("Noel", "Kawano", "808-111-1111",
        "Mobile", "11-1111 Ala Moana Boulevard"));
  }
}
