import java.util.Random;
import java.util.Scanner;

public class MathQuestionGenerator {
  
  public static void main(String[] args) {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    int firstNumber = random.nextInt(16) + 1;
    int secondNumber = random.nextInt(16) + 1;

    if (secondNumber == 0) {
      secondNumber = 1;
    }

    char operator = getRandomOperator();
    System.out.print(firstNumber + " " + operator + " " + secondNumber + " = ");
    
    int userAnswer = scanner.nextInt();
    int correctAnswer = calculateAnswer(firstNumber, secondNumber, operator);

    if (userAnswer == correctAnswer) {
      System.out.println("Correct!");
    } else {
      System.out.println("Incorrect! Caorrect answer is " + correctAnswer);
    }

    scanner.close();
  }

  public static char getRandomOperator() {
    char[] possibleOperators = {'+', '-', '*', '/'};
    Random random = new Random();
    int index = random.nextInt(4);
    return possibleOperators[index];
  }

  public static int calculateAnswer(int a, int b, char op) {
    switch (op) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
    }
    return 0;
  }
}
