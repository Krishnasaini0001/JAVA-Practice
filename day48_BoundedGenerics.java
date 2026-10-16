import java.util.ArrayList;
import java.util.List;

public class BoundedGenerics {
    public static void main(String[] args) {
        // ----- Bounded type parameter: <T extends Number> restricts T to Number or its subclasses -----
        System.out.println("Sum of integers: " + sumOfList(List.of(1, 2, 3, 4)));
        System.out.println("Sum of doubles: " + sumOfList(List.of(1.5, 2.5, 3.0)));
        // sumOfList(List.of("a", "b")); // <- would NOT compile: String doesn't extend Number

        // ----- Upper-bounded wildcard: ? extends T -----
        // "I can READ from this list, but I don't know the exact type, so I can't safely add to it"
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.1, 2.2, 3.3);
        System.out.println("\nSum via wildcard (integers): " + sumOfWildcardList(integers));
        System.out.println("Sum via wildcard (doubles): " + sumOfWildcardList(doubles));

        // ----- Lower-bounded wildcard: ? super T -----
        // "I can WRITE Integers into this list, since it's guaranteed to accept Integer or any superclass"
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        addIntegers(numberList);
        addIntegers(objectList);
        System.out.println("\nAfter addIntegers(numberList): " + numberList);
        System.out.println("After addIntegers(objectList): " + objectList);

        // ----- Unbounded wildcard: ? -----
        // "I don't care what type this list holds, I just want to know its size"
        System.out.println("\nSize of integers list: " + printSize(integers));
        System.out.println("Size of doubles list: " + printSize(doubles));

        // ----- Type erasure: generic type info doesn't exist at runtime -----
        System.out.println("\n--- Type Erasure ---");
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        System.out.println("stringList.getClass() == intList.getClass(): "
                + (stringList.getClass() == intList.getClass())); // true! both are just "ArrayList" at runtime
    }

    // T is bounded to Number (or subtypes like Integer, Double), so .doubleValue() is guaranteed to exist
    static <T extends Number> double sumOfList(List<T> list) {
        double sum = 0;
        for (T item : list) {
            sum += item.doubleValue();
        }
        return sum;
    }

    // PECS mnemonic: "Producer Extends, Consumer Super"
    // This list only PRODUCES values for us to read, so we use "extends"
    static double sumOfWildcardList(List<? extends Number> list) {
        double sum = 0;
        for (Number item : list) {
            sum += item.doubleValue();
        }
        return sum;
    }

    // This list CONSUMES the Integers we give it, so we use "super"
    static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    static int printSize(List<?> list) {
        return list.size(); // works for a list of ANY type — we're not touching the elements
    }
}
