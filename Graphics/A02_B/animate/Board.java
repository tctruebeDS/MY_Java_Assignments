// Theodore Truebe 
// HW A02 Part B
package A02_B.animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    private final int SIDE_LEN = 100;

    private int x = 0;
    private int y = 0;
    private final int DIAMETER = 20;
    
    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int xSpeed = 2;

    /*
     * Constructor
     */
    public Board() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // set the initial position of the ball
        // to be on the left side of the content area
        // and in the middle of the content area.
        x = 0;
        y = B_HEIGHT / 2;

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    /*
     * Override the paintComponent() method.
     */
    public void paintComponent(Graphics g) {
        // call parent class' method
        super.paintComponent(g);
        // cast to Graphics2D and then create affine transform.
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform affineTransform = new AffineTransform();

        affineTransform.translate(x - DIAMETER / 2, y - DIAMETER / 2);
        // draw a filled ellipse using transformed location.
        Ellipse2D ellipse = new Ellipse2D.Double(0, 0, DIAMETER, DIAMETER);
        Shape transformedShape = affineTransform.createTransformedShape(ellipse);
        g2d.setColor(Color.MAGENTA);
        g2d.fill(transformedShape);
    }

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        public void run() {
            x += xSpeed;
            if (x > B_WIDTH) {
                x = 0;
            }
            repaint();
        }
    }
    public static void main(String[] args) {
        /*
         * In Java, GUI related actions should be
         * performed in the AWT event thread
         * or it could cause severe problems with the GUI.
         * EventQueue.invokeLater() posts your GUI-related
         * actions in the AWT event queue to avoid causing
         * any problems with other GUI-related actions.
         */
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("Not-A-Title");
            myApp.setVisible(true);
        });
    }
}
