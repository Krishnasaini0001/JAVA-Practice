import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Overriding toString() — controls what gets printed for this object
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    // Overriding equals() — defines what "equal" means for two Points (value equality, not reference)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;               // same reference -> trivially equal
        if (obj == null || getClass() != obj.getClass()) return false; // different type -> not equal
        Point other = (Point) obj;
        return x == other.x && y == other.y;         // equal if coordinates match
    }

    // Overriding hashCode() — MUST be consistent with equals(): equal objects need equal hash codes
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);

        // ----- toString() in action -----
        System.out.println("p1 = " + p1); // uses toString() automatically
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);

        // ----- Reference vs value equality -----
        System.out.println("\n--- Equality ---");
        System.out.println("p1 == p2 (reference compare): " + (p1 == p2));       // false: different objects
        System.out.println("p1.equals(p2) (value compare): " + p1.equals(p2));   // true: same coordinates
        System.out.println("p1.equals(p3): " + p1.equals(p3));                   // false: different coordinates

        // ----- Why this matters: HashSet relies on equals() + hashCode() -----
        System.out.println("\n--- HashSet behavior ---");
        Set<Point> points = new HashSet<>();
        points.add(p1);
        points.add(p2); // won't actually add a new entry — p1 and p2 are "equal"
        points.add(p3);
        System.out.println("Set size (expected 2, not 3): " + points.size());
        System.out.println("Set contents: " + points);

        System.out.println("\np1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
    }
}