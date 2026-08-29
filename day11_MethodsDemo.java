public class day11_MethodsDemo {
    public static void main(String[] args) {
        // ----- Calling methods with different signatures -----
        System.out.println("Sum of 3 + 4 = " + add(3, 4));
        System.out.println("Sum of 3.5 + 4.5 = " + add(3.5, 4.5));
        System.out.println("Sum of 1 + 2 + 3 = " + add(1, 2, 3));

        // ----- Method returning a boolean -----
        System.out.println("\nIs 17 prime? " + isPrime(17));
        System.out.println("Is 20 prime? " + isPrime(20));

        // ----- Method with no return value (void) -----
        printSeparator();
        printGreeting("Java Learner");
        printSeparator();

        // ----- Method returning a String -----
        String category = categorizeAge(25);
        System.out.println("Category for age 25: " + category);
    }

    // Method overloading: same name "add", different parameter lists
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    static void printSeparator() {
        System.out.println("----------------------");
    }

    static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    static String categorizeAge(int age) {
        if (age < 13) return "Child";
        if (age < 20) return "Teenager";
        if (age < 60) return "Adult";
        return "Senior";
    }
}