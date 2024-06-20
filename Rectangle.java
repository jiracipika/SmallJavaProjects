public class Rectangle {

    private static final int DEFAULT_VALUE = 0;
    private int length;
    private int width;

    public Rectangle() {
        this.length = DEFAULT_VALUE;
        this.width = DEFAULT_VALUE;
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength_Width(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int findArea() {
        return length * width;
    }

    public int findPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle[length=" + length + ", width=" + width + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return length == rectangle.length && width == rectangle.width;
    }
}
