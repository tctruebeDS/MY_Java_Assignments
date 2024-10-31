package Unit_04.HW_10;


/*
 * Theodore Truebe
 * HW 10 Part D
 */
 /*
* ....1
* ...22
* ..333
* .4444
* 55555
*/
import java.util.Scanner;
public class HW10_PartD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //defines variables
        int i = 0;
        int x = 0;
        //makes the loop for printing the numbers and the '.'s
        for (int b = 0; b < 5; b ++){
            i += 1;
            //makes the loop for printing the '.'s
            for (int y = i; y < 5; y ++){
                System.out.print(".");
                
            }
            x+=1;
            for (int g = x; g > 0; g--){
            System.out.printf("%d",x);
            }
            System.out.printf("%n");
        }
        in.close();
    }
}
