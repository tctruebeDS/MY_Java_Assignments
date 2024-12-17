import java.util.Scanner;

public class testScores {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] scores = new double[100];
        int index = 0;
        Boolean running = true;
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
        for (int i = 0; i < index; i++) {
            System.out.println("-----------------------------------------");
            System.out.printf("Test score #%03d: %8.2f%n", i + 1, scores[i]);

        }
        System.out.println("-----------------------------------------");
        in.close();
    }
}
