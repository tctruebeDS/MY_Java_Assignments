package Unit_04.Lesson09_Loops;
import java.util.Scanner;

public class Demo09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // do loop
        int value;
        do {
            System.out.print("Enter an integer <100: ");
            value = in.nextInt();
        }
        while (value<= 100);
        //defines the starting values
        double current = 0;
        double total=0;
        do {
            //bad data validation
            System.out.print("Enter multiple dollar amounts or a negative value to quit: ");
            if (in.hasNextDouble()){
                current = in.nextDouble();
            } else {
                System.err.println("Enter double values only.");
                in.next();
            }
            
            // is it negative? If not, add the next dollar amount to the total
            if (current > 0){
                total += current;
            }
        }
        // stops the do loop if the current value is negative
        while (current >= 0);
        //outputs the total value
        System.out.printf("Total spent: $%.2f%n", total);
        // loop in a loop
        //custom multiplication table
        System.out.println("Enter one number to multiply: ");
        int row = in.nextInt();
        System.out.println("Enter another: ");
        int col = in.nextInt();
        int product;
        int start;
        int otherStart;
        for (start = 1; start <= row; start ++) {
            for (otherStart = 1; otherStart <= col; otherStart ++){
                product = start*otherStart;
                System.out.printf("%5d", product);
            }
            System.out.println();
        }
        in.close();
    }
}
