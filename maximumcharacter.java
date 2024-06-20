public class maximumcharacter {

    public static char maximumChar(String str, char max) {
        if (str.isEmpty()) {
            return max;
        } else {
            char currentChar = str.charAt(0);
            if (currentChar > max) {
                max = currentChar; 
            }
            return maximumChar(str.substring(1), max);
        }
    }

    public static void main(String[] args) {
        try (
        java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.println("Enter a string to find the maximum character:");
            String input = scanner.nextLine();
            char maxChar = maximumChar(input, '\0');
            System.out.println("The maximum character is: " + maxChar);
        }
    }
}
