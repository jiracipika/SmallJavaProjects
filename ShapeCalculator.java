import java.util.Scanner;

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Choose a shape (1) triangle, (2) square, (3) circle: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("not a valid selection, please pick again");
                continue;
            }

            System.out.print("Choose a calculation (1) perimeter, (2) area: ");
            int calcChoice = sc.nextInt();

            if (calcChoice < 1 || calcChoice > 2) {
                System.out.println("not a valid selection, please pick again");
                continue;
            }

            switch (choice) {
                case 1:
                    if (calcChoice == 1) {
                        System.out.print("Enter 3 side lengths: ");
                        double side1 = sc.nextDouble();
                        double side2 = sc.nextDouble();
                        double side3 = sc.nextDouble();
                        System.out.println("The perimeter of the triangle is " + trianglePerimeter(side1, side2, side3));
                    }
                    break;
                case 2:
                    break;
                case 3:
                    if (calcChoice == 2) {
                        System.out.print("Enter the radius: ");
                        double radius = sc.nextDouble();
                        System.out.println("The area of the circle is " + circleArea(radius));
                    } else if (calcChoice == 1) {
                        System.out.print("Enter the radius: ");
                        double radius = sc.nextDouble();
                        System.out.println("The perimeter (circumference) of the circle is " + circlePerimeter(radius));
                        sc.close();
                    }
                    break;
            }
        }
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double circlePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}
