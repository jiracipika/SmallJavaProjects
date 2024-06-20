public class TestStudent {
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

