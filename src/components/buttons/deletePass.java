package components.buttons;

import components.faloPasswordMan;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class deletePass extends AbstractButton{
    private JTable table;
    public deletePass(JTable tab) {
        super("Delete entry");
        table = tab;
    }

    @Override
    public void handleEvent() {
        faloPasswordMan topframe = (faloPasswordMan) SwingUtilities.getWindowAncestor(this);
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this entry?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                topframe.PasswordEntryDelete(selectedRow);
                topframe.savePasswordEntries();
                topframe.displayPasswordEntries();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a password entry to delete.");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
