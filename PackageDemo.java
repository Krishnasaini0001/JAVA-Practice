package app;

// Importing specific classes from another package
import shapes.Circle;
import shapes.Square;

public class PackageDemo {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(4);

        System.out.println("--- Using classes from the 'shapes' package ---");
        System.out.println("Circle area: " + circle.area());
        System.out.println("Circle circumference: " + circle.circumference());
        System.out.println("Square area: " + square.area());

        // square.diagonal();   // <- would NOT compile: package-private, not visible from 'app' package
        // square.describe();   // <- would NOT compile here either: protected, only visible to subclasses
        //                          or classes in the SAME package ('shapes'), not just any importer

        System.out.println("\n--- Access control summary ---");
        System.out.println("public:            visible everywhere (e.g., Circle.area())");
        System.out.println("protected:          visible in same package + subclasses elsewhere");
        System.out.println("(no modifier):      visible only within the same package");
        System.out.println("private:            visible only within the declaring class");
    }
}