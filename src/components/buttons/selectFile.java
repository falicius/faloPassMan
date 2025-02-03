package components.buttons;

import components.faloPasswordMan;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class selectFile extends AbstractButton {
    private CardLayout cardLayout;
    private JLabel fileLabel;
    public selectFile() {
        super("Select File");
    }
    public selectFile(JLabel label) {
        super("Select File");
        fileLabel = label;
    }
    public selectFile(CardLayout cardL) {
        super("Select File");
        cardLayout = cardL;
    }

    @Override
    public void handleEvent() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Password File");

        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File currentFile = fileChooser.getSelectedFile();
            faloPasswordMan topframe = (faloPasswordMan) SwingUtilities.getWindowAncestor(this);
            topframe.setFile(currentFile);
            topframe.promptForMasterPassword();
            topframe.changeLabel();
            if(cardLayout != null) {
                cardLayout.show(topframe.getContentPane(), "main");
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent();
    }
}
