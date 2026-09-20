public class day30_BankingApp {
    public static void main(String[] args) {
        // ----- Creating customers -----
        day30_Customer aarav = new day30_Customer("C001", "Aarav Sharma", "aarav@example.com");
        day30_Customer priya = new day30_Customer("C002", "Priya Patel", "priya@example.com");

        // ----- Creating accounts for each customer -----
        day30_BankAccount aaravAccount = new day30_BankAccount(aarav, 5000);
        day30_BankAccount priyaAccount = new day30_BankAccount(priya, 2000);

        System.out.println(aarav);
        System.out.println(priya);

        // ----- Everyday operations -----
        aaravAccount.deposit(1500);
        priyaAccount.withdraw(500);

        // ----- Transfer between accounts -----
        System.out.println("\n--- Transfer ---");
        boolean success = aaravAccount.transferTo(priyaAccount, 1000);
        System.out.println("Transfer successful: " + success);

        // ----- Attempting an invalid operation -----
        System.out.println("\n--- Invalid withdrawal attempt ---");
        priyaAccount.withdraw(999999);

        // ----- Updating customer info -----
        aarav.updateEmail("aarav.sharma@newmail.com");
        System.out.println("\nUpdated customer: " + aarav);

        // ----- Final statements -----
        aaravAccount.printStatement();
        priyaAccount.printStatement();
    }
}