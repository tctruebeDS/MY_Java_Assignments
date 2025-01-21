
// Theodore Truebe 
// Units 05&06 Exam Part 2
import java.util.Scanner;
import java.util.ArrayList;

public class Units_05_06_ExamPart2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean running = true;
        ArrayList<Double> scores = new ArrayList<>(10);
        double total = 0;
        // Main running loop
        while (running){
            // Gets user input and stops if they enter a q
            System.out.print("Enter a quiz score or 'q' to quit: ");
            if (in.hasNextDouble()) {
                scores.add(in.nextDouble());
            } else if (in.hasNext("q") || in.hasNext("Q")){
                running = false;
                break;
            } else {
                System.err.println("Error.");
            }

        }
        // Output
        System.out.printf("-----------------------%n");
        for (int i = 0; i < scores.size(); i++){
            System.out.printf("%7.2f%n", scores.get(i));
            total += scores.get(i);

        }
        System.out.printf("-----------------------%n");
        System.out.printf("avg = %.2f", total / scores.size());
        in.close();
    }
}