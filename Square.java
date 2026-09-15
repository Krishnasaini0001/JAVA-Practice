package shapes;

public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    // Package-private method (no modifier): only visible to other classes in the 'shapes' package
    double diagonal() {
        return side * Math.sqrt(2);
    }

    // Protected method: visible within the package AND to subclasses in other packages
    protected String describe() {
        return "Square with side " + side;
    }
}