import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // ----- HashSet: no duplicates, NO guaranteed order -----
        Set<String> hashSet = new HashSet<>();
        hashSet.add("banana");
        hashSet.add("apple");
        hashSet.add("cherry");
        hashSet.add("apple"); // ignored, already present
        System.out.println("HashSet (order not guaranteed): " + hashSet);

        // ----- LinkedHashSet: no duplicates, preserves INSERTION order -----
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("banana");
        linkedHashSet.add("apple");
        linkedHashSet.add("cherry");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        // ----- TreeSet: no duplicates, always SORTED (natural ordering) -----
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("cherry");
        System.out.println("TreeSet (sorted order): " + treeSet);

        // ----- Set operations: union, intersection, difference -----
        Set<Integer> setA = new HashSet<>(java.util.List.of(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(java.util.List.of(4, 5, 6, 7, 8));

        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("\nUnion: " + union);

        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection: " + intersection);

        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);

        // ----- Practical use: removing duplicates from a list -----
        System.out.println("\n--- Removing duplicates from a List using a Set ---");
        java.util.List<Integer> withDuplicates = java.util.List.of(1, 2, 2, 3, 3, 3, 4);
        Set<Integer> deduplicated = new LinkedHashSet<>(withDuplicates); // preserves first-seen order
        System.out.println("Original: " + withDuplicates);
        System.out.println("Deduplicated: " + deduplicated);

        // ----- TreeSet extra features: sorted navigation -----
        TreeSet<Integer> scores = new TreeSet<>(java.util.List.of(55, 89, 42, 91, 67));
        System.out.println("\n--- TreeSet navigation ---");
        System.out.println("Scores sorted: " + scores);
        System.out.println("Lowest score: " + scores.first());
        System.out.println("Highest score: " + scores.last());
        System.out.println("Smallest score >= 60: " + scores.ceiling(60));
        System.out.println("Largest score < 60: " + scores.lower(60));
    }
}
