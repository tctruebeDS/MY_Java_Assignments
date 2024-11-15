package Unit05.HW_12;
// Theodore Truebe

// HW12 Part B

import java.util.Scanner;

public class HW12_PartB {
    // double smallest(double x, double y, double z)
    static double x;
    static double y;
    static double z;
    static double sNumber;
// method that compares the 3 doubles to find which one is the smallest
    static double smallest() {
        if (x <= y && x <= z) {
            sNumber = x;
        } else if (y <= x && y <= z) {
            sNumber = y;
        } else {
            sNumber = z;
        }
        return sNumber;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // gets user input

        System.out.print("Enter three doubles: ");
        x = in.nextDouble();
        y = in.nextDouble();
        z = in.nextDouble();
        // runs method smallest()
        smallest();
        // outputs sNumber (smallest number)
        System.out.println("The smallest number is " + sNumber);
        in.close();
    }

}
