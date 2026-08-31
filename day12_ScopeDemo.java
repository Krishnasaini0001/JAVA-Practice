public class day12_ScopeDemo {
    // Instance-level field would need an object; here we use a static field for simplicity
    static int globalCounter = 0;

    public static void main(String[] args) {
        int localVariable = 10; // scoped to main() only
        System.out.println("localVariable in main: " + localVariable);

        modifyValue(localVariable);
        System.out.println("localVariable in main AFTER call: " + localVariable); // unchanged! (pass-by-value)

        // ----- Block scope -----
        {
            int blockScoped = 99;
            System.out.println("\nInside block: blockScoped = " + blockScoped);
        }
        // System.out.println(blockScoped); // would NOT compile here — out of scope

        // ----- Demonstrating the call stack with nested method calls -----
        System.out.println("\n--- Call stack trace ---");
        levelOne();

        // ----- Static field shared across calls -----
        System.out.println("\n--- Static field persists across calls ---");
        incrementGlobalCounter();
        incrementGlobalCounter();
        incrementGlobalCounter();
        System.out.println("Final globalCounter: " + globalCounter);
    }

    // Pass-by-value: Java copies the primitive's value into the parameter
    static void modifyValue(int value) {
        value = 500; // only changes the local copy inside this method
        System.out.println("Inside modifyValue: value set to " + value);
    }

    static void levelOne() {
        System.out.println("Entered levelOne()");
        levelTwo();
        System.out.println("Exiting levelOne()");
    }

    static void levelTwo() {
        System.out.println("  Entered levelTwo()");
        levelThree();
        System.out.println("  Exiting levelTwo()");
    }

    static void levelThree() {
        System.out.println("    Entered levelThree() — deepest point of the stack");
        System.out.println("    Exiting levelThree()");
    }

    static void incrementGlobalCounter() {
        globalCounter++; // modifies the shared static field, not a local copy
        System.out.println("globalCounter is now: " + globalCounter);
    }
}