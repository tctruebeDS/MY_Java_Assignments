package Bicycle_Demo;

public class OverrideDemo {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        System.out.println("Bike speed = " + b.getSpeed());
        
        // Pedal the bike
        b.pedal();
        System.out.println("Bike speed = " + b.getSpeed());


    }
}
