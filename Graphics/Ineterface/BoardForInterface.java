// Theodore Truebe
// Blip Blop Assignment (Unit 9 Lesson 32 HW)
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.EventQueue;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardForInterface extends JPanel implements KeyListener, MouseListener {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int SIDE_LEN = 150;
    private final int DIAMETER = 20;
    private final int INITIAL_X = (B_WIDTH / 2) - (DIAMETER / 2);
    private final int INITIAL_Y = (B_HEIGHT / 2) - (DIAMETER / 2);
    private int tempX;
    private int tempY;
    public SoundClip blop = new SoundClip("animate/media/blop.wav");
    public SoundClip blip = new SoundClip("animate/media/blip.wav");
    /*
     * Constructor
     */

    public BoardForInterface() {
        // set background color of the board and default size.
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        resetPosition();
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        blop.open();
        blip.open();

    }

    public void paintComponent(Graphics g) {
        // call the parent class method.
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillOval(tempX, tempY, DIAMETER, DIAMETER);

        // cast our Graphics object to a Graphics2D object.
        Graphics2D g2d = (Graphics2D) g;

    }

    public static final int VK_SPACE = 32;

    private void resetPosition() {
        tempX = INITIAL_X;
        tempY = INITIAL_Y;
        repaint();
        
    }

    private void setPositions(int x, int y) {
        tempX = x - (DIAMETER / 2);
        tempY = y - (DIAMETER / 2);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_SPACE) {
            resetPosition();
            blop.play();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent m) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent m) {
        setPositions(m.getX(), m.getY());

        blip.play();
    }

    @Override
    public void mouseReleased(MouseEvent m) {

    }

    @Override
    public void mouseEntered(MouseEvent m) {

    }

    @Override
    public void mouseExited(MouseEvent m) {

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ApplicationForInterface myApp = new ApplicationForInterface("Not-A-Title");
            myApp.setVisible(true);
        });
        
    }
}
