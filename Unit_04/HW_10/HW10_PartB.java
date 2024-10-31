package Unit_04.HW_10;
/*
 * Theodore Truebe
 * HW 10 Part B
 */
import java.util.Scanner;
public class HW10_PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int num = in.nextInt();
        double discount = 0;
        //was a runtime error, the discount was not defined if the if statement was not true
        if (num > 6) {
            discount = 0.05;
        } else if (num > 12) {
            discount = 0.10;
        }
        System.out.println("Discount = " + discount);
        in.close();
    }
}
