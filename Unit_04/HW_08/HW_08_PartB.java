/*
 * Theodore Truebe
 * HW08 PartB
 */

package Unit_04.HW_08;

import java.util.Scanner;

public class HW_08_PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // gets user input
        System.out.println("Enter the APR as a percentage (for example, 5.5) :");
        double apr = in.nextDouble();
        System.out.println("Enter the balance: ");
        double balance = in.nextDouble();
        apr = apr/100;
        //gets the initial numbers
        double earned = apr * balance;
        double newBalance =balance + earned;
        //output
        //origional table setup
        System.out.println("Year |        Int Earned ($)       |           Balance ($)");
        System.out.println("---------------------------------------------------------------------");
        //outputs the 5 years and does further math
        for (int i = 1; i < 6; i += 1) {
            System.out.printf("  %d  |           %.2f              |              %.2f    %n", i, earned, newBalance);
            earned = newBalance * apr;
            newBalance = earned + newBalance;
        }
        in.close();
    }
}
