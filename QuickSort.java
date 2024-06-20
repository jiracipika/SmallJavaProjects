/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Final Exam: Question 8
Any and all work in this file is my own.
*/ 

public class QuickSort {
    
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            // Recursively sort elements
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    // Main
    public static void main(String[] args) {
        int[] testArray1 = {34, 7, 23, 32, 5, 62};
        int[] testArray2 = {88, 55, 42, 90, 21};

        quickSort(testArray1, 0, testArray1.length - 1);
        quickSort(testArray2, 0, testArray2.length - 1);


        System.out.println(arrayToString(testArray1));
        System.out.println(arrayToString(testArray2));
    }


    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
