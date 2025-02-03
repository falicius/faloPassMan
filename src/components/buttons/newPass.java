package components.buttons;

import components.dialogs.NewPasswordEntryDialog;
import components.faloPasswordMan;
import components.utility.PasswordEntry;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class newPass extends AbstractButton{
    public newPass() {
        super("New Entry");
    }

    @Override
    public void handleEvent() {
        faloPasswordMan topframe = (faloPasswordMan) SwingUtilities.getWindowAncestor(this);

        NewPasswordEntryDialog dialog = new NewPasswordEntryDialog(topframe);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            PasswordEntry newEntry = dialog.getPasswordEntry();
            topframe.addEntry(newEntry);
            topframe.savePasswordEntries();
            topframe.displayPasswordEntries();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
