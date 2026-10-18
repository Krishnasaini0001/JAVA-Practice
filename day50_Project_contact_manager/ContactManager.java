import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactManager {
    // Map for O(1) lookup by name, List for ordered iteration/sorting flexibility
    private final Map<String, Contact> contactsByName = new HashMap<>();

    public boolean addContact(Contact contact) {
        String key = contact.getName().toLowerCase();
        if (contactsByName.containsKey(key)) {
            System.out.println("Contact '" + contact.getName() + "' already exists.");
            return false;
        }
        contactsByName.put(key, contact);
        System.out.println("Added: " + contact.getName());
        return true;
    }

    public Contact findByName(String name) {
        return contactsByName.get(name.toLowerCase());
    }

    public boolean removeContact(String name) {
        Contact removed = contactsByName.remove(name.toLowerCase());
        if (removed != null) {
            System.out.println("Removed: " + name);
            return true;
        }
        System.out.println("Contact not found: " + name);
        return false;
    }

    public List<Contact> searchByPartialName(String query) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contactsByName.values()) {
            if (contact.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    public List<Contact> getAllSortedByName() {
        List<Contact> all = new ArrayList<>(contactsByName.values());
        Collections.sort(all); // uses Contact's Comparable implementation
        return all;
    }

    public List<Contact> getAllSortedBy(Comparator<Contact> comparator) {
        List<Contact> all = new ArrayList<>(contactsByName.values());
        all.sort(comparator);
        return all;
    }

    public int size() {
        return contactsByName.size();
    }
}
