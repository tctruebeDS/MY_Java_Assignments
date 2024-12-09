package HW15;

import java.util.Scanner;
import java.util.Arrays;
// Theodore Truebe
// HW 15 Part A
public class HW15_PartA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[10];
        int index = 0;
        Boolean running = true;
        while (running == true) {
            System.out.print("Enter a number or 'Q' to quit: ");

            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();

                break;
            }

            if (index < values.length) {
                int g = in.nextInt();
                values[index] = g;
                index++;
                // Stops user if array is full
            } else {
                System.out.println("Array is full. Done with input!");
                break;
            }

        }
        // Prints the old array
        for (int i = 0; i < index; i++) {
            
            System.out.printf("*%d",values[i]);

        }
        System.out.print("*");
        System.out.println();
        // Sorts array
        int currentSize = index;
        Arrays.sort(values, 0, currentSize);
        // Reverses array order- first nr was swapped with last one and so on
        for(int y = 0; y < currentSize/2; y++){
            int t = values[y];
            values[y] = values[currentSize -1 -y];
            values[currentSize -1 -y]= t;
        }
        // prints reversed array
        for (int g = 0; g < index; g++) {

            System.out.printf("%d,", values[g]);

        }
        

        in.close();
    }
}
