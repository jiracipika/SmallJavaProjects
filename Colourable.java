// Colorable.java
public interface Colourable {
    void howToColor();
}

// GeometricObject.java
abstract class GeometricObject {
    public abstract double getArea();
}

// Square.java
class Square extends GeometricObject implements Colourable {
    private double side;

    public Square() {
        this.side = 0;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

// Test program
class Test {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[5];

        // Populate the array
        objects[0] = new Square(5);
        objects[1] = new Square(7);
        // ... similarly, populate the rest of the array

        for (GeometricObject object : objects) {
            System.out.println("Area: " + object.getArea());

            if (object instanceof Colourable) {
                ((Colourable) object).howToColor();
            }
        }
    }
}
