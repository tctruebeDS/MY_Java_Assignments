package Units_03_04_Exam;
import java.util.Scanner;
// Theodore Truebe
// Practical Portion Number 6
public class Practical_Portion6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // gets user input
        System.out.print("Enter the first of three integers: ");
        int o = in.nextInt();
        System.out.print("Enter the second of three integers: ");
        int s = in.nextInt();
        System.out.print("Enter the last of three integers: "); 
        int t = in.nextInt();
        String numbers = "";
        //checks all combinations to make sure that the biggest number comes first, the smallest number comes second, and the other number comes in the middle
        if (o >= s && o >= t && s >= t){
            numbers += o;
            numbers += s;
            numbers += t;
        } else if (o <= s && o >=t && s >= t){
            numbers += s; 
            numbers += o;
            numbers += t;
        } else if (o <= s && o <=t && s >=t){
            numbers += s;
            numbers += t;
            numbers += o;
        } else if (o <= s && o <=t && s <=t){
            numbers += t;
            numbers += s;
            numbers += o;
        } else if (o >= s && o >= t && t >= s) {
            numbers += o;
            numbers += t;
            numbers += s;
        } else if (o >= s && o <= t && t >= s) {
            numbers += t;
            numbers += o;
            numbers += s;            
        }
        //outputs the numbers in the correct order
        System.out.println(numbers);
        in.close();
    }
}
