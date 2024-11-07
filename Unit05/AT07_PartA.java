package Unit05;

import java.util.Scanner;

// sets up member variables and member functions
// POSSIBLE WAYS TO INTERACT WITH THE DICE: make it stop rolling, look at it,
// roll it

public class AT07_PartA {
    public static int random = 1;
    private static String output;
    private static int set = 0;

    public static void rollOne() {
        output = "+-------+%n|       |%n|   0   |%n|       |%n+-------+%n";
    }

    public static void rollTwo() {
        output = "+-------+%n| 0     |%n|       |%n|     0 |%n+-------+%n";
    }

    public static void rollThree() {
        output = "+-------+%n|     0 |%n|   0   |%n| 0     |%n+-------+%n";
    }

    public static void rollFour() {
        output = "+-------+%n| 0   0 |%n|       |%n| 0   0 |%n+-------+%n";
    }

    public static void rollFive() {
        output = "+-------+%n| 0   0 |%n|   0   |%n| 0   0 |%n+-------+%n";
    }

    public static void rollSix() {
        output = "+-------+%n| 0   0 |%n| 0   0 |%n| 0   0 |%n+-------+%n";
    }

    private static void random() {
        random = (int) (Math.random() * 6) + 1;

    }

    public static void roll() {
        if (set == 0) {
            random();
            if (random == 1) {
                rollOne();
            } else if (random == 2) {
                rollTwo();
            } else if (random == 3) {
                rollThree();
            } else if (random == 4) {
                rollFour();
            } else if (random == 5) {
                rollFive();
            } else if (random == 6) {
                rollSix();
            }
        } else {
            if (set == 1) {
                rollOne();
            } else if (set == 2) {
                rollTwo();
            } else if (set == 3) {
                rollThree();
            } else if (set == 4) {
                rollFour();
            } else if (set == 5) {
                rollFive();
            } else if (set == 6) {
                rollSix();
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        boolean constantDisplay = false;
        while (running == true) {
            System.out.println(
                    "Type 'r' to roll, 'd' to display the roll, 'ad' to always desplay the roll, or 'q' to quit: ");
            String input = in.nextLine();
            input.toLowerCase();
            if (input.equals("q") || input.equals("quit")) {
                running = false;

            } else if (input.equals("r")) {
                roll();

            } else if (input.equals("d")) {
                System.out.printf(output);
                // hidden function with which one can set the value of the dice
            } else if (input.equals("set")) {
                System.out.print("Enter the value you like the dice value to be (1-6): ");
                set = in.nextInt();
                roll();
            } else if (input.equals("ad")) {
                constantDisplay = true;
            }
            if (constantDisplay == true) {
                System.out.printf(output);
            }
        }
        in.close();
    }
}
