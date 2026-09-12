public class EncapsulatedAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Krishna Saini", 1000.0);

        System.out.println("Owner: " + account.getOwnerName());
        System.out.println("Initial balance: " + account.getBalance());

        // ----- Interacting only through public methods, never directly touching fields -----
        account.deposit(500);
        account.withdraw(200);

        // ----- Encapsulation protects invalid state -----
        account.withdraw(999999); // should be rejected — insufficient funds
        account.deposit(-50);     // should be rejected — negative deposit

        System.out.println("Final balance: " + account.getBalance());

        // account.balance = 999999;  // <- would NOT compile: 'balance' is private
    }
}

class BankAccount {
    // Private fields: cannot be accessed directly from outside this class
    private String ownerName;
    private double balance;

    BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = (initialBalance >= 0) ? initialBalance : 0;
    }

    // Public getters expose read access in a controlled way
    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Public methods enforce business rules before modifying private state
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Withdrawal rejected: insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + ". New balance: " + balance);
    }
}