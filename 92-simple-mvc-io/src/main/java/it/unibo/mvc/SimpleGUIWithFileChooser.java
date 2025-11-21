package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.FileChooserUI;


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

        //handler
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ignored){
                JFileChooser fChooser = new JFileChooser();
                int result = fChooser.showOpenDialog(mainFrame);
                if (result == JFileChooser.APPROVE_OPTION){
                    final File fileChosen = fChooser.getSelectedFile();
                    controller.setCurrentFile(fileChosen);
                    filePath.setText(fileChosen.getAbsolutePath());
                }
            }
        });   
    }

    public static void main(final String[] args){
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
