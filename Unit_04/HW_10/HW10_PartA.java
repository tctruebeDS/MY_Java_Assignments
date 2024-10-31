package Unit_04.HW_10;
/*
 * Theodore Truebe
 * HW 10 Part A
 */
import java.util.Scanner;
public class HW10_PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        String name = "Harry";
        System.out.println("The last letter of the name is " +
        //had a runtime error, the length of string name is 5 but the index starts at 0 and goes to 4. 
        //This makes it try to print the character at 5, but there is nothing there
                name.charAt(name.length()-1));
        

        in.close();
    }
}
