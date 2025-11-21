package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * sets the next string to print. 
     * @throws NullPointerException
     * @param strToBuffer
     * 
     */
    void setStrBuffer(final String strToBuffer) throws NullPointerException;

    /**
     * @return the next string to print.
     */
    String getStrBuffer();

    /**
     * @return printed strings history
     */
    List<String> getPrintedStrings();

    /**
     * prints buffered string
     * @throws IllegalStateException
     */
    void print() throws IllegalStateException;
}
