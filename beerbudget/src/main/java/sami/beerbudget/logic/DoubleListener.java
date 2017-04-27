/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sami.beerbudget.logic;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author saklindq
 */
public class DoubleListener implements ChangeListener<String> {

    private TextField textArea;

    public DoubleListener(TextField input) {
        this.textArea = input;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
        try {
            Integer.parseInt(newValue);
            if (newValue.endsWith("f") || newValue.endsWith("d")) {
                textArea.setText(newValue.substring(0, newValue.length() - 1));
            }
        } catch (Exception e) {
            textArea.setText(oldValue);
        }
    }
}
