public class MyRectangle2D {

    private double x, y, width, height;

    // No-arg constructor
    public MyRectangle2D() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    // Constructor with x, y, width, and height
    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return (x >= this.x - width / 2 && x <= this.x + width / 2) &&
               (y >= this.y - height / 2 && y <= this.y + height / 2);
    }

    public boolean contains(MyRectangle2D r) {
        double distanceX = Math.abs(r.x - this.x);
        double distanceY = Math.abs(r.y - this.y);
        return (distanceX + r.width / 2 <= this.width / 2) &&
               (distanceY + r.height / 2 <= this.height / 2);
    }

    public boolean overlaps(MyRectangle2D r) {
        double distanceX = Math.abs(r.x - this.x);
        double distanceY = Math.abs(r.y - this.y);
        return (distanceX < (r.width + this.width) / 2) &&
               (distanceY < (r.height + this.height) / 2);
    }

    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println("Area is " + r1.getArea());
        System.out.println("Perimeter is " + r1.getPerimeter());
        System.out.println("r1 contains point (3,3) is " + r1.contains(3, 3));
        System.out.println("r1 contains rectangle is " + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println("r1 overlaps rectangle is " + r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}
