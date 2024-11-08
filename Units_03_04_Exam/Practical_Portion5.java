package Units_03_04_Exam;

// Theodore Truebe
// Practical Portion Number 5
public class Practical_Portion5 {
    public static void main(String[] args) {
        // defines the double total
        double total = 0;
        // sets up the loop that adds up all of the numbers from 1 to 100
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        // averages the total from the loop
        total = total / 100;
        // outputs the average
        System.out.println("The average of all of the integers from 1 to 100 (inclusive) is " + total + ".");
    }
}