import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static int nextAccountNumber = 1001; // shared across all accounts

    private final int accountNumber;
    private final Customer owner;      // composition: an account "has-a" Customer
    private double balance;
    private final List<String> transactionHistory = new ArrayList<>();

    public BankAccount(Customer owner, double initialDeposit) {
        this.accountNumber = nextAccountNumber++;
        this.owner = owner;
        this.balance = 0;
        if (initialDeposit > 0) {
            deposit(initialDeposit);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit failed: amount must be positive.");
            return;
        }
        balance += amount;
        log("Deposited " + amount + " -> balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Withdrawal failed: insufficient funds.");
            return false;
        }
        balance -= amount;
        log("Withdrew " + amount + " -> balance: " + balance);
        return true;
    }

    // Transfer money between two accounts — demonstrates objects collaborating
    public boolean transferTo(BankAccount recipient, double amount) {
        if (this.withdraw(amount)) {
            recipient.deposit(amount);
            log("Transferred " + amount + " to account #" + recipient.getAccountNumber());
            return true;
        }
        return false;
    }

    private void log(String entry) {
        transactionHistory.add(entry);
    }

    public void printStatement() {
        System.out.println("\n--- Statement for account #" + accountNumber + " (" + owner.getName() + ") ---");
        for (String entry : transactionHistory) {
            System.out.println("  " + entry);
        }
        System.out.println("  Current balance: " + balance);
    }
}