public class day17_VarargsDemo {
    public static void main(String[] args) {
        // ----- Varargs: accept any number of arguments -----
        System.out.println("sum() = " + sum());
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));

        // ----- Passing an existing array to a varargs method -----
        int[] values = {10, 20, 30};
        System.out.println("sum(values array) = " + sum(values));

        // ----- Varargs mixed with a regular parameter -----
        printWithPrefix("Fruits:", "Apple", "Banana", "Cherry");
        printWithPrefix("Empty list:");

        // ----- Good method design: single responsibility -----
        double[] prices = {19.99, 45.50, 3.25};
        double total = calculateTotal(prices);
        double discounted = applyDiscount(total, 0.1);
        System.out.println("\nTotal: " + total);
        System.out.println("After 10% discount: " + String.format("%.2f", discounted));
    }

    // A varargs parameter must be the LAST parameter in the method signature
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    static void printWithPrefix(String prefix, String... items) {
        System.out.print(prefix + " ");
        if (items.length == 0) {
            System.out.println("(none)");
            return;
        }
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Good design: each method does ONE thing, making code easy to test and reuse
    static double calculateTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    static double applyDiscount(double amount, double discountRate) {
        return amount * (1 - discountRate);
    }
}