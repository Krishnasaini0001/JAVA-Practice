public class RecursionBasics {
    public static void main(String[] args) {
        // ----- Factorial -----
        System.out.println("--- Factorial ---");
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + "! = " + factorial(i));
        }

        // ----- Fibonacci sequence -----
        System.out.println("\n--- Fibonacci (first 10 terms) ---");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        // ----- Tracing recursion manually -----
        System.out.println("\n--- Tracing factorial(4) step by step ---");
        System.out.println("Result: " + factorialTraced(4, 0));
    }

    // Base case: factorial(0) = 1
    // Recursive case: factorial(n) = n * factorial(n - 1)
    static long factorial(int n) {
        if (n == 0) {
            return 1; // base case stops the recursion
        }
        return n * factorial(n - 1); // recursive call with a smaller problem
    }

    // Base cases: fibonacci(0) = 0, fibonacci(1) = 1
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Same as factorial, but prints each call/return to visualize the stack
    static long factorialTraced(int n, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "-> factorialTraced(" + n + ") called");

        if (n == 0) {
            System.out.println(indent + "<- base case reached, returning 1");
            return 1;
        }

        long result = n * factorialTraced(n - 1, depth + 1);
        System.out.println(indent + "<- factorialTraced(" + n + ") returning " + result);
        return result;
    }
}