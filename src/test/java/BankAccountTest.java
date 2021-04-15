import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {
  private BankAccount account;
  private static int count;

  @BeforeAll
  public void BeforeAll() {
    System.out.println("Running before all test methods => " + count++);
  }

  @BeforeEach
  public void setup() {
    System.out.println("Before Each Test method");
    account = new BankAccount("David", "Cho", 12000.00, BankAccount.CHECKING);
  }

  @Test
  public void deposit() {
    System.out.println("TestDeposit => " + count++);
    double balance = account.deposit(300.00, true);
    assertEquals(12300.00, balance);
    assertEquals(12300.00, account.getBalance());
  }

  @Test
  public void withdraw_branch() {
    System.out.println("Test withdraw_branch => " + count++);
    double balance = account.withdraw(600, true);
    assertEquals(11400.00, balance);
  }

  @Test
  public void withdraw_notBranch() {
    System.out.println("Test withdraw_notBranch => " + count++);
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(600, false));
  }

  @Test
  public void getBalance_deposit() {
    System.out.println("Test getBalance_deposit => " + count++);
    account.deposit(300.00, true);
    assertEquals(12300.00, account.getBalance());
  }

  @Test
  public void getBalance_withdraw() {
    System.out.println("Test getBalance_withdraw => " + count++);
    account.withdraw(300.00, true);
    assertEquals(11700.00, account.getBalance());
  }

  @Test
  public void isChecking_true() {
    System.out.println("Test isChecking_true => " + count++);
    assertTrue(account.isChecking(), "The account is NOT a checking account");
  }

  // parameterized test
  @ParameterizedTest
  @MethodSource("testDeposits")
  public void getBalance_deposit_parameterized(Deposit deposit) {
    System.out.println("Test getBalance_deposit_parameterized => " + count++);
    account.deposit(deposit.getAmount(), deposit.isBranch());
    assertEquals(deposit.getExpected(), account.getBalance());
  }

  @AfterAll
  public void afterAll() {
    System.out.println("afterAll => " + count++);
  }

  private static List<Deposit> testDeposits() {
    List<Deposit> depositList = new ArrayList<>();
    depositList.add(new Deposit(100.00, true, 12100.00));
    depositList.add(new Deposit(200.00, true, 12200.00));
    depositList.add(new Deposit(421.40, true, 12421.40));
    depositList.add(new Deposit(551.33, true, 12551.33));
    depositList.add(new Deposit(1000.00, true, 13000.00));

    return depositList;
  }

}