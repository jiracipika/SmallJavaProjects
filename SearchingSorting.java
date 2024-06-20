/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 10
Any and all work in this file is my own.
*/ 

import java.util.Arrays;

public class SearchingSorting {

    public static void main(String[] args) {
        int[] array = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};

        // Sequential Search
        int searchIndex9 = sequentialSearch(array, 9);
        System.out.println("Index of 9: " + searchIndex9);

        int searchIndex100 = sequentialSearch(array, 100);
        System.out.println("Index of 100: " + searchIndex100);

        // Bubble Sort
        bubbleSort(array);
        System.out.println("Bubble Sorted Array: " + Arrays.toString(array));

        // Binary Search (using sorted array)
        int binarySearchIndex20 = binarySearch(array, 0, array.length - 1, 20);
        System.out.println("Binary Search Index of 20: " + binarySearchIndex20);

        // Merge Sort for Descending Order
        int[] sortedDescending = mergeSort(array);
        System.out.println("Merge Sorted Array in Descending Order: " + Arrays.toString(sortedDescending));
    }

    public static int sequentialSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == k) {
            return mid;
        } else if (arr[mid] > k) {
            return binarySearch(arr, start, mid - 1, k);
        } else {
            return binarySearch(arr, mid + 1, end, k);
        }
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] >= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
}
