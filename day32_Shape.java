
public class day32_Shape {
    double area() {
        return 0.0; // default: unknown shape has no meaningful area
    }

    String describe() {
        return "A generic shape with area " + area();
    }

    public static void main(String[] args) {
        day32_Shape generic = new day32_Shape();
        day32_Shape circle = new Circle(5);
        day32_Shape rectangle = new Rectangle(4, 6);

        System.out.println(generic.describe());
        System.out.println(circle.describe());     // calls Circle's overridden area()
        System.out.println(rectangle.describe());   // calls Rectangle's overridden area()

        // ----- Overriding vs overloading -----
        System.out.println("\n--- Overriding vs Overloading ---");
        Circle c = new Circle(3);
        System.out.println("c.area() [overridden method]: " + c.area());
        System.out.println("c.area(2) [overloaded method, extra scale param]: " + c.area(2));

        // ----- super keyword: calling the parent's version of an overridden method -----
        System.out.println("\n--- Using super to call parent implementation ---");
        Rectangle rect = new Rectangle(3, 5);
        rect.describeWithParentFallback();
    }
}

class Circle extends day32_Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override // marks this as an intentional override — compiler checks it actually matches a parent method
    double area() {
        return Math.PI * radius * radius;
    }

    // Overloading: same method name "area", different parameter list — NOT overriding
    double area(double scaleFactor) {
        return area() * scaleFactor;
    }
}

class Rectangle extends day32_Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    String describe() {
        return "A rectangle (" + width + " x " + height + ") with area " + area();
    }

    void describeWithParentFallback() {
        System.out.println("Rectangle's own describe(): " + describe());
        System.out.println("Parent Shape's describe() via super: " + super.describe());
    }
}
