package atoolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AButton extends JButton {

    public AButton(String val) {
        super(val);
    }

    public AButton() {
        super();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 30);
    }

}
