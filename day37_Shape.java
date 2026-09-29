public class day37_Shape {
    // A sealed class restricts EXACTLY which classes are allowed to extend it —
    // unlike normal inheritance, where anyone can extend a public class.
    sealed interface Figure permits Circle, Square, Triangle {
        double area();
    }

    // 'final' subclasses cannot be extended further
    record Circle(double radius) implements Figure {
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    record Square(double side) implements Figure {
        public double area() {
            return side * side;
        }
    }

    // A sealed class can also permit a 'non-sealed' subclass, reopening the hierarchy from that point
    record Triangle(double base, double height) implements Figure {
        public double area() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Figure[] figures = {
            new Circle(3),
            new Square(4),
            new Triangle(6, 2)
        };

        System.out.println("--- Sealed interface: the compiler knows ALL possible implementations ---");
        for (Figure figure : figures) {
            // Pattern-matching switch: exhaustive because the hierarchy is sealed —
            // no 'default' branch needed, the compiler proves every case is covered!
            String description = switch (figure) {
                case Circle c -> "Circle with radius " + c.radius();
                case Square s -> "Square with side " + s.side();
                case Triangle t -> "Triangle with base " + t.base() + " and height " + t.height();
            };
            System.out.printf("%-35s area = %.2f%n", description, figure.area());
        }

        System.out.println("\nSealed hierarchies are great for modeling a FIXED set of variants");
        System.out.println("(e.g., payment methods, HTTP responses, states in a state machine)");

        // class Hexagon implements Figure {} // <- would NOT compile: Hexagon isn't in 'permits'
    }
}
