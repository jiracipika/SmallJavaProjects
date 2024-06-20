/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 2, Question 2
Any and all work in this file is my own.
*/ 

public class Test1and2Q2 {
    public static void main(String[] args) {
        // Test Case 1
        DynamicList<Integer> list = new DynamicList<>();
        list.add(5);
        list.add(10);
        list.add(15);

        System.out.println("Test Case 1:");
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));

        // Test Case 2
        DynamicList<String> stringList = new DynamicList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.remove("apple");

        System.out.println("\nTest Case 2:");
        System.out.println("Size: " + stringList.size());
        System.out.println("Element at index 0: " + stringList.get(0));
    }
}
