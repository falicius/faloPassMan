package components.dialogs;

import components.buttons.passGen;
import components.utility.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPasswordEntryDialog extends JDialog {
    private JTextField nameField;
    private JTextField passwordField;
    private JTextField categoryField;
    private JTextField loginField;
    private JTextField websiteField;
    private JButton okButton;
    private JButton cancelButton;
    private passGen passGenButton;
    private boolean isConfirmed;

    public NewPasswordEntryDialog(Frame parent) {
        super(parent, "New Password Entry", true);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        nameField = new JTextField(20);
        passwordField = new JTextField(20);
        categoryField = new JTextField(20);
        loginField = new JTextField(20);
        websiteField = new JTextField(20);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        passGenButton = new passGen(passwordField);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        add(categoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Login:"), gbc);
        gbc.gridx = 1;
        add(loginField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Website:"), gbc);
        gbc.gridx = 1;
        add(websiteField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(okButton, gbc);
        gbc.gridx = 1;
        add(cancelButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(passGenButton, gbc);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validatePass()) {
                    isConfirmed = true;
                    setVisible(false);
                }
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



    public PasswordEntry getPasswordEntry() {
        return new PasswordEntry(
                nameField.getText(),
                passwordField.getText(),
                categoryField.getText(),
                loginField.getText(),
                websiteField.getText()
        );
    }
    private boolean validatePass() {
        if(nameField.getText().isEmpty() || passwordField.getText().isEmpty() || categoryField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields: {Name, Password, Category} are mandatory",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
}
