/*
 * Theodore Truebe
 * HW08 Part A
 */
package Unit_04.HW_08;
import java.util.Scanner;
public class HW_08_PartA{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //defines the starting values
        double percentage = 100.00;
        int years = 0; 
        // makes the while loop occur while the percentage is greater than 1
        while (percentage > 1){
            //makes 30 years pass and the total percentage gets divided by 2
            percentage = percentage / 2.0;
            years += 30;
        }
        // outputs the final values
        System.out.println(years + " years have passed and " + percentage + "% of the material is left.");
        in.close();
    }
}