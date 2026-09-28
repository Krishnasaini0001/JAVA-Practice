public class day36_DefaultMethodsDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bicycle();

        // ----- Default methods: provide shared behavior without forcing every class to implement it -----
        System.out.println("--- Default methods (inherited automatically) ---");
        car.honk();   // Car doesn't define honk() -> uses the interface's default
        bike.honk();  // Bicycle overrides the default with its own version

        // ----- Static methods on an interface: called on the interface itself, like a utility -----
        System.out.println("\n--- Static interface method ---");
        Vehicle.printVehicleGuidelines();

        // ----- Combining abstract + default methods -----
        System.out.println("\n--- Abstract methods still required ---");
        car.startEngine();
        bike.startEngine();
    }
}

interface Vehicle {
    void startEngine(); // still abstract — every implementer MUST define this

    // Default method: has a body, so implementers can use it as-is or override it
    default void honk() {
        System.out.println("Beep beep! (default vehicle horn)");
    }

    // Static method: belongs to the interface itself, not to any implementing object
    static void printVehicleGuidelines() {
        System.out.println("All vehicles must be operated safely and maintained regularly.");
    }
}

class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started with a turn of the key.");
    }
    // honk() not overridden -> uses Vehicle's default implementation
}

class Bicycle implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bicycles don't have engines — just start pedaling!");
    }

    @Override
    public void honk() {
        System.out.println("Ring ring! (bicycle bell, overriding the default)");
    }
}
