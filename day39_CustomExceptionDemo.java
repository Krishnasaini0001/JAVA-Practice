public class CustomExceptionDemo {
    public static void main(String[] args) {
        // ----- Using a custom checked exception -----
        System.out.println("--- Custom checked exception ---");
        BankAccount account = new BankAccount(500);
        try {
            account.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            System.out.println("Shortfall was: " + e.getShortfall());
        }

        // ----- Custom unchecked exception -----
        System.out.println("\n--- Custom unchecked exception ---");
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        // ----- Exception chaining: wrapping a lower-level cause -----
        System.out.println("\n--- Exception chaining ---");
        try {
            processOrder();
        } catch (OrderProcessingException e) {
            System.out.println("Order failed: " + e.getMessage());
            System.out.println("Root cause: " + e.getCause().getMessage());
        }

        // ----- try-with-resources: automatically closes resources, even on error -----
        System.out.println("\n--- try-with-resources ---");
        try (ManagedResource resource = new ManagedResource("FileHandle")) {
            resource.use();
        } // resource.close() is called automatically here, no finally block needed
        System.out.println("Resource was closed automatically.");
    }

    static void validateAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        }
    }

    static void processOrder() throws OrderProcessingException {
        try {
            int result = 10 / 0; // simulates a lower-level failure
        } catch (ArithmeticException cause) {
            throw new OrderProcessingException("Failed to process order #1234", cause);
        }
    }
}

// Custom CHECKED exception: extends Exception, callers must handle or declare it
class InsufficientFundsException extends Exception {
    private final double shortfall;

    InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    double getShortfall() {
        return shortfall;
    }
}

// Custom UNCHECKED exception: extends RuntimeException, no forced handling
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String message) {
        super(message);
    }
}

// Custom exception demonstrating chaining (wraps another exception as its "cause")
class OrderProcessingException extends Exception {
    OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException("Insufficient funds for withdrawal of " + amount, shortfall);
        }
        balance -= amount;
    }
}

// AutoCloseable enables use in try-with-resources
class ManagedResource implements AutoCloseable {
    private final String name;

    ManagedResource(String name) {
        this.name = name;
        System.out.println("Opened resource: " + name);
    }

    void use() {
        System.out.println("Using resource: " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing resource: " + name);
    }
}
