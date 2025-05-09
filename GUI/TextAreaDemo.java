// Theodore Truebe

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TextAreaDemo extends JPanel {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 250;
    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;
    // Declare the button outside, actually implement it inside
    JLabel labelInterest;
    JTextField textRate;
    static JTextArea areaText;
    static JFrame frame;
    static JPanel panel;
    static JButton button;
    static JScrollPane scrollPane;
    double balance;

    public TextAreaDemo() {
        frame = new JFrame("JTextArea Demo");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        areaText = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        areaText.setEditable(false);
        panel.add(areaText);

        scrollPane = new JScrollPane(areaText);
        // create a panel and place the scroll pane on it.
        panel = new JPanel();
        panel.add(scrollPane);
        button = new JButton("Click me");
        button.addActionListener(new ButtonListener());

        panel.add(button);

        frame.add(panel);
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            areaText.append("Hello\n");
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TextAreaDemo demo = new TextAreaDemo();
        });
    }

}
