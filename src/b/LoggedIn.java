package b;

import javax.swing.*;

public class LoggedIn extends JFrame {

    public LoggedIn() {
        initComps();
        setLocationRelativeTo(null); // center of the screen
    }

    private void initComps() {
        setSize(300, 150);
        JPanel content = new JPanel();
        content.add(new JLabel("Congratulations, you're logged in"));
        setContentPane(content);
    }
}
