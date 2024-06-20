 class GeometricObject {
    // Implementations of GeometricObject class (if any)
}

 class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;
    
    public Octagon() {
        this.side = 0;
    }
    
    public Octagon(double side) {
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return (2 + 4*Math.sqrt(2)) * side * side;
    }
    
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestOctagon {
    public static void main(String[] args) {
        try {
            Octagon octagon1 = new Octagon(5);
            
            System.out.println("Octagon1 - Area: " + octagon1.getArea() + ", Perimeter: " + octagon1.getPerimeter());
            
            Octagon octagon2 = (Octagon) octagon1.clone();
            
            System.out.println("Octagon2 (cloned) - Area: " + octagon2.getArea() + ", Perimeter: " + octagon2.getPerimeter());
            
            int compareResult = octagon1.compareTo(octagon2);
            String comparison = (compareResult == 0) ? "equal in area to" : ((compareResult > 0) ? "larger than" : "smaller than");
            
            System.out.println("Octagon1 is " + comparison + " Octagon2.");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
