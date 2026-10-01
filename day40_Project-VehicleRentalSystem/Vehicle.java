public abstract class Vehicle {
    private final String licensePlate;
    private final String model;
    private boolean rented;

    Vehicle(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rented = false;
    }

    String getLicensePlate() {
        return licensePlate;
    }

    String getModel() {
        return model;
    }

    boolean isRented() {
        return rented;
    }

    void markRented() {
        rented = true;
    }

    void markReturned() {
        rented = false;
    }

    // Every vehicle type calculates its own daily rate differently
    abstract double dailyRate();

    double calculateCost(int days) {
        return dailyRate() * days;
    }

    @Override
    public String toString() {
        return model + " (" + licensePlate + ") - " + (rented ? "Rented" : "Available");
    }
}

class Car extends Vehicle {
    Car(String licensePlate, String model) {
        super(licensePlate, model);
    }

    @Override
    double dailyRate() {
        return 40.0;
    }
}

class Motorcycle extends Vehicle {
    Motorcycle(String licensePlate, String model) {
        super(licensePlate, model);
    }

    @Override
    double dailyRate() {
        return 20.0;
    }
}

class SUV extends Vehicle {
    SUV(String licensePlate, String model) {
        super(licensePlate, model);
    }

    @Override
    double dailyRate() {
        return 65.0;
    }

    @Override
    double calculateCost(int days) {
        double base = super.calculateCost(days); // reuse parent logic
        return (days >= 7) ? base * 0.9 : base;   // 10% discount for week-long+ rentals
    }
}
