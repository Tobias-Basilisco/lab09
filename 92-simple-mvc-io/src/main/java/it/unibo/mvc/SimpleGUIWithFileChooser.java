package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.FileChooserUI;


/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUIWithFileChooser extends SimpleGUI {

    private final JPanel browseBar = new JPanel();
    private JTextArea filePath;
    private JButton browseButton;
    private JFrame mainFrame;


    public SimpleGUIWithFileChooser(final Controller controller){
        super(controller);
        setFrameTitle("File writter app");

        //components
        mainFrame = getFrame();
        browseButton = new JButton("Browse...");
        filePath = new JTextArea();
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
                showSaveDialog();
            }
        });   
    }

    private void showSaveDialog(){
        JFileChooser fChooser = new JFileChooser();
        int result = fChooser.showOpenDialog(mainFrame);
        switch (result){
            case JFileChooser.APPROVE_OPTION:
                final File fileChosen = fChooser.getSelectedFile();
                controller.setCurrentFile(fileChosen);
                filePath.setText(fileChosen.getAbsolutePath());
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                JOptionPane.showMessageDialog(mainFrame, "Error: something went wrong, verify file selection");
        }
    }

    public static void main(final String[] args){
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
