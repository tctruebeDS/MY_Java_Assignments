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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

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

    private int floor = (B_HEIGHT - 25);
    private Cannon cannon;

    /*
     * Constructor
     */
    public Board() {
        cannon = new Cannon();
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

        g.setColor(Color.BLACK);
        g.drawLine(0, floor, B_WIDTH, floor);
        g.setColor(Color.GREEN);
        g.fillRect(0, floor + 1, B_WIDTH, B_HEIGHT);

        cannon.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawPolygon(new int[] { 50, 75, 100 }, new int[] { floor + 10, floor - 25, floor + 10 }, 3);
        g.setColor(new Color(253, 174, 174));
        g.fillPolygon(new int[] { 50, 75, 100 }, new int[] { floor + 10, floor - 25, floor + 10 }, 3);
        g.setColor(Color.BLUE);
        g.fillOval(70, floor - 30, 10, 10);
    }

    private void rotateCannon(int direction) {
        cannon.setCannonRotation(cannon.getCannonRotation() + (direction * rotateInterval));

        if (cannon.getCannonRotation() < -90) {
            cannon.setCannonRotation(-90);
        } else if (cannon.getCannonRotation() > 0) {
            cannon.setCannonRotation(0);
        } else {
            cannon.wheelSound.noCutPlay();
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
            cannon.fireCannon();
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
