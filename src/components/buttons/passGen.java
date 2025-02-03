package components.buttons;

import components.utility.RandomPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class passGen extends AbstractButton{
    private JTextField text;
    public passGen(JTextField field) {
        super("Generate random password");
        text = field;
    }

    @Override
    public void handleEvent() {
        String password = RandomPassword.generatePass();
        text.setText(password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
