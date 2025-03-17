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
    private int r = 0;
    private final int DIAMETER = 20;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private int rotate = 0;
    private int rotateInterval = 5;
    private BufferedImage cannon;
    public SoundClip wheelSound = new SoundClip("media/wheel.wav");
    public SoundClip boomSound = new SoundClip("media/boom.wav");
    private int floor = (B_HEIGHT - 25);

    /*
     * Constructor
     */
    public Board() {

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

            affineTransform.rotate(Math.toRadians(r), x + cannon.getWidth() / 2, y + cannon.getHeight() / 2);
            affineTransform.translate(x, y);
            g2d.drawImage(cannon, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }

    }

    private void rotateCannon(int direction) {
        rotate += (direction * rotateInterval);
        if (rotate < -85) {
            rotate = -85;
        } else if (rotate > 0) {
            rotate = 0;
        }
        wheelSound.noCutPlay();
    }

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        public void run() {
            r = rotate;
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
            System.out.println("U pressed space");
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
