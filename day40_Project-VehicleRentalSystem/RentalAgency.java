import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private final List<Vehicle> fleet = new ArrayList<>();

    void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    Vehicle rent(String licensePlate, int days) throws VehicleNotAvailableException {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                if (vehicle.isRented()) {
                    throw new VehicleNotAvailableException(vehicle.getModel() + " is already rented.");
                }
                vehicle.markRented();
                double cost = vehicle.calculateCost(days);
                System.out.printf("Rented %s for %d day(s). Total cost: $%.2f%n", vehicle.getModel(), days, cost);
                return vehicle;
            }
        }
        throw new VehicleNotAvailableException("No vehicle found with plate: " + licensePlate);
    }

    void returnVehicle(String licensePlate) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                vehicle.markReturned();
                System.out.println("Returned: " + vehicle.getModel());
                return;
            }
        }
        System.out.println("No vehicle found with plate: " + licensePlate);
    }

    void printFleetStatus() {
        System.out.println("\n--- Fleet Status ---");
        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle); // uses Vehicle's toString() polymorphically
        }
    }

    double totalPotentialDailyRevenue() {
        double total = 0;
        for (Vehicle vehicle : fleet) {
            total += vehicle.dailyRate(); // polymorphic call — each subclass answers differently
        }
        return total;
    }
}
