package Unit05;

import java.util.Scanner;

// sets up member variables and member functions
// POSSIBLE WAYS TO INTERACT WITH THE DICE: make it stop rolling, look at it,
// roll it
// makes roll method that finds out which of the rollNumber methods it should
// call

    

    // public void display
    /*
     * public void roll() {
     * if (randomNotSet == true) {
     * random();
     * 
     * } else {
     * 
     * if (set == 1) {
     * value = 1;
     * } else if (set == 2) {
     * value = 2;
     * } else if (set == 3) {
     * value = 3;
     * } else if (set == 4) {
     * value = 4;
     * } else if (set == 5) {
     * value = 5;
     * } else if (set == 6) {
     * value = 6;
     * }
     * randomNotSet = true;
     * }
     * if (value == 1) {
     * rollNumberOne();
     * } else if (value == 2) {
     * rollNumberTwo();
     * } else if (value == 3) {
     * rollNumberThree();
     * } else if (value == 4) {
     * rollNumberFour();
     * } else if (value == 5) {
     * rollNumberFive();
     * } else if (value == 6) {
     * rollNumberSix();
     * }
     * 
     * }
     * }
     */

 

public class Die {   
    private int value;

    public Die() {
        value = 1;
    }

    public Die(int newVal) {
        if (newVal >= 1 && newVal <= 6) {
            value = newVal;
        }
    }

    public void roll() {
        int random = (int) (Math.random() * 6) + 1;
        value = random;
    }
    public void display() {
        System.out.println(value);
    }


    // public static int random = 1;
    // private static String output;
    // public static int set = 0;
    // static boolean randomNotSet = true;

    // private static void rollNumberOne() {
    //     output = "+-------+%n|       |%n|   0   |%n|       |%n+-------+%n";
    // }

    // private static void rollNumberTwo() {
    //     output = "+-------+%n| 0     |%n|       |%n|     0 |%n+-------+%n";
    // }

    // private static void rollNumberThree() {
    //     output = "+-------+%n|     0 |%n|   0   |%n| 0     |%n+-------+%n";
    // }

    // private static void rollNumberFour() {
    //     output = "+-------+%n| 0   0 |%n|       |%n| 0   0 |%n+-------+%n";
    // }

    // private static void rollNumberFive() {
    //     output = "+-------+%n| 0   0 |%n|   0   |%n| 0   0 |%n+-------+%n";
    // }

    // private static void rollNumberSix() {
    //     output = "+-------+%n| 0   0 |%n| 0   0 |%n| 0   0 |%n+-------+%n";
    // }
    // // makes random method to generate the value of the die

    
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Die die = new Die(6);
        // makes the loop run
        boolean running = true;
        while (running == true) {
                // Finds out what the user wants to do
            System.out.print("Type 'r' to roll or 'q' to quit: ");
            String input = in.nextLine();
            input.toLowerCase();
                // Stops running if the user types q or quit
            if (input.equals("q") || input.equals("quit")) {
                running = false;
                // Rolls the die if the user types r
            } else if (input.equals("r")) {
                // calls formerly defined die
                die.roll();
                // outputs the roll
                die.display();
                // hidden function with which one can set the value of the dice
            /*} else if (input.equals("set")) {
                System.out.print("Enter the value you like the dice value to be (1-6): ");
                set = in.nextInt();
                randomNotSet = false;
                //makes it look like the dice was not set by outputting the last roll as well as the standard prompt
                display();
                System.out.println("Type 'r' to roll or 'q' to quit: r");
                die.roll();
                // displays the set die
                display();
                set = 0;
                
            }*/
        }
        
    }
    in.close();
}
}
