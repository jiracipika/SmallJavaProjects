import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    public GeometricObject() {
        dateCreated = new java.util.Date();
    }

    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }
    public java.util.Date getDateCreated() { return dateCreated; }
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}

class Triangle extends GeometricObject {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException(
                "The sum of any two sides should be greater than the third one. Given sides: " + 
                "side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3
            );
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }
    public double getPerimeter() { return side1 + side2 + side3; }
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

public class TestTriangleException {
    public static void main(String[] args) {
        int side1 = 0, side2 = 0, side3 = 0;

        try {
            Scanner fileScanner = new Scanner(new File("sides.txt"));
            if(fileScanner.hasNextInt()) side1 = fileScanner.nextInt();
            if(fileScanner.hasNextInt()) side2 = fileScanner.nextInt();
            if(fileScanner.hasNextInt()) side3 = fileScanner.nextInt();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        try {
            Triangle triangle = new Triangle(side1, side2, side3);
            System.out.println("Triangle is created successfully with sides: " + 
                               "side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3);
        } catch (IllegalTriangleException e) {
            System.out.println("IllegalTriangleException: " + e.getMessage());
        }
    }
}
