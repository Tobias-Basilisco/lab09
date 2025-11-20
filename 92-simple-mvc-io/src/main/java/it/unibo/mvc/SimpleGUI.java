package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("SimpleGUI");
    private static final int PROPORTION = 5;

    public SimpleGUI(){
        final JPanel panel = new JPanel();
        final JTextArea contentText = new JTextArea();
        final JButton save = new JButton("Save");

        frame.getContentPane().add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(contentText, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void display(){
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screenSize.getWidth();
        final int sh = (int) screenSize.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        // frame.pack();

        frame.setVisible(true);
    }

    public static void main(final String[] args){
        new SimpleGUI().display();
    }
}
