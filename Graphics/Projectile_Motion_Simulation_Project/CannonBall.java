import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CannonBall {
    private int BOARD_SCALE = 256; // pixels per meter
    private int TIMER_INTERVAL = 20; // milliseconds per timer interval
    private int G_BOARD = 1; // acceleration due to gravity in pixels per timer interval ^ 2
    private int MUZZLE_VELOCITY = 37; // pixels per timer interval
    private double timeScale;
    private double X; // Initial Position
    private double Y; // Initial Position
    private double VX; // Initial velocity
    private double VY; // Initial Velocity
    private double AX = 0; // Accel x
    private double AY = -2;
    private BufferedImage flame01;
    private BufferedImage flame02;
    private BufferedImage flame03;
    private BufferedImage flame04;
    private double ground;
    private STATE state;

    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }

    public CannonBall(double ax, double ay, double ground) {
        setState(STATE.IDLE);
        this.ground = ground;
        
        // public constructor for CannonBall class.
        // takes the acceleration rates (x and y) and the location of the ground (as a
        // double)
        // as arguments
    }

    private BufferedImage loadImage(String path) {
        // loads a buffered image (for the flame animation).
        BufferedImage img = null;
        try {
            File imageFile = new File(path);
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return img;
    }

    /*
     * The draw method is called by the Board object
     * and is used to paint the current location and state of the ball.
     * If the ball is flying through the air, the ball is drawn as a red
     * filled in circle. If the ball is in the exploded state, a flame image is
     * drawn. If the ball is idle, then the ball is not drawn at all
     * (since we assume the ball is hidden inside the cannon).
     */
    public void draw(Graphics2D g2d) {
        if (getState().equals(STATE.IDLE)) {

        } else if (getState().equals(STATE.FLYING)) {
            updateBall();
        } else if (getState().equals(STATE.EXPLODING)) {
            loadImage("media/flame01");
            
        }
    }

    /*
     * The updateBall() method uses the constant acceleration equations
     * to update the velocity and position of the ball each timer interval.
     * note that when calculating the new velocity, the acceleration term is divided
     * by the
     * time scale in case the user wants to slow down the animation.
     * Similarly, when calculating the new position, the velocity term is divided by
     * the time scale
     * in case the user wants to slow down the animation.
     */
    public void updateBall() {
        if (getState().equals(STATE.FLYING)) {
            // Speed = old speed + accel
            VX = VX + AX;
            VY = VY + AY;
            // Oldposition = old position + velocity
            X = X + VX;
            Y = Y + VY;
        
            checkExploding();
        } else if (getState().equals(STATE.EXPLODING)) {
            loadImage("media\\flame01.png");
            

        }

    }

    /*
     * If the ball is not flying through the air, the launch() method
     * will change the state to FLYING and start the ball moving from position (x,y)
     * with the inital velocity of (vx, vy).
     */
    public void launch(double X, double Y, double VX, double VY) {
        if (state != STATE.FLYING) {
            this.X = X;
            this.Y = Y;
            this.VX = VX;
            this.VY = VY;
            setState(STATE.FLYING);
        }

    }

    /*
     * Get/set methods for the private member variables.
     */
    public STATE getState() {
        return state;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getVX() {
        return VX;
    }

    public double getVY() {

        return VY;
    }

    public double getAX() {
        return AX;
    }

    public double getAY() {
        return AY;
    }

    public double getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(double timeScale) {
        this.timeScale = timeScale;
    }

    public void setState(STATE newState) {
        state = newState;
    }

    public void setX(double x) {
        this.X = x;

    }

    public void setY(double y) {
        this.Y = y;
    }

    public void setVX(double vx) {
        this.VX = vx;
    }

    public void setVY(double vy) {
        this.VY = vy;
    }

    public void setAX(double ax) {
        this.AX = ax;
    }

    public void setAY(double ay) {
        this.AY = ay;
    }

    public void changeTimeScale(double delta) {
        setTimeScale(getTimeScale() + delta);
    }

    public void checkExploding() {
        if (getY() > ground) {
            setState(STATE.EXPLODING);
        }
    }
    public void launchBall() {
        setState(STATE.EXPLODING);
    }
}