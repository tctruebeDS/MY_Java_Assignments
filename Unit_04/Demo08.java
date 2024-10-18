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
            // stops it at 10,000 so I don't destroy my computer
            if (i > 10000){
                i = 0;
            }
        }
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
        in.close();
    }
}
