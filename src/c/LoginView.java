package c;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame{


    private UIManager uim;
    private JLabel statusLabel;
    private JTextField userNameTextfield;
    private JPasswordField passwordTextfield;
    private JLabel userNameLabel;
    private JLabel passwordLabel;

    public LoginView(c.UIManager _uim) {
        uim = _uim;
        initComps();
        addComponentsToFrame();
        setLocationRelativeTo(null); // center of the screen
    }

    private void initComps() {
        userNameTextfield = new JTextField();
        userNameLabel = new JLabel(" Username");
        passwordTextfield = new JPasswordField();
        passwordLabel = new JLabel(" Password");
        statusLabel = new JLabel("");
    }

    private void addComponentsToFrame() {
        setSize(300, 150);

        JButton login = new JButton("Log in");
        login.addActionListener(actionEvent -> attemptLogin());

        JButton register = new JButton("Register");
        register.addActionListener(actionEvent -> uim.goToRegisterPanel());

        JButton changePW = new JButton("Change Password");
        changePW.addActionListener(actionEvent ->  uim.goToChangePWPanel());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(userNameLabel);
        panel.add(userNameTextfield);
        panel.add(passwordLabel);
        panel.add(passwordTextfield);
        panel.add(login);
        panel.add(register);
        panel.add(new JLabel(""));
        panel.add(changePW);
        panel.add(statusLabel);


        setContentPane(panel);
    }

    private void attemptLogin() {
        String result = uim.validateLogin(userNameTextfield.getText(), Util.constructPassword(passwordTextfield.getPassword()));
        if(!result.equalsIgnoreCase("OK")) {
            statusLabel.setText(result);
        } else {
            statusLabel.setText("");
        }
    }


}
