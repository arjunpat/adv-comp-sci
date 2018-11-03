package atoolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ATextField extends JTextField {

    private int aPrefWidth = 200;
    private int aPrefHeight = 30;

    public ATextField() {
        super(20);
    }

    public ATextField(int width, int height) {
        aPrefWidth = width;
        aPrefHeight = height;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(aPrefWidth, aPrefHeight);
    }

}
