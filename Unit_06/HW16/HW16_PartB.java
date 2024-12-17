package HW16;

// Theodore Truebe
// HW16 Part B
import java.util.Scanner;

public class HW16_PartB {
    public static int index;
    public static double finalAverage;

    public static double average(double[] values) {
        int n = 0;
        double total = 0;

        while (n < index) {
            total = total + values[n];
            n++;

        }
        finalAverage = total / index;
        return finalAverage;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean running = true;

        double[] values = new double[10];
        while (running == true) {
            System.out.print("Enter a number or 'Q' to quit: ");

            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();

                break;
            }

            if (index < values.length) {
                double g = in.nextDouble();
                values[index] = g;
                index++;

            } else {
                System.out.println("Array is full. Done with input!");
                break;
            }

        }
        // Outputs array
        for (int i = 0; i < index; i++) {
            System.out.println("-----------------------------------------");
            System.out.printf("Value #%03d: %8.2f%n", i + 1, values[i]);

        }
        System.out.println("-----------------------------------------");
        average(values);
        double avg = finalAverage;
        System.out.println("Average = " + avg);
        in.close();
    }
}
