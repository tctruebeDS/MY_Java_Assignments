package Unit05.HW_12;
// Theodore Truebe
// HW12 Part A
import java.util.Scanner;
public class Conversation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is your first name? ");
        String input = in.next();
        System.out.println("Hello, " + input);
        System.out.print("How old are you? ");
        //Input is being defined twice, must create a new input 
        int nextInput = in.nextInt();
        nextInput++;
        System.out.println("Next year, you will be " + nextInput);
        in.close();
    }
}
