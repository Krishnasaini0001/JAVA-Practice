public class Drawable {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(4);

        // ----- Treating different classes uniformly through a shared interface -----
        Shape[] shapes = { circle, square };
        for (Shape shape : shapes) {
            shape.draw();
        }

        // ----- A class implementing MULTIPLE interfaces -----
        System.out.println("\n--- Multiple interface implementation ---");
        SmartCircle smartCircle = new SmartCircle(3);
        smartCircle.draw();   // from Shape interface
        smartCircle.resize(2); // from Resizable interface
        smartCircle.draw();

        // ----- Interfaces as contracts: any class implementing Shape MUST provide draw() -----
        System.out.println("\n--- Interfaces define contracts ---");
        printShapeInfo(circle);
        printShapeInfo(square);
    }

    static void printShapeInfo(Shape shape) {
        System.out.println("This shape guarantees a draw() method: ");
        shape.draw();
    }
}

// An interface: a pure contract — no fields (except constants), no method bodies (until Day 36's defaults)
interface Shape {
    void draw(); // implicitly public and abstract
}

interface Resizable {
    void resize(double factor);
}

class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() { // must be public — interface methods are implicitly public
        System.out.println("Drawing a circle with radius " + radius);
    }
}

class Square implements Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a square with side " + side);
    }
}

// Implementing two interfaces at once — Java allows this (unlike multiple class inheritance)
class SmartCircle implements Shape, Resizable {
    private double radius;

    SmartCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a SmartCircle with radius " + radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
        System.out.println("Resized SmartCircle, new radius: " + radius);
    }
}
