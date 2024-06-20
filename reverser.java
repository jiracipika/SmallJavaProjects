public class reverser {

    public static void reverse(int number) {
        if (number < 0) {
            reverseRecursive(-number);
            System.out.print("-");
        } else {
            reverseRecursive(number);
        }
    }

    private static void reverseRecursive(int number) {
        System.out.print(number % 10);
        if (number >= 10) {
            reverseRecursive(number / 10);
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a number to reverse:");
        int number = scanner.nextInt();
        System.out.print("The reversed number is: ");
        reverse(number);
        scanner.close(); 
    }
}
