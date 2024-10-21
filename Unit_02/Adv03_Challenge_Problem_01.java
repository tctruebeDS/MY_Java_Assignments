
/*
 * Theodore Truebe
 * Advanced Topic 03 challenge problem 01
 */
/* 1) Write a computer program that does the following,
*Prompts the user for a price in dollar and cents format (for example 21.74 represents twenty one dollars and 74 cents).
*Calculates how many dollars and cents the user has (for example, 21 dollars and 74 cents).
*Displays this information to the user in an easy to understand format.
 */
import java.util.Scanner;

public class Adv03_Challenge_Problem_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the price in dollars and cents format (For example, 21.74 represents twenty one dollars and 74 cents) :");
        double price = in.nextDouble();
        int dollars = 0;
        while (price > 1){
            price -= 1;
            
        }
        in.close();
    }
}