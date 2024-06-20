public class RightAngleTriangle {
    private double base;
    private double height;

    public RightAngleTriangle() {
        this.base = 0.0;
        this.height = 0.0;
    }

    public RightAngleTriangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return this.base;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setDimensions(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public String toString() {
        return "Right Angle Triangle: base=" + base + ", height=" + height;
    }
    public boolean equals(Object obj) {
        if (this ==obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        RightAngleTriangle other = (RightAngleTriangle) obj;
        return base == other.base && height == other.height;
    }

    public class Tester {
        public static void main(String[] args) {
            RightAngleTriangle[] triangles = {
                new RightAngleTriangle(1, 2),
                new RightAngleTriangle(3, 4),
                new RightAngleTriangle(5, 6),
                new RightAngleTriangle(7, 8),
                new RightAngleTriangle(9, 10),
            };

            for (RightAngleTriangle triangle : triangles) {
                System.out.println(triangle);
            }

            RightAngleTriangle triangle1 = new RightAngleTriangle(1, 2);
            RightAngleTriangle triangle2 = new RightAngleTriangle(2, 3);

            if (triangle1.equals(triangle2)) {
                System.out.println("Triangles are equal");
            } 
            else {
                System.out.println("Triangles aren't equal");
            } 
        }
    }
}

