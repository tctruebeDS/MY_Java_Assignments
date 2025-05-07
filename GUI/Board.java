// Theodore Truebe
// GUI HW G01

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Board extends JPanel {
    private final int B_WIDTH = 320;
    private final int B_HEIGHT = 240;
    private final int TEXT_WIDTH = 10;
    private int count = 0;
    private int increment = 1;
    private final double INIT_BALANCE = 1000.00;
    private final double INIT_APR = 5.0;
    // Declare the button outside, actually implement it inside
    JButton button;
    JLabel labelInterest;
    JTextField textRate;

    JLabel labelBalance;
    double balance;
    // public void click() {
    // count += increment;
    // }

    // public void updateLabel() {
    // label.setText("Count: " + count);
    // }

    // constructor.
    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // Add interest (APR label)
        labelInterest = new JLabel("Interest Rate(%): ");
        this.add(labelInterest);

        textRate = new JTextField(TEXT_WIDTH);
        this.add(textRate);
        String text = Double.toString(INIT_APR);
        textRate.setText(text);

        
        
        button = new JButton("Add interest");
        button.addActionListener(new ClickMeListener());

        this.add(button);

        // add a balance label
        balance = INIT_BALANCE;
        
        text = String.format("Balance ($): %.2f", balance);
        labelBalance = new JLabel(text);
        this.add(labelBalance);

        // label = new JLabel("Count: " + count);
        // this.add(label);

    }

    // this inner class is used to listen for mouse clicks.
    // It listens for events (in this case, "e"), and does something when the event
    // occurs
    class ClickMeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println("Clicked!");
            // click();
            // // label.setText("Clicked!");
            // updateLabel();
            double rate = Double.parseDouble(textRate.getText());
            rate = rate / 100.0;
            balance = balance + rate * balance;
            String text = String.format("Balance ($): %.2f", balance);
            labelBalance.setText(text);
        }
    }
}
