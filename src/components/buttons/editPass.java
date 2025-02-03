package components.buttons;

import components.dialogs.*;
import components.utility.*;
import components.faloPasswordMan;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class editPass extends AbstractButton{
    private JTable table;
    public editPass(JTable tab) {
        super("Edit entry");
        table = tab;
    }

    @Override
    public void handleEvent() {
        faloPasswordMan topframe = (faloPasswordMan) SwingUtilities.getWindowAncestor(this);
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            PasswordEntry selectedEntry = topframe.getPasswordEntries().get(selectedRow);
            EditPasswordEntryDialog dialog = new EditPasswordEntryDialog(topframe, selectedEntry);
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                    PasswordEntry editedEntry = dialog.getEditedPasswordEntry();
                    topframe.PasswordEntrySet(selectedRow, editedEntry);
                    topframe.savePasswordEntries();
                    topframe.displayPasswordEntries();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a password entry to edit.");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
