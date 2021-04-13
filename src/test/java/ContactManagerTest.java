import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContactManagerTest {
  private static ContactManager contactManager = new ContactManager();

  @BeforeAll
  static void addDummyContacts() {
    log.info("@BeforeAll - add dummy contacts for test");
    contactManager.getContactList().add(new Contact("David", "+491724492243", "09130", "Sebastian-Bach Str.26"));
    contactManager.getContactList().add(new Contact("Jiyeon", "+491775420064", "09126", "Bernsdorfer Str.102"));
    contactManager.getContactList().add(new Contact("Noah", "+821089751291", "12457", "Dongil Heights Villa 3a"));
    contactManager.getContactList().add(new Contact("Yoomin", "+9214009212", "00125", "Newton Street 52"));
  }

  @Test
  @DisplayName("Check count of the contact list")
  void checkContactCount() {
    Assertions.assertEquals(4, contactManager.getContactList().size());
  }

  @Test
  @DisplayName("Check person's contact information")
  void getSingleContact() {
    Assertions.assertEquals("Sebastian-Bach Str.26", contactManager.findContactByName("David").getAddress());
    Assertions.assertEquals("Bernsdorfer Str.102", contactManager.findContactByName("Jiyeon").getAddress());
    Assertions.assertTrue("Newton Street 52".equals(contactManager.findContactByName("Yoomin").getAddress()));
    Assertions.assertEquals("Newton Street 52", contactManager.findContactByName("Yoomin").getAddress());
    Assertions.assertEquals("Dongil Heights Villa 3a", contactManager.findContactByName("Noah").getAddress());
  }

  @AfterAll
  static void done() {
    log.info("@AfterAll - executed after all test methods");
  }

}