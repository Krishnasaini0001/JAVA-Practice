public class EnumDemo {
    // A simple enum: a fixed set of constants
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // An enum with fields, a constructor, and a method — enums can be this powerful
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6);

        private final double mass;   // in kilograms
        private final double radius; // in meters

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        double surfaceGravity() {
            final double G = 6.67300E-11;
            return G * mass / (radius * radius);
        }
    }

    public static void main(String[] args) {
        // ----- Using a basic enum -----
        Day today = Day.WEDNESDAY;
        System.out.println("Today is: " + today);

        if (isWeekend(today)) {
            System.out.println(today + " is a weekend day.");
        } else {
            System.out.println(today + " is a weekday.");
        }

        // ----- switch on an enum -----
        System.out.println("\n--- Switch on enum ---");
        for (Day day : Day.values()) {
            String mood = switch (day) {
                case SATURDAY, SUNDAY -> "Relaxed";
                case FRIDAY -> "Excited";
                default -> "Focused";
            };
            System.out.println(day + " -> " + mood);
        }

        // ----- Enum with fields and behavior -----
        System.out.println("\n--- Planet surface gravity ---");
        for (Planet planet : Planet.values()) {
            System.out.printf("%-8s gravity: %.2f m/s^2%n", planet, planet.surfaceGravity());
        }

        // ----- Useful enum methods -----
        System.out.println("\nDay.valueOf(\"FRIDAY\") = " + Day.valueOf("FRIDAY"));
        System.out.println("Day.FRIDAY.ordinal() = " + Day.FRIDAY.ordinal());
        System.out.println("Day.FRIDAY.name()    = " + Day.FRIDAY.name());
    }

    static boolean isWeekend(Day day) {
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }
}