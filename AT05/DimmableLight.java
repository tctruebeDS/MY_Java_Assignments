package AT05;

// Theodore Truebe 
// Dimmable light program for AT05 HW
import java.util.Scanner;
public class DimmableLight {
// sets up member variables and member functions
    private boolean state = false;
    private int brightness = 1;
    //makes it so others can view the values
    public boolean getState() {
        return state;
    }
    public void on() {
        state = true;
    }
    public int getBrightness(){
        return brightness;
    }
    public void off() {
        state = false;
    }
    public void up() {
        brightness += 1;
        if (brightness > 10) {
            brightness = 10;
        }
    }
    public void down() {
        brightness -= 1;
        if (brightness < 1) {
            brightness = 1;
        }
    }

     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // makes the program run in the running while loop
        var running = true;

        DimmableLight light = new DimmableLight();
        // makes the 
        String reply;
        while (running==true){
            System.out.print("enter q to quit: ");
            reply = in.next().toLowerCase();

            if(reply.equals("q")| reply.equals("quit")){
                running = false;
            } else if (reply.equals("view")){
                // print current state
                System.out.println("state = " + light.getState());
                System.out.println("Brightness = " + light.getBrightness());
            } else if (reply.equals("up")){
                light.up();
            } else if (reply.equals("down")){
                light.down();
            } else if (reply.equals("on")){
                light.on();            
            } else if (reply.equals("off")){
                light.off();
            } else {
                System.err.println("error.");
                running=false;
            }
            
        }
        in.close();
    }    
}