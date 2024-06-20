import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A valid password must have");
        System.out.println(" - at least 10 characters");
        System.out.println(" - at least one uppercase letter");
        System.out.println(" - at least one lowercase letter");
        System.out.println(" - at least one number");
        System.out.println(" - at least one symbol\n");

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password meets all requirements.");
        } else {
            System.out.println("A valid password must have");
            System.out.println(" - at least 10 characters");
            System.out.println(" - at least one uppercase letter");
            System.out.println(" - at least one lowercase letter");
            System.out.println(" - at least one number");
            System.out.println(" - at least one symbol\n");
        }

        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 10) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                // if the character is not a letter or digit, then it is considered a symbol
                hasSymbol = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSymbol;
    }
}
