import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class day44_MapDemo {
    public static void main(String[] args) {
        // ----- HashMap: key-value pairs, NO guaranteed order -----
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 3);
        hashMap.put("banana", 5);
        hashMap.put("cherry", 8);
        hashMap.put("apple", 10); // overwrites the previous value for "apple"
        System.out.println("HashMap: " + hashMap);

        // ----- LinkedHashMap: preserves insertion order -----
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("z-item", 1);
        linkedHashMap.put("a-item", 2);
        linkedHashMap.put("m-item", 3);
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        // ----- TreeMap: always sorted by key -----
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("z-item", 1);
        treeMap.put("a-item", 2);
        treeMap.put("m-item", 3);
        System.out.println("TreeMap (sorted by key): " + treeMap);

        // ----- Common Map operations -----
        System.out.println("\n--- Common operations ---");
        System.out.println("Contains key 'banana': " + hashMap.containsKey("banana"));
        System.out.println("Contains value 8: " + hashMap.containsValue(8));
        System.out.println("Get 'cherry': " + hashMap.get("cherry"));
        System.out.println("Get missing key with default: " + hashMap.getOrDefault("grape", 0));

        // getOrDefault avoids null checks and NullPointerExceptions
        hashMap.putIfAbsent("grape", 7); // only inserts if the key isn't already present
        hashMap.putIfAbsent("apple", 999); // ignored — "apple" already exists
        System.out.println("After putIfAbsent: " + hashMap);

        // merge(): great for counting/accumulating
        hashMap.merge("apple", 5, Integer::sum); // adds 5 to apple's existing value
        System.out.println("After merge (apple += 5): " + hashMap);

        // ----- Iterating a Map -----
        System.out.println("\n--- Iterating entries ---");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ----- Practical use: word frequency counter -----
        System.out.println("\n--- Word Frequency Counter ---");
        String sentence = "the cat sat on the mat the cat ran";
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : sentence.split(" ")) {
            frequency.merge(word, 1, Integer::sum);
        }
        System.out.println(frequency);

        // ----- Removing entries -----
        hashMap.remove("grape");
        System.out.println("\nAfter removing 'grape': " + hashMap);
    }
}
