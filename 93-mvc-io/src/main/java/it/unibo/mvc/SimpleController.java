package it.unibo.mvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String strBuffer;
    private List<String> history;

    public SimpleController(){
        history = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStrBuffer(final String strToBuffer) throws NullPointerException{
        if (strToBuffer == null){
            throw new NullPointerException();
        }
        strBuffer = strToBuffer;
    }

    @Override
    public String getStrBuffer(){
        return Objects.requireNonNull(strBuffer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getPrintedStrings(){
        return new ArrayList<>(history);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void print() throws IllegalStateException{
        if (strBuffer == null || strBuffer.isEmpty()){
            throw new IllegalStateException("Can't print empty buffer");
        }
        System.out.println(strBuffer);
        history.add(strBuffer);
    }

}
