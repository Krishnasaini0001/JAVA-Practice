public class CastingDemo {
    public static void main(String[] args) {
        // ----- Widening (implicit) conversion: smaller type -> larger type, automatic -----
        int intValue = 100;
        long longValue = intValue;      // int -> long, no data loss
        double doubleValue = longValue; // long -> double, no data loss
 
        System.out.println("--- Widening (automatic) ---");
        System.out.println("int:    " + intValue);
        System.out.println("long:   " + longValue);
        System.out.println("double: " + doubleValue);
 
        // ----- Narrowing (explicit) conversion: larger type -> smaller type, needs a cast -----
        double preciseValue = 9.78;
        int truncated = (int) preciseValue; // decimal part is dropped, NOT rounded
 
        System.out.println("\n--- Narrowing (explicit cast required) ---");
        System.out.println("double 9.78 cast to int = " + truncated);
 
        long bigLong = 130L;
        byte narrowedByte = (byte) bigLong; // fits fine, byte range is -128 to 127
        long tooBig = 200L;
        byte overflowByte = (byte) tooBig;  // does NOT fit -> wraps around unexpectedly
        System.out.println("130L cast to byte = " + narrowedByte);
        System.out.println("200L cast to byte (overflow) = " + overflowByte);
 
        // ----- Autoboxing: primitive -> wrapper object, automatic -----
        System.out.println("\n--- Autoboxing & Unboxing ---");
        Integer boxedInt = 42;          // autoboxing: int -> Integer
        int unboxedInt = boxedInt;      // unboxing:  Integer -> int
        System.out.println("boxedInt (Integer):   " + boxedInt);
        System.out.println("unboxedInt (int):     " + unboxedInt);
 
        Double boxedDouble = 3.14;
        double unboxedDouble = boxedDouble;
        System.out.println("boxedDouble (Double): " + boxedDouble);
        System.out.println("unboxedDouble (double): " + unboxedDouble);
 
        // ----- Useful wrapper class utility methods -----
        System.out.println("\n--- Wrapper Utility Methods ---");
        String numberAsText = "256";
        int parsed = Integer.parseInt(numberAsText); // String -> int
        System.out.println("Integer.parseInt(\"256\") = " + parsed);
 
        String backToText = Integer.toString(parsed); // int -> String
        System.out.println("Integer.toString(256) = \"" + backToText + "\"");
 
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Double.MAX_VALUE  = " + Double.MAX_VALUE);
 
        // Comparing wrapper objects safely (common beginner pitfall)
        Integer a = 1000;
        Integer b = 1000;
        System.out.println("\n--- Wrapper Comparison Pitfall ---");
        System.out.println("a == b (reference compare): " + (a == b));       // false! different objects
        System.out.println("a.equals(b) (value compare): " + a.equals(b));   // true
    }
}