package HW15;

import java.util.Scanner;

// Theodore Truebe
// HW 15 Part B
public class HW15_PartB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[20];
        int index = 0;
        Boolean running = true;
        while (running == true) {
            System.out.print("Enter an integer value or 'q' to quit: ");

            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();

                break;
            }

            if (index < values.length) {
                int g = in.nextInt();
                values[index] = g;
                index++;

            } else {
                System.out.println("Array is full. Done with input!");
                break;
            }

        }
        // Prints array
        for (int i = 0; i < index; i++) {

            System.out.printf("%d", values[i]);
            if (i < index - 1) {
                System.out.print(",");
            }

        }
        System.out.println("");
        System.out.print("Enter a target integer value: ");
        int targetValue = in.nextInt();
        int occurances = 0;
        // checks to see how manty times the target value occurs in the data set
        for (int o = 0; o < index; o++) {
            
            if (targetValue == values[o]) {
                occurances++;
            }
            
        }
        // Outputs occurances
        System.out.println("The value " + targetValue + " occurs " + occurances + " times in your original data set.");
        in.close();
    }
}
