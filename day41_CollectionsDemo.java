import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
        // ----- The Collections Framework hierarchy at a glance -----
        // Collection (interface)
        //   |-- List   (ordered, allows duplicates)      -> ArrayList, LinkedList
        //   |-- Set    (no duplicates)                   -> HashSet, TreeSet, LinkedHashSet
        //   |-- Queue  (FIFO/priority processing)        -> ArrayDeque, PriorityQueue
        // Map (separate interface, key-value pairs, NOT a Collection) -> HashMap, TreeMap

        System.out.println("--- List: ordered, allows duplicates ---");
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Milk"); // duplicates allowed
        System.out.println(shoppingList);

        System.out.println("\n--- Set: no duplicates ---");
        Set<String> uniqueTags = new HashSet<>();
        uniqueTags.add("java");
        uniqueTags.add("beginner");
        uniqueTags.add("java"); // ignored — already present
        System.out.println(uniqueTags);

        System.out.println("\n--- Map: key-value pairs ---");
        Map<String, Integer> ageByName = new HashMap<>();
        ageByName.put("Aarav", 28);
        ageByName.put("Priya", 24);
        System.out.println(ageByName);

        // ----- Why the framework matters: one interface, many implementations -----
        System.out.println("\n--- Programming to the interface, not the implementation ---");
        List<String> arrayBacked = new ArrayList<>();
        List<String> linkedBacked = new java.util.LinkedList<>();
        printList(arrayBacked, "apple", "banana");
        printList(linkedBacked, "cherry", "date");
    }

    // Accepts ANY List implementation — this is the core idea of the Collections Framework
    static void printList(List<String> list, String... items) {
        for (String item : items) {
            list.add(item);
        }
        System.out.println(list.getClass().getSimpleName() + ": " + list);
    }
}
