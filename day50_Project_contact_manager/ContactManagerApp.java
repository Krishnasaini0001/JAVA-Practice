import java.util.Comparator;
import java.util.List;

public class ContactManagerApp {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        manager.addContact(new Contact("Krishna Saini", "9876543210", "priya@example.com"));
        manager.addContact(new Contact("Jatin Panchal", "9123456780", "aarav@example.com"));
        manager.addContact(new Contact("Harshendra Singh Songara", "9988776655", "rohan@example.com"));
        manager.addContact(new Contact("Ajay Singh Dodiya", "9871234567", "sneha@example.com"));

        // Duplicate add attempt
        manager.addContact(new Contact("Priya Sharma", "0000000000", "duplicate@example.com"));

        System.out.println("\n--- All contacts (sorted by name) ---");
        for (Contact contact : manager.getAllSortedByName()) {
            System.out.println(contact);
        }

        System.out.println("\n--- Search: contacts containing 'ro' ---");
        List<Contact> searchResults = manager.searchByPartialName("ro");
        searchResults.forEach(System.out::println);

        System.out.println("\n--- Sorted by phone number ---");
        List<Contact> byPhone = manager.getAllSortedBy(Comparator.comparing(Contact::getPhoneNumber));
        byPhone.forEach(System.out::println);

        System.out.println("\n--- Updating a contact ---");
        Contact rohan = manager.findByName("Rohan Gupta");
        if (rohan != null) {
            rohan.setPhoneNumber("9000000000");
            System.out.println("Updated: " + rohan);
        }

        System.out.println("\n--- Removing a contact ---");
        manager.removeContact("Sneha Reddy");
        manager.removeContact("Nonexistent Person");

        System.out.println("\n--- Final contact list (" + manager.size() + " contacts) ---");
        manager.getAllSortedByName().forEach(System.out::println);
    }
}
