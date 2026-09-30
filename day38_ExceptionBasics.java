import java.util.InputMismatchException;

public class day38_ExceptionBasics {
    public static void main(String[] args) {
        // ----- Basic try/catch -----
        System.out.println("--- try/catch: ArithmeticException ---");
        try {
            int result = 10 / 0;
            System.out.println("This line never runs: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // ----- Catching multiple exception types -----
        System.out.println("\n--- Multiple catch blocks ---");
        int[] numbers = {1, 2, 3};
        int[] indexesToTry = {1, 10, -1};
        for (int index : indexesToTry) {
            try {
                System.out.println("numbers[" + index + "] = " + numbers[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + index + " is out of bounds: " + e.getMessage());
            }
        }

        // ----- finally: always runs, whether an exception occurred or not -----
        System.out.println("\n--- finally block ---");
        try {
            System.out.println("Trying risky operation...");
            String text = null;
            System.out.println(text.length()); // will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } finally {
            System.out.println("finally: this always executes (cleanup code goes here)");
        }

        // ----- Multi-catch with the pipe operator -----
        System.out.println("\n--- Multi-catch (| operator) ---");
        for (String input : new String[]{"42", "abc"}) {
            try {
                int parsed = Integer.parseInt(input);
                System.out.println("Parsed: " + parsed);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Could not parse '" + input + "': " + e.getClass().getSimpleName());
            }
        }

        // ----- Checked vs unchecked exceptions -----
        System.out.println("\n--- Checked exception (must be declared or caught) ---");
        try {
            riskyMethodThatThrowsChecked();
        } catch (Exception e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        System.out.println("\nProgram continued normally after handling all exceptions.");
    }

    // Checked exception: the compiler FORCES callers to handle or declare it (extends Exception, not RuntimeException)
    static void riskyMethodThatThrowsChecked() throws Exception {
        throw new Exception("Something went wrong (checked exception)");
    }
}
