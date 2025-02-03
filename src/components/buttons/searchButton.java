package components.buttons;

import components.faloPasswordMan;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class searchButton extends AbstractButton{
    private JTextField searchfield;

    public searchButton(JTextField field) {
        super("Search by category");
        searchfield = field;
    }

    @Override
    public void handleEvent() {
        faloPasswordMan topframe = (faloPasswordMan) SwingUtilities.getWindowAncestor(this);
        String category = searchfield.getText();
        if(category.isEmpty()){
            topframe.displayPasswordEntries();
        } else {
            topframe.displaySearchEntries(category);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
