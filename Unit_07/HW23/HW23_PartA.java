
// Theodore Truebe
// HW 23 Part A
import java.util.Scanner;

public class HW23_PartA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int score = getQuizScore(in);
            System.out.println("score = " + score);
        } catch (Exception e) {
            System.err.println("an error occurred!");
            System.out.println(e.getMessage());
        }

    }

    public static int getQuizScore(Scanner in) {
        System.out.print("Tell me your score: ");
        int score = in.nextInt();
        if (score <= 0 || score > 100) {
            // Makes object
            throw new ArithmeticException("Score must be between 0 and 100.");
        } else {
            // Returns score if the exception does not occur
            return score;
        }
    }
}
