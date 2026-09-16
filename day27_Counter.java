public class Counter {
    // Static field: ONE copy shared by every Counter object
    private static int totalCountersCreated = 0;

    // Instance field: each Counter object has its OWN copy
    private int currentValue;
    private final int counterId;

    Counter() {
        totalCountersCreated++;           // modifies the shared static field
        this.counterId = totalCountersCreated; // captures a per-instance snapshot
        this.currentValue = 0;
    }

    // Instance method: needs an object to call it on (uses instance state)
    void increment() {
        currentValue++;
    }

    void reset() {
        currentValue = 0;
    }

    int getValue() {
        return currentValue;
    }

    // Static method: called on the CLASS itself, cannot access instance fields directly
    static int getTotalCountersCreated() {
        return totalCountersCreated;
        // return currentValue; // <- would NOT compile: no instance context in a static method
    }

    public static void main(String[] args) {
        System.out.println("Total counters before creating any: " + Counter.getTotalCountersCreated());

        Counter counterA = new Counter();
        Counter counterB = new Counter();
        Counter counterC = new Counter();

        counterA.increment();
        counterA.increment();
        counterA.increment();

        counterB.increment();

        System.out.println("\n--- Instance state is independent ---");
        System.out.println("counterA value: " + counterA.getValue() + " (id=" + counterA.counterId + ")");
        System.out.println("counterB value: " + counterB.getValue() + " (id=" + counterB.counterId + ")");
        System.out.println("counterC value: " + counterC.getValue() + " (id=" + counterC.counterId + ")");

        System.out.println("\n--- Static state is shared ---");
        System.out.println("Total counters created: " + Counter.getTotalCountersCreated());

        counterA.reset();
        System.out.println("\nAfter resetting counterA: " + counterA.getValue());
        System.out.println("counterB unaffected: " + counterB.getValue());
    }
}