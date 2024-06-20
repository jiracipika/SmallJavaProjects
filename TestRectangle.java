public class TestRectangle {

    public static void main(String[] args) {
        // Creating first object using default constructor
        Rectangle rectangle1 = new Rectangle();
        System.out.println("First Rectangle - Length: " + rectangle1.getLength() + ", Width: " + rectangle1.getWidth());

        // Creating second object using parameterized constructor
        Rectangle rectangle2 = new Rectangle(15, 16);
        System.out.println("Second Rectangle - Length: " + rectangle2.getLength() + ", Width: " + rectangle2.getWidth());

        // Setting length and width of first object
        rectangle1.setLength(13);
        rectangle1.setWidth(14);
        System.out.println(rectangle1);

        // Declaring array of Rectangle and initializing it
        Rectangle[] rectangles = new Rectangle[10];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle(i + 1, i + 2);
        }

        // Printing content of Rectangle array
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        // Create third and fourth objects and comparing them using equals() method
        Rectangle rectangle3 = new Rectangle(5, 6);
        Rectangle rectangle4 = new Rectangle(5, 6);
        System.out.println("Third and Fourth Rectangles are equal: " + rectangle3.equals(rectangle4));
    }
}
