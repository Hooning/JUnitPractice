public class Deposit {
  private double amount;
  private boolean branch;
  private double expected;

  public Deposit(double amount, boolean branch, double expected) {
    this.amount = amount;
    this.branch = branch;
    this.expected = expected;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public boolean isBranch() {
    return branch;
  }

  public void setBranch(boolean branch) {
    this.branch = branch;
  }

  public double getExpected() {
    return expected;
  }

  public void setExpected(double expected) {
    this.expected = expected;
  }
}
