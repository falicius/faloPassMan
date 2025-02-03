package components.buttons;


import components.faloPasswordMan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class newFile extends AbstractButton {
    private CardLayout cardLayout;
    private JLabel fileLabel;
    public newFile() {
        super("New File");
    }
    public newFile(JLabel label) {
        super("New File");
        fileLabel = label;
    }

    public newFile(CardLayout cardL) {
        super("New File");
        cardLayout = cardL;
    }

    @Override
    public void handleEvent() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Create a new password file");
        fileChooser.setApproveButtonText("Create");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File currentFile = fileChooser.getSelectedFile();
            try {
                if (currentFile.createNewFile()) {
                    faloPasswordMan topframe = (faloPasswordMan) SwingUtilities.getWindowAncestor(this);
                    topframe.setFile(currentFile);
                    topframe.promptForMasterPassword();
                    topframe.changeLabel();
                    if(cardLayout != null) {
                        cardLayout.show(topframe.getContentPane(), "main");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "File already exists: " + currentFile.getAbsolutePath());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error creating file: " + ex.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
