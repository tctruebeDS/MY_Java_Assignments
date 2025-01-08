// Theodore Truebe
// HW 19 Part B
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HW19_PartB {
    public static void main(String[] args) throws FileNotFoundException {
        // Gets input file
        File inputFile = new File("quizzes.txt");
        Scanner in = new Scanner(inputFile);
        // Creates output file
        File outputFile = new File("quizzesMod.txt");
        PrintWriter out = new PrintWriter(outputFile);
        double total = 0;
        int numOfValues = 0;
        double score = 0;
        // outputs properly outputted quiz scores to new file
        while (in.hasNextDouble()) {
            score = in.nextDouble();
            out.printf("Quiz %03d: %6.2f%n", numOfValues, score);
            total += score;
            numOfValues += 1;
        }
        double average = total / numOfValues;
        // Outputs formatted average to new file
        out.printf("------------------%nAverage:   %.2f", average);
        in.close();
        out.close();
    }
}
