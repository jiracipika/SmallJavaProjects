public class Course {
    private final int MAX_ENROLLED_STUDENTS = 5;
    private Student[] students = new Student[MAX_ENROLLED_STUDENTS];
    private int enrollment = 0;
    private Instructor instructor;
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public boolean enroll(Student student) {
        if (enrollment < MAX_ENROLLED_STUDENTS) {
            students[enrollment++] = student;
            return true;
        }
        return false;
    }

    public boolean unenroll(Student student) {
        for (int i = 0; i < enrollment; i++) {
            if (students[i].equals(student)) {
                System.arraycopy(students, i + 1, students, i, enrollment - i - 1);
                students[--enrollment] = null;
                return true;
            }
        }
        return false;
    }

    public void assignGrade(Student student, double grade) {
        student.setAverage((student.getAverage() + grade) / 2);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return String.format("Course[code=%s, name=%s, instructor=%s, enrolled=%d]", courseCode, courseName,
                instructor != null ? instructor.getName() : "No instructor", enrollment);
    }
}
