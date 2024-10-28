package Unit_04.Lesson09_Loops.HW09;

/*
 * Theodore Truebe
 * HW09 Part A
 */
import java.util.Scanner;
public class HW09_PartA {
public static void main(String[]args){
Scanner in=new Scanner(System.in);
var running = true;
double testScore= 0;
double testTotal = 0;
double totalTests = 0;
double current = 0;
double otherCurrent = 0;
while (running == true){
    System.out.print("Enter a test score or a negative value to quit: ");
    current = in.nextDouble();
    if (current < 0){
        running = false;
        break;
    } else {
        testScore += current;
    }

    System.out.print("Enter the total number of points that would have been possible in that test: ");
    otherCurrent = in.nextDouble();
    if (otherCurrent < current){
        System.err.print("Error. Unless you got extra credit for something, you did something wrong.");
        running = false;
        break;
    } 
    testTotal += otherCurrent;
    totalTests += 1;
}
double testTotalCalculation = testTotal / totalTests;
double testScoreCalculation = testScore / totalTests;
System.out.println("Your average test grade is " + testTotalCalculation + " out of " + testScoreCalculation + ".");
in.close();
}
}
