
package animate;

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
import animate.sound.ToneGenerator;
import animate.sound.ToneGenerator.Note;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;

import A02_B.animate.Application;

public class OldMacDonald_Board extends JPanel {
    public static void main(String[] args) throws LineUnavailableException {
        ToneGenerator tg = new ToneGenerator();
        tg.init();
        tg.play(Note.C5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.C5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.C5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.G4, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.A4, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.A4, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.G4, 572);
        tg.play(Note.REST, 2);
        tg.play(Note.E5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.E5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.D5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.D5, 286);
        tg.play(Note.REST, 2);
        tg.play(Note.C5, 858);
        
        
        tg.close();
    }

}
