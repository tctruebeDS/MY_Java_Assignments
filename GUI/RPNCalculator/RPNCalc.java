// Theodore Truebe 
// RPN Calculator

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPNCalc {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 200;
    private JFrame frame;

    private JPanel panel;
    private JTextField txtDisplay;

    private JPanel pnlButtons;
    private GridBagConstraints constraints;

    // Use a stack of doubles to keep track of operands.
    private Stack stack;
    // clearFlag indicates if display should be cleared
    // before its text value gets updated.
    private boolean clearFlag;

    private void addDisplay(JPanel panel) {
        // add the display at the top of the panel.
        txtDisplay = new JTextField("0");
        txtDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        txtDisplay.setEditable(false);
        panel.add(txtDisplay, BorderLayout.NORTH);
    }

    private void addButtons(JPanel panel) {
        // use a gridbag layout to allow us to have variable sized buttons.
        pnlButtons = new JPanel(new GridBagLayout());

        // the constraints object is what we will use
        // to configure the cells of our grid.
        constraints = new GridBagConstraints();
        // By default, each button should be one col wide and one row tall.
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        // set weight of constraints so the sizes of the buttons are all the same.
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        // configure the cells so the components fill
        // the cell in the horiz and vert directions.
        constraints.fill = GridBagConstraints.BOTH;

        // add the number keys,
        addDigitButton(0, 0, "7");
        addDigitButton(1, 0, "8");
        addDigitButton(2, 0, "9");
        addActionButton(3, 0, "/");
        addDigitButton(0, 1, "4");
        addDigitButton(1, 1, "5");
        addDigitButton(2, 1, "6");
        addActionButton(3, 1, "*");
        addDigitButton(0, 2, "1");
        addDigitButton(1, 2, "2");
        addDigitButton(2, 2, "3");
        addActionButton(3, 2, "-");
        addDigitButton(0, 3, "0");
        addActionButton(1, 3, ".");
        addActionButton(2, 3, "+/-");
        addActionButton(3, 3, "+");
        // add the all clear key to 1st col, 5th row.
        addActionButton(0, 4, "C");

        // add the clear entry key to 2nd col, 5th row.
        addActionButton(1, 4, "CE");
        constraints.gridwidth = 2;
        addActionButton(2, 4, "ENTER");

        // add subpanel to center of main panel.
        panel.add(pnlButtons, BorderLayout.CENTER);

    }

    private void addDigitButton(int gridx, int gridy, String label) {
        // create the button and add it to the buttons panel.
        JButton btn = addButton(gridx, gridy, label);

        // add a DigitButtonListener for this type of button.
        btn.addActionListener(new DigitButtonListener(label));
    }

    private JButton addButton(int gridx, int gridy, String label) {
        // create the button.
        JButton btn;
        btn = new JButton(label);

        // add button to the button panel.
        constraints.gridy = gridy;
        constraints.gridx = gridx;
        pnlButtons.add(btn, constraints);
        return btn;
    }

    private void addActionButton(int gridx, int gridy, String label) {
        JButton btn = addButton(gridx, gridy, label);

        btn.addActionListener(new ActionButtonListener(label));
    }

    private class ActionButtonListener implements ActionListener {
        private String label;

        public ActionButtonListener(String label) {
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            if (label.equals("C")) {
                clearAll();
            } else if (label.equals("CE")) {
                clearEntry();
            } else if (label.equals("ENTER")) {
                doEnter();
            } else if (label.equals("+")) {
                doOperation(label);
            } else if (label.equals("-")) {
                doOperation(label);
            } else if (label.equals("*")) {
                doOperation(label);
            } else if (label.equals("/")) {
                doOperation(label);
            }
        }
    }
    public void clearAll() {
        stack.clear();
        setDisplay(0);
    }
    public double getDisplayValue() {
        double value;
        try {
            value = Double.parseDouble(txtDisplay.getText());
            return value;
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public void doOperation(String label) {
        if (clearFlag) {
            System.out.println("Enter nr into thingy");
            return;
        }
        if (stack.isEmpty()) {
            return;
        }
        double d2 = getDisplayValue();

        if (Double.isNaN(d2)) {
            System.err.println("HUH??");
            return;
        }

  
        if (d2 == 0 && label.equals("/")) {
            txtDisplay.setText("NaN");
            clearFlag = true;
            System.err.println("error");
            return;
        }

        double d1 = stack.pop();

        double result;
        if (label.equals("/")) {
            result = d1 / d2;
        } else if (label.equals("*")) {
            result = d1 * d2;
        } else if (label.equals("-")) {
            result = d1 - d2;
        } else if (label.equals("+")) {
            result = d1 + d2;
        } else {
            System.err.println("Unknown operation.");
            return;
        }

        setDisplay(result);

        stack.push(result);

        clearFlag = true;
    }

    public void doEnter() {

        double value;
        try {

            value = Double.parseDouble(txtDisplay.getText());
            stack.push(value);

            clearFlag = true;
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the text display.");
        }
    }

    public void setDisplay(double d) {
        String text;
        // check if it's an integer.
        if (d % 1 == 0) {
            text = Integer.toString((int) d);
        } else {
            text = Double.toString(d);
        }
        txtDisplay.setText(text);
    }

    private void clearEntry() {
        txtDisplay.setText("0");
    }

    private class DigitButtonListener implements ActionListener {
        private String label;

        /*
         * Constructor.
         */
        public DigitButtonListener(String label) {
            this.label = label;
        }

        public void actionPerformed(ActionEvent e) {
            if (clearFlag) {
                clearEntry();
                clearFlag = false;
                txtDisplay.setText(txtDisplay.getText() + label);
            } else {
                // for now just print a message to the console whenever button is pressed.
                System.out.println("The button labeled \"" + label + "\" was pressed");
                txtDisplay.setText(txtDisplay.getText() + label);
            }
        }
    }

    // constructor
    public RPNCalc() {

        // create the frame.
        frame = new JFrame("RPN Calculator");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // place the frame in the center of the screen
        frame.setLocationRelativeTo(null);
        // make the frame visible.
        frame.setVisible(true);

        // create our main panel for our UI.
        // use a BorderLayout manager.
        panel = new JPanel(new BorderLayout());

        // add the display field to our panel.
        addDisplay(panel);

        // add the panel to our frame.
        frame.add(panel);

        // add the buttons subpanel to our panel.
        addButtons(panel);
        // create a stack of double values to hold our operands.
        stack = new Stack();

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new RPNCalc();
        });
    }

}
