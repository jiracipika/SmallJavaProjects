/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 7
Any and all work in this file is my own.
*/ 

public class TestSingleSortedLinkedList {
    public static void main(String[] args) {
        SingleSortedLinkedList list = new SingleSortedLinkedList();
        
        // Insert names into list
        String[] namesToAdd = {"Alice", "Bob", "Charlie", "Daisy", "Ethan", "Fiona", "George", "Hannah", "Ivan", "Julia"};
        for (String name : namesToAdd) {
            try {
                list.insert(name);
                System.out.println("After inserting " + name + ": " + list);
            } catch (LinkedListException e) {
                e.printStackTrace();
            }
        }

        // Remove three names from list
        String[] namesToRemove = {"Charlie", "Fiona", "Ivan"};
        for (String name : namesToRemove) {
            try {
                int index = list.find(name);
                if (index != -1) {
                    list.remove(index);
                    System.out.println("After removing " + name + ": " + list);
                } else {
                    System.out.println(name + " not found in the list.");
                }
            } catch (LinkedListException e) {
                e.printStackTrace();
            }
        }
    }
}
