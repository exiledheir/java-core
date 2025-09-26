package lesson03.firstHalf.entities;

public class Rectangle {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        if (length <= 0) {
            throw new IllegalArgumentException("Enter valid length");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Enter valid width");
        }
        this.length = length;
        this.width = width;
    }

    public double calculateSquare() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}