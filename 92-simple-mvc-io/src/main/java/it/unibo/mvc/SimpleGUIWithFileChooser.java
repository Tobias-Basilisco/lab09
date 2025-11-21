package it.unibo.mvc;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUIWithFileChooser extends SimpleGUI {

    private final JPanel browseBar = new JPanel();

    public SimpleGUIWithFileChooser(final Controller controller){
        super(controller);
        setFrameTitle("File writter app");

        //components
        final JFrame mainFrame = getFrame();
        JButton browseButton = new JButton("Browse...");
        JTextArea filePath = new JTextArea();
        filePath.setEditable(false);
        //components position
        browseBar.setLayout(new BorderLayout());
        mainFrame.add(browseBar, BorderLayout.NORTH);
        browseBar.add(filePath, BorderLayout.LINE_START);
        browseBar.add(browseButton, BorderLayout.LINE_END);

        
    }

    public static void main(final String[] args){
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
