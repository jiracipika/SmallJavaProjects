import java.util.Date;

public class Student {
    private int studentNumber;
    private String major;
    private String firstName;
    private String lastName;
    private int credits = 0;
    private Date dateCreated;
    private String[] courses = new String[5];

    // Constructor
    public Student(String firstName, String lastName, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.dateCreated = new Date();
    }

    // Method to enroll a student in a course
    public void enroll(String course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                System.out.println(firstName + " " + lastName + " has been enrolled in " + course + ".");
                return;
            }
        }
        System.out.println("Sorry, " + firstName + " " + lastName + " is already enrolled in 5 courses.");
    }

    // Method to unenroll a student from a course
    public void unenroll(String course) {
        for (int i = 0; i < courses.length; i++) {
            if (course.equals(courses[i])) {
                courses[i] = null;
                System.out.println(firstName + " " + lastName + " has been unenrolled from " + course + ".");
                return;
            }
        }
        System.out.println(course + " is not found in the enrolled courses of " + firstName + " " + lastName + ".");
    }

    // Getter methods (if required later)
    public int getStudentNumber() {
        return studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCredits() {
        return credits;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String[] getCourses() {
        return courses;
    }
}

class TestStudent {
    public static void main(String[] args) {
        // Create a new student
        Student john = new Student("John", "Doe", 12345);
        System.out.println("Student " + john.getFirstName() + " " + john.getLastName() + " has been created.");

        // Enroll the student in 5 courses
        john.enroll("Math101");
        john.enroll("History102");
        john.enroll("Chemistry103");
        john.enroll("Physics104");
        john.enroll("Biology105");

        // Unenroll the student from one course
        john.unenroll("Chemistry103");
    }
}

