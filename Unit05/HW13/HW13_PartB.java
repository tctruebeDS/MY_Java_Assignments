package Unit05.HW13;
// Theodore Truebe
// Unit 05 HW 13 Part B
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class HW13_PartB {
    /*
     * Change the following method to customize
     * what is drawn in the JFrame.
     */
    static int xVal;
    static int yVal;
    static boolean b = true;

    // makes a helper method to swap the colors
    public static void swapColor(Graphics g) {
        if (b == true) {
            g.setColor(Color.RED);
            b = false;
        } else {
            g.setColor(Color.BLUE);
            b = true;
        }
    }

    // makes the method to draw the grid
    public static void draw(Graphics g) {
        // sets up the numbers that keep track of how many times it has been run
        int y = 0;
        int x = 0;
        g.setColor(Color.BLUE);
        while (y < 4) {
            // makes it so the xVal and the yVal are directly linked to the counter
            xVal = x * 100;
            yVal = y * 100;
            // draws the square
            g.fillRect(xVal, yVal, 100, 100);
            // swaps color for the next square
            swapColor(g);
            // makes it so if the last sqare was the 4th one in the row, it goes to the next
            // row
            if (x == 4) {
                x = 0;
                y++;
            } else {
                x++;
            }

        }
    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }

    // Do not modify the code in the main method.
    // Your code will go into the draw method above.
    public static void main(String[] args) {
        // this is the desired dimensions of the content area
        // of our JFrame window.
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }

}
