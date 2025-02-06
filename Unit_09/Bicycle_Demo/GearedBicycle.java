package Bicycle_Demo;
// Theodore Truebe

// HW 29 Part A

public class GearedBicycle extends Bicycle {
    // Private member variables
    private int gear;
    private final int MAX_GEARS = 6;
    private final int GEARED_MAX_SPEED = 50;

    public GearedBicycle() {
        // first invoke the parent's constructor.
        super();

        // then initialize the child's member variables.
        gear = 1;
    }

    // Returns the gear
    public int getGear() {
        return gear;
    }
    // Sets the gear to a new number
    public void setGear(int gear) {
        if (gear > 0 && gear <= MAX_GEARS) {
            this.gear = gear;
        }
    }

    // Increases the gear by 1
    public void shiftUp() {
        gear += 1;
        if (gear == MAX_GEARS) {
            gear = MAX_GEARS;
        }
    }

    // Lowers the gear by 1
    public void shiftDown() {
        gear -= 1;
        if (gear < 1) {
            gear = 1;
        }
    }

    // Constructor that uses super and a print statement to print the gear and the
    // speed from the parent class
    public void display() {
        System.out.printf("Gear = %02d %n", getGear());
        super.display();

    }
    // Braking is 2 times better on geared bicycles
    // Overriden brake method for geared bicycles

    public void brake() {
        super.brake();
        super.brake();
    }

    /*
     * Override pedal() method
     * to account for the gears when accelerating the speed
     * of the bicycle.
     */
    public void pedal() {
        int newSpeed = getSpeed() + getGear();
        if (newSpeed > GEARED_MAX_SPEED) {
            newSpeed = GEARED_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    // Method so I don't have to type as much for multiple pedals
    public void pedalMultipleTimes(int manyPedals) {
        for (int i = 0; i < manyPedals; i++) {
            pedal();
        }
    }

    public static void main(String[] args) {
        GearedBicycle g = new GearedBicycle();
        g.setGear(3);
        g.setSpeed(5);
        g.brake();
        g.display();
        Bicycle b = new Bicycle();
        b.setSpeed(5);
        b.brake();
        b.display();

    }
}