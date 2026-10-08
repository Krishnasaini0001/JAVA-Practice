import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomIterableDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Aarav", "Priya", "Rohan", "Sneha"));

        // ----- Using an Iterator explicitly -----
        System.out.println("--- Manual Iterator ---");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
            if (name.equals("Rohan")) {
                iterator.remove(); // safe removal DURING iteration — only way to do this correctly
            }
        }
        System.out.println("After removing 'Rohan' via iterator: " + names);

        // ----- Fail-fast behavior: modifying a list directly WHILE iterating throws an exception -----
        System.out.println("\n--- Fail-fast demonstration ---");
        try {
            for (String name : names) {
                if (name.equals("Priya")) {
                    names.remove(name); // modifying the list directly during for-each -> throws!
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Caught expected exception: " + e.getClass().getSimpleName());
            System.out.println("(This is why iterator.remove() exists — it's the safe way)");
        }

        // ----- Building a custom Iterable class -----
        System.out.println("\n--- Custom Iterable: a simple range ---");
        Range range = new Range(1, 6);
        for (int number : range) { // works because Range implements Iterable<Integer>
            System.out.print(number + " ");
        }
        System.out.println();

        // Can iterate the SAME Range object multiple times — each call to iterator() starts fresh
        int sum = 0;
        for (int number : range) {
            sum += number;
        }
        System.out.println("Sum of range: " + sum);
    }
}

// A custom collection-like class that supports the for-each loop by implementing Iterable
class Range implements Iterable<Integer> {
    private final int start;
    private final int end; // exclusive

    Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    // A private inner class implementing the actual iteration logic
    private class RangeIterator implements Iterator<Integer> {
        private int current = start;

        @Override
        public boolean hasNext() {
            return current < end;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in range");
            }
            return current++;
        }
    }
}
