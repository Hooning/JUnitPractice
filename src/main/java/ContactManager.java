import java.util.ArrayList;
import java.util.List;

public class ContactManager {
  private List<Contact> contactList = new ArrayList<>();

  private List<Contact> retriveAllContacts() {
    return this.contactList;
  }

  public Contact findContactByName(String name) {
    return this.contactList.stream()
            .filter((personContact) -> name.equals(personContact.getName()))
            .findAny()
            .orElse(null);
  }

  private void addNewContact(Contact contact) {
    this.contactList.add(contact);
  }

  private void removeExistingContact(Contact contact) throws Exception {
    Contact givenContact = this.contactList.stream()
            .filter((personContact) -> personContact.equals(contact))
            .findAny()
            .orElse(null);

    if (givenContact == null){
      throw new Exception("given contact does not exist in the contact list");
    }

  }

  public List<Contact> getContactList() {
    return contactList;
  }

  public void setContactList(List<Contact> contactList) {
    this.contactList = contactList;
  }
}
