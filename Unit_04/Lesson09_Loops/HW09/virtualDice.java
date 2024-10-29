package Unit_04.Lesson09_Loops.HW09;

/*
 * Theodore Truebe
 * HW09 Part D
 */
import java.util.Scanner;
import java.util.Random;
// sets up member variables and member functions
// POSSIBLE WAYS TO INTERACT WITH THE DICE: make it stop rolling, look at it, roll it 
public class virtualDice {

private boolean state;
private boolean view = false;
public void roll() {
    state = true;
} 
public void stopRolling() {
    state = false;
}
public boolean getState(){
    return state;
}
public void display(){
    view = true;
}
public void stopDisplay(){
    view = false;
}
public static void main(String[]args){
Scanner in=new Scanner(System.in);
Random rand = new Random();
var running = true;
// gets user input
virtualDice dice = new virtualDice();
String input = " ";
int r = 0;
String output = " ";
while (running == true){
    System.out.println("Type 'r' to roll, 'd' to display the roll, or 'q' to quit: ");
    input = in.nextLine();
    input.toLowerCase();
    if (input.equals("q") || input.equals("quit")){
        running = false;
        break;
    } else if (input.equals("r")) {
        dice.roll();
        r = rand.nextInt(1,7);
        dice.stopRolling();
    } else if (input.equals("d")) {
        dice.display();
    }
    // matches dice images to numbers
    if (r == 1){
        output = "+-------+%n|       |%n|   0   |%n|       |%n+-------+%n";
    } else if (r == 2){
        output = "+-------+%n| 0     |%n|       |%n|     0 |%n+-------+%n";
    } else if (r == 3){
        output = "+-------+%n|     0 |%n|   0   |%n| 0     |%n+-------+%n";
    } else if (r == 4){
        output = "+-------+%n| 0   0 |%n|       |%n| 0   0 |%n+-------+%n";
    } else if (r == 5){
        output = "+-------+%n| 0   0 |%n|   0   |%n| 0   0 |%n+-------+%n";
    } else if (r == 6){
        output = "+-------+%n| 0   0 |%n| 0   0 |%n| 0   0 |%n+-------+%n";
    }
    // outputs the image
    if (dice.view == true){
        System.out.printf(output);
        dice.stopDisplay();
    } 
}
in.close();}

    
}
