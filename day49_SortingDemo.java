import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class day49_SortingDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Priya", 22, 8.7),
            new Student("Aarav", 25, 9.1),
            new Student("Rohan", 20, 7.5),
            new Student("Sneha", 23, 9.1)
        ));

        System.out.println("--- Original order ---");
        students.forEach(System.out::println);

        // ----- Comparable: defines the class's NATURAL ordering (one fixed way to sort) -----
        Collections.sort(students); // uses Student's compareTo() method
        System.out.println("\n--- Sorted by natural order (name, via Comparable) ---");
        students.forEach(System.out::println);

        // ----- Comparator: defines an ALTERNATIVE ordering, without changing the class itself -----
        Comparator<Student> byGpaDescending = (a, b) -> Double.compare(b.getGpa(), a.getGpa());
        students.sort(byGpaDescending);
        System.out.println("\n--- Sorted by GPA descending (via Comparator lambda) ---");
        students.forEach(System.out::println);

        // ----- Comparator built with helper methods: cleaner and chainable -----
        Comparator<Student> byAgeThenName = Comparator
                .comparingInt(Student::getAge)
                .thenComparing(Student::getName);
        students.sort(byAgeThenName);
        System.out.println("\n--- Sorted by age, then name (chained Comparator) ---");
        students.forEach(System.out::println);

        // ----- Reversing an order -----
        students.sort(Comparator.comparing(Student::getName).reversed());
        System.out.println("\n--- Sorted by name, reversed ---");
        students.forEach(System.out::println);
    }
}

// implements Comparable<Student> to define the class's natural ordering
class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double gpa;

    Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    String getName() { return name; }
    int getAge() { return age; }
    double getGpa() { return gpa; }

    // Natural ordering: alphabetically by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (age " + age + ", GPA " + gpa + ")";
    }
}
