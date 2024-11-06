package Unit05.HW_11;


/*
 * Theodore Truebe
 * HW 11 Part C
 */
import java.util.Scanner;

public class HW11_PartC {
    public static double getVolume(double radius){
        //does the math
        double volume = (radius * radius * radius) * (4.0 / 3.0) * Math.PI;
        return volume;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //gets user input
        System.out.print("Enter a radius: ");
        double radius = in.nextDouble();
        //formatted output so it only goes to 2 decimal spaces
        System.out.printf("The volume of your sphere with a radius of %.2f is %.2f",radius, getVolume(radius));
        in.close();
    }
}