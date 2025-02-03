package components.dialogs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterPasswordDialog extends JDialog {
    private JPasswordField passwordField;
    private JButton okButton;
    private JButton cancelButton;
    private boolean isConfirmed;

    public MasterPasswordDialog(Frame parent) {
        super(parent, "Enter Master Password", true);
        setLayout(new BorderLayout());

        passwordField = new JPasswordField(20);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(new JLabel("Enter Master Password:"), BorderLayout.NORTH);
        add(passwordField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isConfirmed = true;
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isConfirmed = false;
                setVisible(false);
            }
        });

        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }
}
