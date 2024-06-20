public class ArraySum {

    public static int sumOfArray(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }
        return array[index] + sumOfArray(array, index + 1);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {10, 20, 30, 40, 50};

        int sum1 = sumOfArray(array1, 0);
        int sum2 = sumOfArray(array2, 0);

        System.out.println("Sum of array1: " + sum1);
        System.out.println("Sum of array2: " + sum2);
    }
}

