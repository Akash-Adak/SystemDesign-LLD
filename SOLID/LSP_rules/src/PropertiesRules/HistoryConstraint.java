package PropertiesRules;// Subclass methods should not be allowed state changes that
// the base class never allowed.

class BankAccount1 {
    protected double balance;

    public BankAccount1(double b) {
        if (b < 0) throw new IllegalArgumentException("Balance can't be negative");
        this.balance = b;
    }

    // History Constraint: withdraw should be allowed
    public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

class FixedDepositAccount extends BankAccount1 {
    public FixedDepositAccount(double b) {
        super(b);
    }

    // LSP break! History constraint broken!
    // Parent class behavior changed: Now withdraw is not allowed.
    // This class will break client code that relies on withdraw.
    @Override
    public void withdraw(double amount) {
        throw new RuntimeException("Withdraw not allowed in Fixed Deposit");
    }
}

public class HistoryConstraint {
    public static void main(String[] args) {
        BankAccount1 bankAccount = new BankAccount1(100);
        bankAccount.withdraw(100);
    }
}
