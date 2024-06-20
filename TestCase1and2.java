/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 2, Question 1
Any and all work in this file is my own.
*/ 

public class TestCase1and2 {
    public static void main(String[] args) {
        // Test Case 1
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        System.out.println("Size: " + integerList.size()); 
        System.out.println("Element at index 1: " + integerList.get(1)); 

        // Test Case 2
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.remove(0); 
        System.out.println("Size: " + stringList.size());
        System.out.println("Element at index 0: " + stringList.get(0));
    }
}
