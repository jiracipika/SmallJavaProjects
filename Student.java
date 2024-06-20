public class Student extends Person {
    private double average = 0.0;

    public Student(int id, String name) {
        super(id, name);
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return String.format("Student[id=%d, name=%s, GPA=%.2f%%]", getId(), getName(), average);
    }
}
