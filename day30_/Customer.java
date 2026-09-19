public class Customer {
    private final String customerId;
    private String name;
    private String email;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String newEmail) {
        if (newEmail != null && newEmail.contains("@")) {
            this.email = newEmail;
        } else {
            System.out.println("Invalid email, update rejected.");
        }
    }

    @Override
    public String toString() {
        return "Customer{" + customerId + ", " + name + ", " + email + "}";
    }
}