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
    private final int floor = 775;

    public Cannon() {

        wheelSound = new SoundClip("media/wheel.wav");
        boomSound = new SoundClip("media/boom.wav");
        setCannonRotation(-45);
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform affineTransform = new AffineTransform();
        if (cannon != null) {
            affineTransform.rotate(Math.toRadians(cannonRotation), 75, floor - cannon.getHeight() / 2);
            affineTransform.translate(60, floor - cannon.getHeight());
            g2d.drawImage(cannon, affineTransform, null);
        } else {
            g2d.setColor(Color.BLUE);
            g2d.drawString("Unable to load image!", 25, 25);
        }
    }

    public double getCannonRotation() {
        return cannonRotation;
    }

    public void setCannonRotation(double cannonRotation) {
        this.cannonRotation = cannonRotation;
        repaint();
    }

    public void fireCannon() {
        boomSound.play();
    }
}
