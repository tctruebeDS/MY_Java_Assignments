/*
 * Theodore Truebe
 * Advanced Topic 03 challenge problem_02
 */
// 2) Write a program that takes a ten digit telephone number (such as "6036694524") and formats in an easy to read format (such as "(603) 669-4524"). 

import java.util.Scanner;
public class Adv03_Challenge_Problems{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            while (true) {
                //gets user input in a loop
                int number = 0;
                System.out.print("Enter a ten digit phone number without any spaces or  'q' to quit: ");
                // does it have a q or Q? If so, stop the program
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    break;
                } else {
                    if (in.hasNextDouble()) {
                        number = in.nextInt();
                    }
                }
                String s = "";
                //gives output
                System.out.println("The formatted number is " + s + ".");
            }
        in.close();
    }
}