import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    public static void main(String[] args) {
        // ----- ArrayList: backed by a resizable array -----
        // Fast random access (get(i) is O(1)), slower inserts/removes in the middle (O(n))
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Fast get(1): " + arrayList.get(1)); // O(1)

        // ----- LinkedList: backed by a doubly-linked list -----
        // Fast insert/remove at both ends (O(1)), slower random access (O(n))
        List<String> linkedList = new LinkedList<>();
        linkedList.add("X");
        linkedList.add("Y");
        linkedList.add("Z");
        System.out.println("\nLinkedList: " + linkedList);

        LinkedList<String> castedLinkedList = (LinkedList<String>) linkedList;
        castedLinkedList.addFirst("START"); // O(1) — LinkedList excels here
        castedLinkedList.addLast("END");
        System.out.println("After addFirst/addLast: " + linkedList);

        // ----- Performance comparison: inserting 50,000 elements at the FRONT -----
        System.out.println("\n--- Performance: inserting 50,000 elements at index 0 ---");
        int n = 50_000;

        long start = System.nanoTime();
        List<Integer> perfArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            perfArrayList.add(0, i); // O(n) each time -> O(n^2) total, shifts everything right
        }
        long arrayListTime = System.nanoTime() - start;

        start = System.nanoTime();
        List<Integer> perfLinkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            perfLinkedList.add(0, i); // O(1) each time -> O(n) total, just relinks pointers
        }
        long linkedListTime = System.nanoTime() - start;

        System.out.println("ArrayList time:  " + (arrayListTime / 1_000_000) + " ms");
        System.out.println("LinkedList time: " + (linkedListTime / 1_000_000) + " ms");
        System.out.println("(LinkedList wins for front-insertion; ArrayList wins for random access)");

        // ----- Rule of thumb -----
        System.out.println("\n--- When to use which ---");
        System.out.println("ArrayList:  default choice; frequent reads/iteration, rare middle inserts");
        System.out.println("LinkedList: frequent insertions/removals at the ends (e.g., queue/deque use cases)");
    }
}
