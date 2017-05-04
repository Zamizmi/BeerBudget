/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *Listener for input.
 * @author saklindq
 */
public class DoubleListener implements ChangeListener<String> {

    private TextField textArea;

    /**
     * Constructor only.
     * @param input from user.
     */
    public DoubleListener(TextField input) {
        this.textArea = input;
    }

    /**
     * Override-method. Sets the input back to as it was if it is bad.
     * @param observable.
     * @param oldValue.
     * @param newValue.
     */
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
        try {
            Double.parseDouble(newValue);
        } catch (Exception e) {
            textArea.setText(oldValue);
        }
    }
}
