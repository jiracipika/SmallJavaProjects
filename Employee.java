public class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }
    
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + '}';
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 25);
        Employee e2 = new Employee("Jane", 30);
        System.out.println("Test Case 1: " + e1.compareTo(e2));

        e1 = new Employee("John", 30);
        e2 = new Employee("Jane", 30);
        System.out.println("Test Case 2: " + e1.compareTo(e2));
    }
}
