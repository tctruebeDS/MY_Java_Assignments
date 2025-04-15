import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Cannon extends JPanel {
    private BufferedImage cannon;
    private double cannonRotation;
    public SoundClip wheelSound;
    public SoundClip boomSound;
    private final int FLOOR = 775;
    private int timeScale;
    private double rotateInterval;
    public double baseX;
    public double baseY;
    public double cannonEndX;
    public double cannonEndY;
    public double muzzleX;
    public double muzzleY;
    static final public double MUZZLE_VELOCITY = 37;

    public Cannon() {

        wheelSound = new SoundClip("media/wheel.wav");
        boomSound = new SoundClip("media/boom.wav");
        setCannonRotation(45);
        wheelSound.setLoopFalse();
        wheelSound.open();
        boomSound.open();
        try {
            File imageFile = new File("media/sm_cannon.png");
            cannon = ImageIO.read(imageFile);
            setPreferredSize(new Dimension(cannon.getWidth(), cannon.getHeight()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform affineTransform = new AffineTransform();
        if (cannon != null) {
            baseX = 75;
            baseY = FLOOR - cannon.getHeight() / 2;
            affineTransform.rotate(-Math.toRadians(cannonRotation), 75, FLOOR - cannon.getHeight() / 2);
            affineTransform.translate(60, FLOOR - cannon.getHeight());
            g2d.drawImage(cannon, affineTransform, null);
            findMuzzle(g);

        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }

    }

    public void rotateUp(double rotateInterval) {
        this.rotateInterval = rotateInterval;
        setCannonRotation(cannonRotation + rotateInterval);
        if (getCannonRotation() > 90) {
            setCannonRotation(90);
        } else {
            wheelSound.noCutPlay();
        }

    }

    public void rotateDown(double rotateInterval) {
        this.rotateInterval = rotateInterval;
        setCannonRotation(cannonRotation - rotateInterval);
        if (getCannonRotation() < 0) {
            setCannonRotation(0);
        } else {
            wheelSound.noCutPlay();
        }
    }

    public double getCannonRotation() {
        return cannonRotation;
    }

    public void setCannonRotation(double cannonRotation) {
        this.cannonRotation = cannonRotation;
        repaint();
    }

    public void fireCannon(CannonBall ball) {
        // place ball at muzzle of cannon.
        // muzzle x and y should have been updated during
        ball.setX(muzzleX);
        ball.setY(muzzleY);

        // set velocity.
        double VX = MUZZLE_VELOCITY * Math.cos(Math.toRadians(this.getCannonRotation()));
        double VY = -MUZZLE_VELOCITY * Math.sin(Math.toRadians(this.getCannonRotation()));
        ball.setVX(VX);
        ball.setVY(VY);

        // launch the ball.
        ball.launchBall();
        boomSound.play();
    }

    public double getTimeScale() {
        return timeScale;
    }

    public String getAngleText() {
        return "Cannon Rotation: " + getCannonRotation() + " deg";
    }

    public String getTimeScaleText() {
        return "Time Scale: " + getTimeScale();
    }

    public void findMuzzle(Graphics g) {
        // Find the xy coordinates of the end of the barrel

        baseX = 75;
        baseY = FLOOR - 25;
        int muzzleHyp = 100;
        System.out.printf("BX, BY = %.1f, %1f%n", baseX, baseY);
        double angleRadians = Math.toRadians(getCannonRotation());
        System.out.printf("angle = %.2f degrees (%.2f radians)%n", getCannonRotation(), angleRadians);

        // double muzzleX = baseX + Math.cos(Math.toRadians(getCannonRotation())) *
        // muzzleHyp;
        muzzleX = baseX + muzzleHyp * Math.cos(angleRadians);
        // double muzzleY = baseY - Math.cos(Math.toRadians(getCannonRotation())) *
        // muzzleHyp;
        muzzleY = baseY - muzzleHyp * Math.sin(angleRadians);
        System.out.printf("muzzleX, muzzleY = %.2f, %.2f%n", muzzleX, muzzleY);
        g.setColor(Color.RED);
        g.drawLine((int) muzzleX, (int) muzzleY, (int) baseX, (int) baseY);
    }
}
