package HW16;

import java.util.Scanner;
// Theodore Truebe 
// HW16 Part A
public class HW16_PartA {
    public static void dropScores(double[] scores) {
        double mostLowest = Double.MAX_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (mostLowest > scores[i]) {
                mostLowest = scores[i];
            }
        }
        Boolean removed = false;
        for (int i = 0; i < scores.length;) {

            if (mostLowest == scores[i] && removed == false) {
                scores[i] = scores[i + 1];
                removed = true;
                for (int y = i; y < scores.length - 1;) {
                    scores[y] = scores[y + 1];
                    y++;
                }
            }

            i++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] scores = new double[10];
        int index = 0;
        Boolean running = true;
        // Hoo cares?
        // Gets user input for scores
        while (running == true) {
            System.out.print("Enter a score or 'Q' to quit: ");

            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();

                break;
            }

            if (index < scores.length) {
                double g = in.nextDouble();
                scores[index] = g;
                index++;

            } else {
                System.out.println("Array is full. Done with input!");
                break;
            }

        }
        // Outputs array
        for (int i = 0; i < index; i++) {
            System.out.println("-----------------------------------------");
            System.out.printf("Quiz score #%03d: %8.2f%n", i + 1, scores[i]);

        }
        System.out.println("-----------------------------------------");

        // Gets user input- does user want lowest score removed?
        running = true;
        boolean wasRemoved = false;
        while (running == true) {
            System.out.println("Would you like to drop the lowest score? (Y/N)");
            if (in.hasNext("Y") || in.hasNext("y")) {

                dropScores(scores);
                wasRemoved = true;
                running = false;
                break;

            } else if (in.hasNext("N") || in.hasNext("n")) {

                break;

            } else {
                System.out.println("Error. Please input Y/N.");
                in.next();
            }
        }
        // Re-outputs array if user removed the lowest score
        if (wasRemoved == true) {
            for (int i = 0; i < index - 1; i++) {
                System.out.println("-----------------------------------------");
                System.out.printf("Quiz score #%03d: %8.2f%n", i + 1, scores[i]);

            }
            System.out.println("-----------------------------------------");
            in.close();
        } 
    }
}
