import java.util.List;

public class PointRecord {
    // A record: a concise, immutable data carrier.
    // The compiler auto-generates: constructor, getters (x(), y()), equals(), hashCode(), toString()
    record Point(int x, int y) {
        // Records can still have extra methods
        double distanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }
    }

    // A record with validation logic in a "compact constructor"
    record Range(int min, int max) {
        Range { // compact constructor: no parameter list repeated, runs before field assignment
            if (min > max) {
                throw new IllegalArgumentException("min cannot be greater than max");
            }
        }

        boolean contains(int value) {
            return value >= min && value <= max;
        }
    }

    public static void main(String[] args) {
        // ----- Basic record usage -----
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(10, 10);

        System.out.println("--- Records give you a lot for free ---");
        System.out.println("p1 = " + p1);               // auto-generated toString()
        System.out.println("p1.x() = " + p1.x());       // auto-generated accessor
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // value-based equals()
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));

        System.out.println("\nDistance from origin: " + p1.distanceFromOrigin());

        // ----- Record with validation -----
        System.out.println("\n--- Record with compact constructor validation ---");
        Range validRange = new Range(1, 10);
        System.out.println("Range " + validRange + " contains 5? " + validRange.contains(5));
        System.out.println("Range " + validRange + " contains 15? " + validRange.contains(15));

        try {
            Range invalidRange = new Range(10, 1); // min > max -> should throw
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        // ----- Records work great as simple data-transfer objects in a list -----
        List<Point> points = List.of(new Point(0, 0), new Point(1, 1), new Point(-2, 3));
        System.out.println("\nAll points: " + points);
    }
}