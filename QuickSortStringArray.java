/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 2, Question 4
Any and all work in this file is my own.
*/ 

import java.util.Arrays;

public class QuickSortStringArray {

    public static void quickSort(String[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(String[] arr, int begin, int end) {
        String pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].length() <= pivot.length()) {
                i++;

                String swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        String swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }


    public static void main(String[] args) {
        String[] input1 = {"Sun", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        quickSort(input1, 0, input1.length - 1);
        System.out.println(Arrays.toString(input1)); 

        String[] input2 = {"Dog", "Elephant", "Cat", "Hippopotamus", "Bear", "Fox", "Giraffe"};
        quickSort(input2, 0, input2.length - 1);
        System.out.println(Arrays.toString(input2));
    }
}
