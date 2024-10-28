package Unit_04.Lesson09_Loops.HW09;

/*
 * Theodore Truebe
 * HW 08 Part B
 */
import java.util.Scanner;
public class HW09_PartB {
public static void main(String[]args){Scanner in=new Scanner(System.in);
// gets user input and asks for a string
System.out.println("Enter a string that has 'e's that need to be counted: ");
String s = in.nextLine();
int length = s.length();
int i = 0;
int total = 0;
// sets up the loop of counting 'e's
while (i < length){
    char result = s.charAt(i);
    if (result == 'e'){
        total += 1;
    }
    i += 1;

}
// outputs the number of 'e's
System.out.println("Your string had a total of " + total+ " 'e's. ");
in.close();
}    
}