// 1. Abstract superclass: Vehicle
 abstract class Vehicle {
    private String color;
    private String dateMade;

    public Vehicle(String color, String dateMade) {
        this.color = color;
        this.dateMade = dateMade;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getDateMade() { return dateMade; }
    public void setDateMade(String dateMade) { this.dateMade = dateMade; }
    public abstract void steer();
}

// 2. Interface: Drivable
 interface Drivable {
    String howToDrive();
}

// 3. Concrete subclass: Car
 class Car extends Vehicle implements Drivable, Comparable<Car> {
    private String model;
    private int speed;

    public Car(String color, String dateMade, String model, int speed) {
        super(color, dateMade);
        this.model = model;
        this.speed = speed;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    @Override
    public void steer() {
        System.out.println("Turn steering wheel.");
    }

    @Override
    public String howToDrive() {
        return "Step on gas pedal.";
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.speed, other.speed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return model.equals(car.model);
    }
}

// 4. Test Program
public class TestVehicle {
    public static void main(String[] args) {
        Car car1 = new Car("Red", "2023-01-01", "ModelX", 220);
        Car car2 = new Car("Blue", "2023-01-01", "ModelY", 180);

        car1.steer();
        System.out.println(car1.howToDrive());
        System.out.println(car1.compareTo(car2) > 0 ? "Car1 is faster" : "Car2 is faster");
        System.out.println(car1.equals(car2) ? "Cars are equal" : "Cars are not equal");
    }
}
