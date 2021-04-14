import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {
  private BankAccount account;
  private static int count;

  @BeforeAll
  void BeforeAll() {
    System.out.println("Running before all test methods => " + count++);
  }

  @BeforeEach
  void setup() {
    System.out.println("Before Each Test method");
    account = new BankAccount("David", "Cho", 12000.00, BankAccount.CHECKING);
  }

  @Test
  void deposit() {
    System.out.println("TestDeposit => " + count++);
    double balance = account.deposit(300.00, true);
    assertEquals(12300.00, balance);
    assertEquals(12300.00, account.getBalance());
  }

  @Test
  void withdraw_branch() {
    System.out.println("Test withdraw_branch => " + count++);
    double balance = account.withdraw(600, true);
    assertEquals(11400.00, balance);
  }

  @Test
  void withdraw_notBranch() {
    System.out.println("Test withdraw_notBranch => " + count++);
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(600, false));
  }

  @Test
  void getBalance_deposit() {
    System.out.println("Test getBalance_deposit => " + count++);
    account.deposit(300.00, true);
    assertEquals(12300.00, account.getBalance());
  }

  @Test
  void getBalance_withdraw() {
    System.out.println("Test getBalance_withdraw => " + count++);
    account.withdraw(300.00, true);
    assertEquals(11700.00, account.getBalance());
  }

  @Test
  void isChecking_true() {
    System.out.println("Test isChecking_true => " + count++);
    assertTrue(account.isChecking(), "The account is NOT a checking account");
  }

  @AfterAll
  void afterAll() {
    System.out.println("afterAll => " + count++);
  }

}