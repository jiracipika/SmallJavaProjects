public class TestSchool {
    public static void main(String[] args) {
        // (a) Create 7 students
        Student[] students = new Student[]{
                new Student(1, "Blake"),
                new Student(2, "DeNice"),
                new Student(3, "AAron"),
                new Student(4, "Daisy"),
                new Student(5, "Ethan"),
                new Student(6, "Fiona"),
                new Student(7, "Daniel") 
        };

        for (Student student : students) {
            System.out.println(student);
        }

        // (b) Set the student's averages to random values you like and print them
        for (Student student : students) {
            double randomAverage = Math.random() * 101;
            student.setAverage(randomAverage);
            System.out.println(student);
        }

        // (c) Create an instructor
        Instructor instructor = new Instructor(8, "Dr. OG", "Real Sciencce");
        System.out.println(instructor);

        // (d) Create two courses
        Course course1 = new Course("SCIN1123", "Introduction to The real world");
        Course course2 = new Course("SCINC5555", "Advanced Science for Dummies");

        // (e) Assign the instructor to both courses
        course1.setInstructor(instructor);
        course2.setInstructor(instructor);
        
        System.out.println(course1);
        System.out.println(course2);

        // (f) Assign 5 of the 7 students to the first course and the other 2 to the second
        for (int i = 0; i < 5; i++) {
            course1.enroll(students[i]);
        }
        course2.enroll(students[5]);
        course2.enroll(students[6]);

        System.out.println(course1);
        System.out.println(course2);

        // (g) Assign all students grades
        for (Student student : students) {
            double grade = Math.random() * 101;
            student.setAverage(grade);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        // (h) Unenroll two students from the first course
        course1.unenroll(students[2]); // Unenroll Bob
        course1.unenroll(students[5]); // Unenroll Ethan

        // Print the course after unenrolling students
        System.out.println(course1);
    }
}
