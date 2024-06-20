/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 8
Any and all work in this file is my own.
*/ 

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            try {
                BasedArrayStack stack = new BasedArrayStack(input.length());
                for (char ch : input.toCharArray()) {
                    stack.push(ch);
                }

                StringBuilder reversed = new StringBuilder();
                while (!stack.isEmpty()) {
                    reversed.append(stack.pop());
                }

                System.out.println("Reversed string: " + reversed);
            } catch (StackException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
