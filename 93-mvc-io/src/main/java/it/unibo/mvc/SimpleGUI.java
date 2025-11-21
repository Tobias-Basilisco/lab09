package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;

    private Controller ctrl;
    private final JFrame frame = new JFrame("Print history app");
    private final JPanel mainPanel = new JPanel();
    private final JTextField inputField = new JTextField();
    private final JTextArea historyBoard = new JTextArea();
    private final JButton printButton = new JButton("Print");
    private final JButton showHistoryButton = new JButton("Show history");

    public SimpleGUI(final Controller controller){
        ctrl = Objects.requireNonNull(controller);

        historyBoard.setEditable(false);
        //components position
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputField, BorderLayout.NORTH);
        mainPanel.add(historyBoard, BorderLayout.CENTER);
        final JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.add(printButton);
        btnPanel.add(showHistoryButton);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //handlers
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored){
                try{
                    ctrl.setStrBuffer(inputField.getText());
                    ctrl.print();
                } catch (Exception e){
                    JOptionPane.showMessageDialog(frame, "something wnet wrong: " + e.getMessage(), "print error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored){
                showHistory();
            }
        });
    }

    private void showHistory(){
        final List<String> history = ctrl.getPrintedStrings();
        String historyText = "";
        if (history == null || history.isEmpty()){
            historyText = "No history yet!";
        } else {
            for (final String entry : history){
                historyText += (entry + "\n");
            }
        }
        historyBoard.setText(historyText);
    }

    private void display(){
        //window app size
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screenSize.getWidth();
        final int sh = (int) screenSize.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(final String... args){
        final SimpleGUI simpleGUI = new SimpleGUI(new SimpleController());
        simpleGUI.display();
    }
}
