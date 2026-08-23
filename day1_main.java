public class Main {
    public static void main(String[] args) {
        // Every Java app starts execution here: public static void main(String[] args)
        System.out.println("Hello, World!");
 
        // A couple of quick checks to confirm your setup works end-to-end
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Running on OS: " + System.getProperty("os.name"));
 
        greet("Java learner");
    }
 
    // A simple method call to prove methods work too
    static void greet(String name) {
        System.out.println("Welcome, " + name + "! Day 1 complete.");
    }
}
 