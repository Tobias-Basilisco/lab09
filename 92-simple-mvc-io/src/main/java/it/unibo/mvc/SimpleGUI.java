package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("SimpleGUI");
    protected Controller controller;

    public SimpleGUI(final Controller controller){
        this.controller = Objects.requireNonNull(controller);
        //components
        final JPanel panel = new JPanel();
        final JTextArea contentText = new JTextArea();
        final JButton save = new JButton("Save");
        //components position
        frame.getContentPane().add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(contentText, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //handler
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent ignored){
                try {
                    controller.write(contentText.getText());
                } catch (final IOException e){
                    System.out.println(e.getMessage() + e.getCause());
                }
            }
        });
    }

    protected JFrame getFrame(){
        return frame;
    }

    protected void setFrameTitle(final String title){
        frame.setTitle(Objects.requireNonNull(title));
    }

    protected void display(){
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screenSize.getWidth();
        final int sh = (int) screenSize.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        // frame.pack();

        frame.setVisible(true);
    }

    public static void main(final String[] args){
        new SimpleGUI(new Controller()).display();
    }
}
