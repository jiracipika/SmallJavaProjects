/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 8
Any and all work in this file is my own.
*/ 

import java.util.Scanner;

public class ParenthesisChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            try {
                BasedArrayStack stack = new BasedArrayStack(input.length());
                for (char ch : input.toCharArray()) {
                    if (ch == '(') {
                        stack.push(ch);
                    } else if (ch == ')') {
                        if (stack.isEmpty()) {
                            throw new StackException("Too many closing parentheses");
                        }
                        stack.pop();
                    }
                }

                if (stack.isEmpty()) {
                    System.out.println("The string \"" + input + "\" has the correct number of parentheses.");
                } else {
                    System.out.println("The string \"" + input + "\" has too many opening parentheses.");
                }
            } catch (StackException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
