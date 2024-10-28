package Unit_04.Lesson09_Loops.HW09;

/*
 * Theodore Truebe
 * HW 09 Part C
 */
/*
 * Write a program that generates 10 random integers:
Use a loop to iterate through the numbers
Each random integer should range from 1 to 10;
Calculate the average of the 10 numbers.
Change the number of times you loop to 1000 and calculate the average value.
Does the average value make sense? Explain.

 */
import java.util.Scanner;
import java.util.Random;
public class HW09_PartC {
public static void main(String[]args)
{Scanner in=new Scanner(System.in);
    
Random rand = new Random();
int total = 0;
for (int i = 0; i < 10; i+=1){
    int r =rand.nextInt(1000);
    r+=1;
    System.out.println(r);
    total += r;
}
double average = total/10;
System.out.println("Average = " + average);
// average of numbers 1 to 10 was roughly 5
// average of numbers 1 to 1000 was roughly 500, makes sense because 5 and 500 are both in the middle of the total possible range
in.close();}
}
