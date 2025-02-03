package components.buttons;

import components.faloPasswordMan;
import components.utility.PasswordEntry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class deleteCat extends AbstractButton{
    private JTable table;

    public deleteCat(JTable tab) {
        super("Delete Category");
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
                String category = topframe.getPasswordEntries().get(selectedRow).getCategory();
                List<PasswordEntry> entries = new ArrayList<>();

                for (PasswordEntry entry : topframe.getPasswordEntries()) {
                    if(!entry.getCategory().equalsIgnoreCase(category)) {
                        entries.add(entry);
                    }
                }

                topframe.setPasswordEntries(entries);
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
