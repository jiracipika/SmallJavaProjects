import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students are in the class?");
        int numberOfStudents = scanner.nextInt();

        double[] grades = new double[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter grade for student #" + (i + 1) + ":");
            grades[i] = scanner.nextDouble();
        }
        scanner.close();

        double max = getMaxScore(grades);
        double min = getMinScore(grades);

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student #" + (i + 1) + ": " + getLetterGrade(grades[i], max));
        }

        System.out.println("Highest score: " + max);
        System.out.println("Lowest score: " + min);
    }

    public static double getMaxScore(double[] grades) {
        double max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public static double getMinScore(double[] grades) {
        double min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    public static String getLetterGrade(double grade, double max) {
        if (grade >= max - 5) {
            return "A";
        } else if (grade >= max - 10) {
            return "B";
        } else if (grade >= max - 15) {
            return "C";
        } else if (grade >= max - 20) {
            return "D";
        } else {
            return "F";
        }
    }
}
