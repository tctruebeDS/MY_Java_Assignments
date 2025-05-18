import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

public class ControllingLayout {
    JFrame frame;
    JPanel panel;

    public ControllingLayout(int width, int height) {
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new BorderLayout());
        
        // add something at the ordinal points on the panel.
        JLabel lblNorth = new JLabel("North");
        lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNorth, BorderLayout.NORTH);

        JLabel lblSouth = new JLabel("South");
        lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblSouth, BorderLayout.SOUTH);
        JLabel lblEast = new JLabel("East");
        panel.add(lblEast, BorderLayout.EAST);
        JLabel lblWest = new JLabel("West");
        panel.add(lblWest, BorderLayout.WEST);
        JPanel pnlCenter = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            pnlCenter.add(new JButton(Integer.toString(i)));
        }
        panel.add(pnlCenter, BorderLayout.CENTER);
 

        // for (int i = 0; i < 18; i ++) {
        // String label = String.format("Button %d", i + 1);
        // JButton btn = new JButton(label);
        // panel.add(btn);
        // }

        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ControllingLayout layout = new ControllingLayout(400, 400);
        });
    }
}