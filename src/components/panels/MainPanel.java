package components.panels;

import components.buttons.newFile;
import components.buttons.*;
import components.buttons.selectFile;
import components.faloPasswordMan;
import components.utility.PasswordEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainPanel extends JPanel {
    private JPanel topPanel;
    private JPanel secondPanel;
    private newFile newButton;
    private selectFile selectButton;
    private newPass addEntryButton;
    private editPass editEntryButton;
    private deletePass deleteEntryButton;
    private JLabel currentFileLabel;
    private JLabel lastAccesLabel;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private faloPasswordMan topframe;
    private JTextField search;
    private searchButton searchButton;
    private deleteCat deleteCatButton;
    public MainPanel(faloPasswordMan Ancestor) {
        topframe = Ancestor;
        _initialize();
    }
    private void _initialize() {
        model = new DefaultTableModel(new Object[]{"Name", "Password", "Category", "Login", "Website"}, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        GridBagConstraints gbc = new GridBagConstraints();

        topPanel = new JPanel(new GridBagLayout());
        currentFileLabel = new JLabel();
        newButton = new newFile(currentFileLabel);
        selectButton = new selectFile(currentFileLabel);
        lastAccesLabel = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(newButton, gbc);
        gbc.gridx = 1;
        topPanel.add(selectButton, gbc);
        gbc.gridx = 2;
        topPanel.add(currentFileLabel);
        gbc.gridx = 4;
        topPanel.add(lastAccesLabel);

        secondPanel = new JPanel(new GridBagLayout());
        addEntryButton = new newPass();
        editEntryButton = new editPass(table);
        deleteEntryButton = new deletePass(table);
        search = new JTextField(20);
        searchButton = new searchButton(search);
        deleteCatButton = new deleteCat(table);

        gbc.gridx = 0;
        gbc.gridy = 0;
        secondPanel.add(addEntryButton, gbc);
        gbc.gridx = 1;
        secondPanel.add(editEntryButton, gbc);
        gbc.gridx = 2;
        secondPanel.add(deleteEntryButton, gbc);
        gbc.gridx = 3;
        secondPanel.add(searchButton, gbc);
        gbc.gridx = 4;
        secondPanel.add(search, gbc);
        gbc.gridx = 5;
        secondPanel.add(deleteCatButton, gbc);

        JPanel catPanel = new JPanel();
        catPanel.setLayout(new BoxLayout(catPanel, BoxLayout.Y_AXIS));
        catPanel.add(topPanel);
        catPanel.add(secondPanel);


        this.setLayout(new BorderLayout());
        this.add(catPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        showtable();
        this.setVisible(true);

    }

    private void showtable() {
        for (int i = 0; i < topframe.getPasswordEntries().size(); i++) {
            PasswordEntry entry = topframe.getPasswordEntries().get(i);
            Object[] tmp = new Object[5];
            tmp[0] = entry.getName();
            tmp[1] = entry.getPassword();
            tmp[2] = entry.getCategory();
            tmp[3] = entry.getLogin();
            tmp[4] = entry.getWebsite();
            model.addRow(tmp);
        }
    }

    public void queryTable(String category) {
        model.setNumRows(0);
        for (int i = 0; i < topframe.getPasswordEntries().size(); i++) {
            PasswordEntry entry = topframe.getPasswordEntries().get(i);
            Object[] tmp = new Object[5];
            tmp[0] = entry.getName();
            tmp[1] = entry.getPassword();
            tmp[2] = entry.getCategory();
            tmp[3] = entry.getLogin();
            tmp[4] = entry.getWebsite();
            if(entry.getCategory().equalsIgnoreCase(category)) {
                model.addRow(tmp);
            }
        }
    }

    public void repaintTable() {
        model.setNumRows(0);
        for (int i = 0; i < topframe.getPasswordEntries().size(); i++) {
            PasswordEntry entry = topframe.getPasswordEntries().get(i);
            Object[] tmp = new Object[5];
            tmp[0] = entry.getName();
            tmp[1] = entry.getPassword();
            tmp[2] = entry.getCategory();
            tmp[3] = entry.getLogin();
            tmp[4] = entry.getWebsite();
            model.addRow(tmp);
        }
    }

    public void setCurrentFileLabel() {
        currentFileLabel.setText(topframe.getFile().toString());
    }

    public void setLastAccesLabel(String date) {
        lastAccesLabel.setText(date);
    }
}
