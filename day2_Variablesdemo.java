public class VariablesDemo {
    public static void main(String[] args) {
        // ----- Integer types -----
        byte smallNumber = 120;              // 8-bit,  -128 to 127
        short mediumNumber = 32000;          // 16-bit, -32,768 to 32,767
        int regularNumber = 2_000_000_000;   // 32-bit, most commonly used integer type
        long bigNumber = 9_000_000_000L;     // 64-bit, note the 'L' suffix
 
        // ----- Floating-point types -----
        float price = 19.99f;                // 32-bit, note the 'f' suffix
        double preciseValue = 3.14159265358979; // 64-bit, default for decimals
 
        // ----- Other primitives -----
        char letter = 'J';                   // single 16-bit Unicode character
        boolean isJavaFun = true;             // true or false only
 
        // Print everything with labels
        System.out.println("byte:    " + smallNumber);
        System.out.println("short:   " + mediumNumber);
        System.out.println("int:     " + regularNumber);
        System.out.println("long:    " + bigNumber);
        System.out.println("float:   " + price);
        System.out.println("double:  " + preciseValue);
        System.out.println("char:    " + letter);
        System.out.println("boolean: " + isJavaFun);
 
        // Show memory sizes so the ranges actually stick
        System.out.println("\n--- Sizes (bits) ---");
        System.out.println("byte:  " + Byte.SIZE);
        System.out.println("short: " + Short.SIZE);
        System.out.println("int:   " + Integer.SIZE);
        System.out.println("long:  " + Long.SIZE);
 
        // Show min/max ranges — useful for understanding overflow
        System.out.println("\n--- Ranges ---");
        System.out.println("int min/max: " + Integer.MIN_VALUE + " / " + Integer.MAX_VALUE);
        System.out.println("byte min/max: " + Byte.MIN_VALUE + " / " + Byte.MAX_VALUE);
 
        // Demonstrate overflow on purpose (a common beginner "gotcha")
        byte overflowed = (byte) (Byte.MAX_VALUE + 1);
        System.out.println("\nByte.MAX_VALUE + 1 overflows to: " + overflowed);
    }
}