// Theodore Truebe 
// 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.random.*;

public class Board extends JPanel implements MouseListener, KeyListener {
    private final int B_WIDTH = 1422;
    private final int B_HEIGHT = 800;
    private final int SIDE_LEN = 100;

    private int x = 100 - 50;
    private int y = B_HEIGHT - 200;

    private final int DIAMETER = 20;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private int rotateInterval = 5;
    private BufferedImage cannon;
    public SoundClip wheelSound = new SoundClip("media/wheel.wav");
    public SoundClip boomSound = new SoundClip("media/boom.wav");
    private int floor = (B_HEIGHT - 25);
    // Stores x and y coordinates of the cannon
    private double xCannon;
    private double yCannon;
    private double cannonRotation;
    Color oddBrown = new Color(253, 174, 174);
    /*
     * Constructor
     */
    public Board() {
        setCannonRotation(-45);
        wheelSound.setLoopFalse();
        wheelSound.open();
        boomSound.open();
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    /*
     * Override the paintComponent() method.
     */
    public void paintComponent(Graphics g) {
        // // call parent class' method
        super.paintComponent(g);

        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        // cast to Graphics2D and then create affine transform.
        Graphics2D g2d = (Graphics2D) g;
        // attempt to load the image.
        g.setColor(Color.BLACK);
        g.drawLine(0, floor, B_WIDTH, floor);
        g.setColor(Color.GREEN);
        g.fillRect(0, floor + 1, B_WIDTH, B_HEIGHT);
        
        try {
            File imageFile = new File("media/sm_cannon.png");
            cannon = ImageIO.read(imageFile);
            setPreferredSize(new Dimension(cannon.getWidth(), cannon.getHeight()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        AffineTransform affineTransform = new AffineTransform();

        // draw a filled image using transformed location.

        if (cannon != null) {

            affineTransform.rotate(Math.toRadians(cannonRotation), 75, floor  - cannon.getHeight() / 2);
            affineTransform.translate(60, floor - cannon.getHeight() );
            g2d.drawImage(cannon, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[] { 50, 75, 100 }, new int[] { floor + 10, floor - 25, floor + 10 }, 3);
        g.setColor(oddBrown);
        g.fillPolygon(new int[] { 50, 75, 100 }, new int[] { floor + 10, floor - 25, floor + 10 }, 3);
        g.setColor(Color.BLUE);
        g.fillOval(70, floor - 30, 10, 10);
    }
    
    private double muzzleVelocity;

    public double getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(double muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
    }

    // Getters and setters for cannon
    public double getCannonRotation() {
        return cannonRotation;
    }

    public void setCannonRotation(double cannonRotation) {
        this.cannonRotation = cannonRotation;
    }
    private void fireCannon() {
        boomSound.play();
    }
    private void rotateCannon(int direction) {
        setCannonRotation(getCannonRotation() + (direction * rotateInterval));

        if (getCannonRotation() < -90) {
            setCannonRotation(-90);
        } else if (getCannonRotation() > 0) {
            setCannonRotation(0);
        } else {
            // Makes it so only the sound only happens when the cannon actually moves 
            wheelSound.noCutPlay();
        }
    }

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        public void run() {
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            rotateCannon(-1);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rotateCannon(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fireCannon(); 
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("U pressed up");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("U pressed down");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

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
