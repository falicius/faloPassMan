package components.panels;
import components.buttons.*;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private newFile newButton;
    private selectFile selectButton;
    private CardLayout cardLayout;

    public LoginPanel(CardLayout cardL) {
        cardLayout = cardL;
        this.setLayout(new FlowLayout());
        newButton = new newFile(cardL);
        selectButton = new selectFile(cardL);
        this.add(newButton);
        this.add(selectButton);
        this.setVisible(true);
    }
}
