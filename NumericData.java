/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Final Exam: Question 12
Any and all work in this file is my own.
*/ 

import java.util.List;

public class NumericData {

    public static double multiplyListElements(List<? extends Number> numbers) {
        double product = 1.0;
        for (Number number : numbers) {
            product *= number.doubleValue();
        }
        return Math.round(product * 10.0) / 10.0; //one decimal place
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3);
        System.out.println("Product of Integer List: " + multiplyListElements(integerList));

        List<Double> doubleList = List.of(1.1, 2.0, 3.0);
        System.out.println("Product of Double List: " + multiplyListElements(doubleList));
    }
}

