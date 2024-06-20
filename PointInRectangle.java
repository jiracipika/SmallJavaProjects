import java.util.Scanner;

public class PointInRectangle {
    public static void main(String[] args) {
        // Create Scanner to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt to enter point (x, y)
        System.out.print("Enter a point with two coordinates: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        
        // Close scanner
        scanner.close();
        
        // Dimensions of rectangle
        double width = 10.0;
        double height = 5.0;
        
        // Calculate half dimensions
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        
        // Check if point is inside rectangle (Used Math.abs to make life easier)
        if (Math.abs(x) <= halfWidth && Math.abs(y) <= halfHeight) {
            System.out.printf("Point (%.1f, %.1f) is in the rectangle%n", x, y);
        } else {
            System.out.printf("Point (%.1f, %.1f) is not in the rectangle%n", x, y);
        }
    }
}
