package components;

import components.dialogs.MasterPasswordDialog;
import components.utility.*;
import components.panels.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class faloPasswordMan extends JFrame {
    private LoginPanel login;
    private MainPanel manager;
    private CardLayout cardLayout;
    private File file;

    public File getFile() {
        return file;
    }

    private int shiftValue;
    private List<PasswordEntry> passwordEntries;


    public void PasswordEntryDelete(int row) {
        passwordEntries.remove(row);
    }

    public void PasswordEntrySet(int row, PasswordEntry changedEntry) {
        passwordEntries.set(row, changedEntry);
    }

    public List<PasswordEntry> getPasswordEntries() {
        return passwordEntries;
    }
    public void setPasswordEntries(List<PasswordEntry> entries) {
        passwordEntries = entries;

    }

    public void addEntry(PasswordEntry entry) {
        passwordEntries.add(entry);
    }




    public void setFile(File file) {
        this.file = file;
    }

    public faloPasswordMan() {
        this.setTitle("Falo Password Manager");
        passwordEntries = new ArrayList<>();
        cardLayout = new CardLayout();
        manager = new MainPanel(this);
        login = new LoginPanel(cardLayout);
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(cardLayout);
        this.add(login, "login");
        cardLayout.show(this.getContentPane(), "login"); // Show first card
        this.add(manager, "main");
        this.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                faloPasswordMan whole = new faloPasswordMan();
            }
        });
    }

    public void promptForMasterPassword() {
        MasterPasswordDialog dialog = new MasterPasswordDialog(this);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            char[] masterPassword = dialog.getPassword();
            shiftValue = CaesarCipher.getShiftValue(masterPassword);
            JOptionPane.showMessageDialog(this, "Master password entered.");
            loadPasswordEntries();
            displayPasswordEntries();
        } else {
            JOptionPane.showMessageDialog(this, "Master password entry canceled.");
        }
    }

    public void loadPasswordEntries() {
        passwordEntries.clear();
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String decryptedLine = CaesarCipher.decrypt(line, shiftValue);
                    String[] parts = decryptedLine.split(",");
                    if (parts.length >= 3) {
                        PasswordEntry entry = new PasswordEntry(parts[0], parts[1], parts[2],
                                parts.length > 3 ? parts[3] : "",
                                parts.length > 4 ? parts[4] : "");
                        passwordEntries.add(entry);
                    }
                    if (FdateTime.validateTime(decryptedLine)) {
                        manager.setLastAccesLabel(" Latest Change: "+decryptedLine);
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading password entries: " + ex.getMessage());
            }
        }
    }

    public void displayPasswordEntries() {
        manager.repaintTable();
    }
    public void displaySearchEntries(String category) {
        manager.queryTable(category);
    }
    public void changeLabel() {
        manager.setCurrentFileLabel();
    }
    public void savePasswordEntries() {
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (PasswordEntry entry : passwordEntries) {
                    String encryptedLine = CaesarCipher.encrypt(String.format("%s,%s,%s,%s,%s",
                            entry.getName(),
                            entry.getPassword(),
                            entry.getCategory(),
                            entry.getLogin(),
                            entry.getWebsite()), shiftValue);
                    writer.write(encryptedLine);
                    writer.newLine();
                }
                String encryptedDate = CaesarCipher.encrypt(FdateTime.getTime(), shiftValue);
                writer.write(encryptedDate);
                writer.newLine();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving password entries: " + ex.getMessage());
            }
        }
    }
}
