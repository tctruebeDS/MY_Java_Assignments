
/*
 * Theodore Truebe
 * Advanced Topic 03 challenge problem 01
 */
/* 1) Write a computer program that does the following,
*Prompts the user for a price in dollar and cents format (for example 21.74 represents twenty one dollars and 74 cents).
*Calculates how many dollars and cents the user has (for example, 21 dollars and 74 cents).
*Displays this information to the user in an easy to understand format.
 */
//WORD OF ADVICE: DON'T RUN ABNORMALLY LARGE NUMBERS. IT TAKES A LONG TIME. 
import java.util.Scanner;

public class Adv03_Challenge_Problem_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double price = 0.00;
        //gets user input

        //makes it so multiple numbers can be run without having to restart the program
        while (true) {
                System.out.print("Enter the price in dollars and cents format (For example, 21.74 represents twenty one dollars and 74 cents) or 'q' to quit: ");
                // does it have a q or Q? If so, stop the program
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    break;
                } else {
                    if (in.hasNextDouble()) {
                        price = in.nextDouble();
                    }
                }
            // does the maths
            int dollars = 0;
            int cents = 0;
            //Figures out how many dollars are there
            while (price >= 1){
                price -= 1;
                dollars += 1;
            }
            //figures out how many cents are there
            while (price > .001){
                price -= .01;
                cents += 1;
            }
            //OUTPUT
            if (dollars > 0 && cents > 0){ //when there are dollars and cents
                System.out.println("You have " + dollars + " dollars and " + cents + " cents.");
            } else if (dollars > 0){ // when there are just dollars
                System.out.println("You have " + dollars + " dollars.");
            } else { // when there are just cents
                System.out.println("You have " + cents + " cents.");
            }
        }
        in.close();
        
        }
    }