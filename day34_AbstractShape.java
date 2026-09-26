public abstract class day34_AbstractShape {
    String name;

    day34_AbstractShape(String name) {
        this.name = name;
    }

    // Abstract method: NO body — every concrete subclass MUST implement this
    abstract double area();
    abstract double perimeter();

    // Concrete (regular) method: shared behavior, inherited as-is unless overridden
    void printSummary() {
        System.out.printf("%s -> area: %.2f, perimeter: %.2f%n", name, area(), perimeter());
    }

    public static void main(String[] args) {
        // AbstractShape shape = new AbstractShape("test"); // <- would NOT compile: cannot instantiate abstract class

        day34_AbstractShape[] shapes = {
            new Circle(4),
            new Rectangle(3, 5),
            new Triangle(6, 4, 5, 5, 5)
        };

        System.out.println("--- Abstract class forces every subclass to define area/perimeter ---");
        for (day34_AbstractShape shape : shapes) {
            shape.printSummary(); // shared method, but calls each subclass's own area()/perimeter()
        }

        double totalArea = 0;
        for (day34_AbstractShape shape : shapes) {
            totalArea += shape.area();
        }
        System.out.println("\nTotal combined area: " + String.format("%.2f", totalArea));
    }
}

class Circle extends day34_AbstractShape {
    private double radius;

    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends day34_AbstractShape {
    private double width, height;

    Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double perimeter() {
        return 2 * (width + height);
    }
}

class Triangle extends day34_AbstractShape {
    private double base, height, sideA, sideB, sideC;

    Triangle(double base, double height, double sideA, double sideB, double sideC) {
        super("Triangle");
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    double perimeter() {
        return sideA + sideB + sideC;
    }
}
