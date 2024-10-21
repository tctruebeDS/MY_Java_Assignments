/*
 * Theodore Truebe
 * Advanced Topic 03 challenge problem_02
 */
// 2) Write a program that takes a ten digit telephone number (such as "6036694524") and formats in an easy to read format (such as "(603) 669-4524"). 

import java.util.Scanner;
public class Adv03_Challenge_Problem02{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String number = "";
            while (true) {
                //gets user input in a loop
                System.out.print("Enter a ten digit phone number without any spaces or  'q' to quit: ");
                // does it have a q or Q? If so, stop the program
                if (in.hasNext("q") || in.hasNext("Q")) {
                    in.next();
                    break;
                } else {
                        number = in.nextLine(); 
                }
                
                //finds the area code (The first three numbers)
                String f = "";
                f = number.substring(0,3);
                //finds the next three
                String s = "";
                s = number.substring(3,6);
                //gets last 4
                String t = "";
                t = number.substring(6,10);
                //gives output                

                System.out.println("The formatted number is (" + f + ") " + s + "-" + t + ".");
            }
        in.close();
    }
}