import java.util.Objects;

public class Contact implements Comparable<Contact> {
    private final String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    // Natural ordering: alphabetically by name
    @Override
    public int compareTo(Contact other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Contact other)) return false;
        return name.equalsIgnoreCase(other.name) && phoneNumber.equals(other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), phoneNumber);
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-15s | %s", name, phoneNumber, email);
    }
}
