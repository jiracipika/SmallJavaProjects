
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

// Triangle class definition
class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
        this.side1 = 0;
        this.side2 = 0;
        this.side3 = 0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public void setSide1(double side1) { this.side1 = side1; }
    public void setSide2(double side2) { this.side2 = side2; }
    public void setSide3(double side3) { this.side3 = side3; }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}

class TestTriangle {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter side1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side3: ");
        double side3 = input.nextDouble();

        Triangle triangle = new Triangle(side1, side2, side3);

        System.out.print("Enter color: ");
        String color = input.next();
        System.out.print("Is the triangle filled (true/false)? ");
        boolean filled = input.nextBoolean();

        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("The perimeter of the triangle is " + triangle.getPerimeter());
        System.out.println(triangle.toString());
        System.out.println("The color is " + triangle.getColor() + " and filled is " + triangle.isFilled());

        input.close();
    }
}
