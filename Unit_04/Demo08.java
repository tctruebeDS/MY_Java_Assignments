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
        while (x!=6){
            System.out.println("The number is " + x);
            x+=1;
        }
        in.close();
    }
}
