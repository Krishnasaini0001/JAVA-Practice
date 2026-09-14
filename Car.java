public class Car {
    // Composition: a Car "has-a" Engine — the Engine's lifecycle is tied to the Car's
    private Engine engine;
    private String model;
    private GPS gps; // a Car also "has-a" GPS

    Car(String model, int horsepower) {
        this.model = model;
        this.engine = new Engine(horsepower); // Car creates and owns its Engine
        this.gps = new GPS();
    }

    void start() {
        System.out.println("Starting " + model + "...");
        engine.turnOn(); // delegate to the composed object
    }

    void stop() {
        engine.turnOff();
        System.out.println(model + " has stopped.\n");
    }

    void navigateTo(String destination) {
        gps.setDestination(destination); // delegate to another composed object
    }

    public static void main(String[] args) {
        Car car = new Car("Tesla Model 3", 480);
        car.start();
        car.navigateTo("Indore, Madhya Pradesh");
        car.stop();

        // ----- Composition with a collection of composed objects -----
        System.out.println("--- A car made of multiple parts ---");
        Car secondCar = new Car("Honda Civic", 158);
        secondCar.start();
        secondCar.navigateTo("Mumbai");
        secondCar.stop();
    }
}

// Engine only exists as part of a Car — this is composition (strong ownership)
class Engine {
    private int horsepower;
    private boolean isRunning = false;

    Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    void turnOn() {
        isRunning = true;
        System.out.println("Engine (" + horsepower + " hp) is now running.");
    }

    void turnOff() {
        isRunning = false;
        System.out.println("Engine has been turned off.");
    }
}

class GPS {
    private String destination;

    void setDestination(String destination) {
        this.destination = destination;
        System.out.println("GPS set destination to: " + destination);
    }
}