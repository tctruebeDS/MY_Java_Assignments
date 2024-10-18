/*
 * Theodore Truebe
 * Loops demo
 */
package Unit_04;
import java.util.Scanner;
public class Demo08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //loops printing out a number until the number is 5
        int x = 1;
        while (x < 6){
            System.out.println("The number is " + x);
            x += 1;
        }
        //Infinite loop (Would be infinite without the if statement)
        int i = 1;
        while (i>0){
            System.out.println(i);
            i+=1;
            // stops it at 1,000 so I don't destroy my computer
            if (i > 1000){
                i = 0;
            }
        }
        @SuppressWarnings("unused")
        double total = 0.0;
        while (true) {
            System.out.println("Enter a number or 'q' to quit: ");
            //does it have a q or Q?
            if (in.hasNext("q")|| in.hasNext("Q")){
                in.next();
                break;
            } else {
                if (in.hasNextDouble()){
                    total += in.nextDouble();
                }
            }
        }
        // for loop
        //scope of a var is the visibility of that var in the program (if I want to make it visible I should declare it outside the {}s )
        for (int z = 1; i <6; i++){
            System.out.println("Z is equal to " + z);
            z +=1;

        }
        in.close();
    }
}
