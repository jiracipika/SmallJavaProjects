/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 6
Any and all work in this file is my own.
*/ 

public class TestLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        
        // Add items to list
        String[] itemsToAdd = {"Milk", "Eggs", "Celery", "Bananas", "Apples", "Oranges", "Cookies", "Steak"};
        for (String item : itemsToAdd) {
            try {
                list.add(item, list.size());
                System.out.println("After adding " + item + ": " + list);
            } catch (ListException e) {
                e.printStackTrace();
            }
        }

        // Remove Celery and Oranges from list using find method
        String[] itemsToRemove = {"Celery", "Oranges"};
        for (String item : itemsToRemove) {
            try {
                int index = list.find(item);
                if (index != -1) {
                    list.remove(index);
                    System.out.println("After removing " + item + ": " + list);
                } else {
                    System.out.println(item + " not found in the list.");
                }
            } catch (ListException e) {
                e.printStackTrace();
            }
        }
    }
}
