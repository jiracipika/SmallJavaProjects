public class Course2 implements Cloneable {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course2(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        // Additional code for dropping a student will be needed here
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Course cloned = (Course) super.clone(); // Clone the Course object
        cloned.students = new String[students.length]; // Create a new students array
        // Copy each student
        for (int i = 0; i < numberOfStudents; i++) {
            cloned.students[i] = new String(students[i]);
        }
        return cloned;
    }
}
