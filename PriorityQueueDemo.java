/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Final Exam: Question 11
Any and all work in this file is my own.
*/ 

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Test Case 1
        PriorityQueue<String> fruits1 = new PriorityQueue<>();
        processQueue(fruits1, "Apple");
        processQueue(fruits1, "Banana");
        processQueue(fruits1, "Cherry");
        fruits1.remove("Banana");
        System.out.println();
        printQueue(fruits1);

        // Test Case 2
        PriorityQueue<String> fruits2 = new PriorityQueue<>();
        processQueue(fruits2, "Orange");
        processQueue(fruits2, "Pear");
        processQueue(fruits2, "Grape");
        fruits2.remove("Pear");
        System.out.println();
        printQueue(fruits2);
    }

    private static void processQueue(PriorityQueue<String> queue, String element) {
        queue.add(element);
    }

    private static void printQueue(PriorityQueue<String> queue) {
        for (String element : queue) {
            System.out.println(element);
        }
    }
}
