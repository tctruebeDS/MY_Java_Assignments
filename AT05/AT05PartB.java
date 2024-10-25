package AT05;
/*
 * Theodore Truebe
 * HW AT05 Part B
 */
import java.util.Scanner;

class Light {
    // track the state of the light.
    // true means the light is on.
    // false means the light is off.
    boolean state = false;

    // this method returns true if the light is on.
    public boolean view() {
        return state;
    }

    // turn on light.
    public void turnOn() {
        state = true;
    }

    // turn off light.
    public void turnOff() {
        state = false;
    }
}

public class AT05PartB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var running = true;
        int lightBright = 0; 
        while (running==true){
            System.out.println("enter q to quit");

            Light light = new Light();
            if(in.hasNext("q")| in.hasNext("Q")){
                running = false;
            } else if (in.hasNext("view")){
                // print current state.
                if (lightBright != 0) {
                    System.out.print(lightBright);
                }
                System.out.println("state = " + light.view());
            } else if (in.hasNextInt()){
                lightBright=in.nextInt();
            } else if (in.hasNext("up")&& lightBright <11){
                lightBright +=1;
            } else if (in.hasNext("down")&& lightBright > 1){
                lightBright-=1;
            } else if (in.hasNext("on")){
                light.turnOn();            
            } else if (in.hasNext("off")){
                light.turnOff();
            } else {
                System.err.println("error.");
                running=false;
            }
            // create a light object.

            // turn on the light.


            // print current state.


            // turn off the light.
            
            in.close();
        }
    }    
}
