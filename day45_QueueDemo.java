import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueDemo {
    public static void main(String[] args) {
        // ----- Queue: FIFO (First In, First Out) -----
        Queue<String> printQueue = new ArrayDeque<>();
        printQueue.offer("Document1.pdf"); // preferred over add() — returns false instead of throwing on failure
        printQueue.offer("Document2.pdf");
        printQueue.offer("Document3.pdf");
        System.out.println("Queue: " + printQueue);

        System.out.println("Processing print jobs:");
        while (!printQueue.isEmpty()) {
            System.out.println("  Printing: " + printQueue.poll()); // removes and returns the FRONT
        }

        // ----- Stack (via Deque, the modern recommended approach): LIFO (Last In, First Out) -----
        Deque<String> browserHistory = new ArrayDeque<>();
        browserHistory.push("google.com");
        browserHistory.push("stackoverflow.com");
        browserHistory.push("github.com");
        System.out.println("\nBrowser history (top = most recent): " + browserHistory);

        System.out.println("Going back:");
        while (!browserHistory.isEmpty()) {
            System.out.println("  Back to: " + browserHistory.pop()); // removes and returns the TOP
        }

        // ----- The legacy Stack class (still works, but ArrayDeque is preferred today) -----
        Stack<Integer> legacyStack = new Stack<>();
        legacyStack.push(1);
        legacyStack.push(2);
        legacyStack.push(3);
        System.out.println("\nLegacy Stack: " + legacyStack + ", peek: " + legacyStack.peek());

        // ----- Deque as a double-ended queue: add/remove from BOTH ends -----
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);
        deque.addLast(4);
        System.out.println("\nDeque (both ends used): " + deque);

        // ----- PriorityQueue: elements come out in priority order, not insertion order -----
        System.out.println("\n--- PriorityQueue: always removes the smallest first ---");
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(50);
        priorityQueue.offer(10);
        priorityQueue.offer(30);
        priorityQueue.offer(20);
        System.out.println("Underlying storage (not sorted visually): " + priorityQueue);
        System.out.print("Polling order: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();

        // ----- PriorityQueue with a custom comparator (max-heap instead of min-heap) -----
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(java.util.List.of(50, 10, 30, 20));
        System.out.print("Max-heap polling order: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }
}
