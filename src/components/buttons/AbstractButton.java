package components.buttons;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract public class AbstractButton extends JButton implements ActionListener {
    protected AbstractButton(String name) {
        super(name);
        addActionListener(this);
    }

    public abstract void handleEvent();
}
