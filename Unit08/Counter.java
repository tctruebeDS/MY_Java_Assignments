import java.util.Scanner;

public class Counter {
    // Constructer- can tell because it does not have a return type
    // Initialize count to 0
    public Counter(){
        this.register = MIN_COUNT;
    }

    // Overloaded constructor that takes initial value of count;
    public Counter (int register){
        this.register = register;
    }
    // Public interface
    public int look() {
        return register;
    }

    public void click() {
        if (register == MAX_COUNT){
            reset();
        } else{
            register ++;
        }
        
    }

    public void reset() {
        register = MIN_COUNT;
    }

    // Private member variables used to model the state of the object
    private int register;
    private final int MAX_COUNT = 9999;
    private final int MIN_COUNT = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        String input = "";
        Counter c = new Counter(666);

        while (running == true) {
            System.out.print("Enter c to click, l to look, or r to reset: "); 
            input = in.next();
            if (input.equalsIgnoreCase("c")){
                c.click();
            } else if (input.equalsIgnoreCase("l")){
                c.look();
                System.out.println(c.register);
            } else if (input.equalsIgnoreCase("r")){
                c.reset();
            } else {
                System.err.println("Error.");
            }

        }
        
    }
}
