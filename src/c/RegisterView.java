package c;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame{

    private final UIManager uim;
    private JTextField userNameField;
    private JPasswordField passwordField, retypePasswordField;
    private JButton acceptButton, cancelButton;
    private JLabel statusLabel;

    RegisterView(c.UIManager _uim) {
        uim = _uim;
        initComps();
        setLocationRelativeTo(null); // center of the screen
    }

    private void initComps() {
        setSize(300, 200);
        userNameField = new JTextField();
        passwordField = new JPasswordField();
        retypePasswordField = new JPasswordField();
        statusLabel = new JLabel();

        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(actionEvent -> {
            String result = acceptChanges();
            if(!"OK".equalsIgnoreCase(result)) {
                statusLabel.setText(result);
            } else {
                statusLabel.setText("");
                uim.addUser(userNameField.getText(), Util.constructPassword(passwordField.getPassword()));
                uim.change2Login();
            }
        });
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(actionEvent -> {
            uim.change2Login();
        });
        JPanel outer = new JPanel(new BorderLayout());
        JPanel content = new JPanel(new GridLayout(4, 2));
        content.add(new JLabel("User name:"));          content.add(userNameField);
        content.add(new JLabel("Password: "));          content.add(passwordField);
        content.add(new JLabel("Retype password: "));   content.add(retypePasswordField);
        content.add(acceptButton);                      content.add(cancelButton);

        outer.add(content, BorderLayout.CENTER);
        outer.add(statusLabel, BorderLayout.SOUTH);
        setContentPane(outer);
    }

    private String acceptChanges() {
        String un = userNameField.getText();
        String userNameCheck = validateUser(un);

        if ("OK".equalsIgnoreCase(userNameCheck)) return userNameCheck;

        return Util.validatePassword(
                Util.constructPassword(passwordField.getPassword()),
                Util.constructPassword(retypePasswordField.getPassword())
        );
    }

    private String validateUser(String un) {

        if(un.contains("#")) return "Username cannot contain #";
        if("".equals(un)) return "Username cannot be empty";
        if(uim.userExists(un)) return "Username already exists";
        if(un.length() < 4) return "Username must be longer than 4 chars";
        if(un.length() >14) return "Username must be less than 14 chars";

        return "OK";
    }
}
