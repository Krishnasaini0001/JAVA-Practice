public class Box<T> { // T is a type parameter — a placeholder for whatever type is used later
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public static void main(String[] args) {
        // ----- A generic class works with ANY type, decided at usage time -----
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("String box: " + stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("Integer box: " + intBox.get());

        // Without generics, you'd need Object and constant casting — generics catch type errors at COMPILE time
        // Box wrongTypeBox = new Box(); wrongTypeBox.set("text"); Integer x = (Integer) wrongTypeBox.get(); // runtime crash!

        // ----- A generic class with two type parameters -----
        Pair<String, Integer> nameAge = new Pair<>("Aarav", 28);
        System.out.println("\nPair: " + nameAge.getFirst() + " is " + nameAge.getSecond() + " years old");

        Pair<Integer, Integer> coordinate = new Pair<>(3, 4);
        System.out.println("Coordinate: (" + coordinate.getFirst() + ", " + coordinate.getSecond() + ")");

        // ----- A generic method (independent of any generic class) -----
        Integer[] numbers = {5, 2, 8, 1, 9};
        String[] words = {"banana", "apple", "cherry"};

        System.out.println("\nMax of numbers: " + findMax(numbers));
        System.out.println("Max of words (alphabetically): " + findMax(words));

        // ----- Generic method for swapping array elements -----
        swap(numbers, 0, 4);
        System.out.println("After swap: " + java.util.Arrays.toString(numbers));
    }

    // Generic method: <T> before the return type declares the type parameter for THIS method only
    static <T extends Comparable<T>> T findMax(T[] items) {
        T max = items[0];
        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

// A generic class with two independent type parameters, K and V
class Pair<K, V> {
    private K first;
    private V second;

    Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    K getFirst() {
        return first;
    }

    V getSecond() {
        return second;
    }
}
