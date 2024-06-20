import java.util.Arrays;

public class Course {
    private String courseName;
    String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if (numberOfStudents == students.length) {
            students = Arrays.copyOf(students, students.length * 2);
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return Arrays.copyOf(students, numberOfStudents);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                numberOfStudents--;
                return;
            }
        }
    }

    public void clear() {
        students = new String[100];
        numberOfStudents = 0;
    }

    // Test program
    public static void main(String[] args) {
        Course course = new Course("COSC 1047O");
        course.addStudent("Student 1");
        course.addStudent("Student 2");
        course.addStudent("Student 3");

        course.dropStudent("Student 2");

        String[] remainingStudents = course.getStudents();
        for (String student : remainingStudents) {
            System.out.println(student);
        }
    }
}
