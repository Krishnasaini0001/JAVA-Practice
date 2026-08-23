public class StringDemo {
    public static void main(String[] args) {
        // ----- String immutability -----
        String greeting = "Hello";
        String modified = greeting.concat(", World!"); // creates a NEW String object
        System.out.println("--- Immutability ---");
        System.out.println("original greeting: " + greeting);   // unchanged: "Hello"
        System.out.println("new modified string: " + modified); // "Hello, World!"
 
        // ----- Common String methods -----
        String text = "  Java Programming  ";
        System.out.println("\n--- Common Methods ---");
        System.out.println("length():       " + text.length());
        System.out.println("trim():         '" + text.trim() + "'");
        System.out.println("toUpperCase():  " + text.toUpperCase());
        System.out.println("toLowerCase():  " + text.toLowerCase());
        System.out.println("indexOf('P'):   " + text.indexOf('P'));
        System.out.println("substring(2,6): " + text.substring(2, 6));
        System.out.println("replace('a','_'): " + text.replace('a', '_'));
        System.out.println("contains(\"Prog\"): " + text.contains("Prog"));
        System.out.println("split by space -> length: " + text.trim().split(" ").length);
 
        // Comparing strings correctly
        String s1 = "java";
        String s2 = "JAVA";
        System.out.println("\n--- Comparison ---");
        System.out.println("s1.equals(s2):           " + s1.equals(s2));
        System.out.println("s1.equalsIgnoreCase(s2): " + s1.equalsIgnoreCase(s2));
 
        // ----- StringBuilder: mutable, efficient for repeated modification -----
        System.out.println("\n--- StringBuilder ---");
        StringBuilder builder = new StringBuilder();
        builder.append("Building");
        builder.append(" a ");
        builder.append("string ");
        builder.append("efficiently.");
        System.out.println("Built string: " + builder.toString());
 
        builder.insert(0, "[LOG] ");
        System.out.println("After insert: " + builder);
 
        builder.reverse();
        System.out.println("Reversed: " + builder);
        builder.reverse(); // flip it back for a clean final read
 
        // ----- Why StringBuilder beats String concatenation in loops -----
        System.out.println("\n--- Why StringBuilder Matters in Loops ---");
        StringBuilder loopBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            loopBuilder.append(i).append(" "); // no new object created each iteration
        }
        System.out.println("Numbers 1-5: " + loopBuilder.toString().trim());
 
        // StringBuffer: same API as StringBuilder, but thread-safe (slower) — mention only
        StringBuffer safeBuilder = new StringBuffer("Thread-safe version");
        System.out.println("\nStringBuffer example: " + safeBuilder);
    }
}