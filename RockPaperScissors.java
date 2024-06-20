import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter a move! \nRock (1), Paper (2), Scissors (3) : ");
        int userMove = scanner.nextInt();

        if (userMove < 1 || userMove > 3) {
            System.out.println("Not a valid move. Exiting program.");
            scanner.close();
            return;
        }

        int computerMove = random.nextInt(3) + 1;

        String userMoveStr = convertMoveToString(userMove);
        String computerMoveStr = convertMoveToString(computerMove);

        // Display choices
        System.out.println("You have selected " + userMoveStr + ", CPU has selected " + computerMoveStr + ".");

        // Determine the winner using if-statements
        if (userMove == computerMove) {
            System.out.println("It is a tie!");
        } else if ((userMove == 1 && computerMove == 3) ||
                   (userMove == 2 && computerMove == 1) ||
                   (userMove == 3 && computerMove == 2)) {
            System.out.println("You win!");
        } else {
            System.out.println("CPU wins!");
        }

        scanner.close();
    }

    public static String convertMoveToString(int move) {
        switch (move) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid";
        }
    }
}
