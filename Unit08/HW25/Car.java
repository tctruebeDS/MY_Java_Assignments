// Theodore Truebe
// HW 25

public class Car {
    // Private member variable
    private double speed;

    // Constructor sets default speed to 0
    public Car() {
        speed = 0.0;
    }
    // Overloaded constructor to set the speed 
    public Car(double speed) {
        this.speed = speed;
    }
    // Returns the speed
    public double getSpeed() {
        return speed;
    }
    // Decreases speed by .1 mph if the speed is greater than .1
    public void brake() {
        if (speed > 0.1) {
            speed -= 0.1;
        }
    }

    // Increases speed by 1 mph if the speed is less than the max speed of the car
    public void accelerate() {
        if (speed < 120) {
            speed += 1;
        }

    }

    public static void main(String[] args) {
        //Creates car with overloaded constructor so it starts at 10 mph
        Car car = new Car(10);
        // Demonstrates accelerate
        car.accelerate();
        System.out.println("The current speed is "+ car.getSpeed() + " mph");
        // Demonstrates braking
        car.brake();
        System.out.println("The current speed is "+ car.getSpeed() + " mph");

    }
}
