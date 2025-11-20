package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private final String HOME = System.getProperty("user.home");
    private final String DEFAULT_PATH = HOME + 
                                File.separator +
                                "output.txt";
    private File currentFile = new File(DEFAULT_PATH);

    /**
     * sets the parsed file as current file
     * @param file
     */
    public void setCurrentFile(final File file){
        currentFile = Objects.requireNonNull(file);
    }

    /**
     * 
     * @return current file
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * 
     * @return current file absolute path
     */
    public String getCurrentFilePath(){
        return currentFile.getAbsolutePath();
    }

    public void write(final String content) throws IOException{
        try(final PrintStream ps = new PrintStream(getCurrentFilePath(), StandardCharsets.UTF_8)){
            ps.print(content);
        }
    }
}
