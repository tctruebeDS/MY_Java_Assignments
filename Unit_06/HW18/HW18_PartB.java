package HW18;
// Theodore Truebe
// HW 18 Part B
import java.util.Scanner;
import java.util.ArrayList;
public class HW18_PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<Double>();
        boolean running = true;
        while (running) {
            System.out.println("Enter a score or 'q' to quit: ");
            // Stops if user inputs q
            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();
                running = false;
                break;
            } else {
                // adds scores that user inputs
                scores.add(in.nextDouble());
            }
        }
        // Prints scores with line in between
        int i = 0;
        double total = 0;
        for (Double score: scores) {

            double x = scores.get(i);
            System.out.printf("%.2f%n", x);
            total += x;
            i++;
        }
        System.out.printf("The average score is: %.2f",total/scores.size());
        in.close();
    }
}
