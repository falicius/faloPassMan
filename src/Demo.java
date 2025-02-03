import components.faloPasswordMan;

import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                faloPasswordMan passwordMan = new faloPasswordMan();
            }
        });
    }
}
