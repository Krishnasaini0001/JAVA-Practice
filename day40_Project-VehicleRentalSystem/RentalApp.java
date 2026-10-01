public class RentalApp {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        agency.addVehicle(new Car("MH12AB1234", "Honda City"));
        agency.addVehicle(new Motorcycle("MH12CD5678", "Royal Enfield"));
        agency.addVehicle(new SUV("MH12EF9012", "Toyota Fortuner"));

        agency.printFleetStatus();

        System.out.println("\n--- Renting vehicles ---");
        try {
            agency.rent("MH12AB1234", 3);
            agency.rent("MH12EF9012", 8); // 8 days -> triggers SUV's discount logic
        } catch (VehicleNotAvailableException e) {
            System.out.println("Rental failed: " + e.getMessage());
        }

        System.out.println("\n--- Trying to rent an already-rented vehicle ---");
        try {
            agency.rent("MH12AB1234", 2);
        } catch (VehicleNotAvailableException e) {
            System.out.println("Rental failed (expected): " + e.getMessage());
        }

        System.out.println("\n--- Trying to rent a non-existent vehicle ---");
        try {
            agency.rent("XX99ZZ0000", 1);
        } catch (VehicleNotAvailableException e) {
            System.out.println("Rental failed (expected): " + e.getMessage());
        }

        agency.printFleetStatus();

        System.out.println("\n--- Returning a vehicle ---");
        agency.returnVehicle("MH12AB1234");
        agency.printFleetStatus();

        System.out.printf("%nTotal potential daily revenue if all rented: $%.2f%n",
                agency.totalPotentialDailyRevenue());
    }
}
