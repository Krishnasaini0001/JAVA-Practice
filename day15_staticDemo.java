public class StaticDemo {
    // Static field: shared across ALL instances of this class
    static int instanceCount = 0;

    // Instance field: each object gets its own copy
    int id;

    // Static block: runs once, when the class is first loaded
    static {
        System.out.println("Static block executed — class is being loaded.");
    }

    // Constructor: runs every time an object is created
    StaticDemo() {
        instanceCount++;
        id = instanceCount;
        System.out.println("Created instance #" + id);
    }

    public static void main(String[] args) {
        System.out.println("--- Before creating any objects ---");
        System.out.println("instanceCount = " + StaticDemo.instanceCount);

        System.out.println("\n--- Creating 3 objects ---");
        StaticDemo obj1 = new StaticDemo();
        StaticDemo obj2 = new StaticDemo();
        StaticDemo obj3 = new StaticDemo();

        System.out.println("\n--- After creating objects ---");
        System.out.println("Total instances created: " + StaticDemo.instanceCount);
        System.out.println("obj1.id = " + obj1.id + ", obj2.id = " + obj2.id + ", obj3.id = " + obj3.id);

        // ----- Static utility method example (like Math.max) -----
        System.out.println("\n--- Static utility methods ---");
        System.out.println("MathUtils.square(5) = " + MathUtils.square(5));
        System.out.println("MathUtils.cube(3)   = " + MathUtils.cube(3));

        // Static methods belong to the CLASS, not an object — no need to instantiate MathUtils
    }
}

// A utility class with only static methods — common pattern for helper classes
class MathUtils {
    static int square(int n) {
        return n * n;
    }

    static int cube(int n) {
        return n * n * n;
    }
}