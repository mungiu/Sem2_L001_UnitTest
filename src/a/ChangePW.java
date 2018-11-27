package a;

import javax.swing.*;
import java.awt.*;

public class ChangePW extends JFrame{

    private final UIManager uim;
    private JTextField userName;
    private JPasswordField oldPW, newPW;

    private JLabel status;

    public ChangePW(a.UIManager _uim) {
        uim = _uim;
        initComps();
        setLocationRelativeTo(null); // center of the screen
    }

    private void initComps() {
        setSize(300, 150);
        status = new JLabel();
        JPanel content = new JPanel(new GridLayout(4, 2));

        JButton acceptButton = new JButton("Accept");
        acceptButton.addActionListener(actionEvent -> attemptChangePW());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(actionEvent -> {
            userName.setText("");
            oldPW.setText("");
            newPW.setText("");
            uim.change2Login();
        });


        userName = new JTextField();
        oldPW = new JPasswordField();
        newPW = new JPasswordField();

        content.add(new JLabel("User: "));
        content.add(userName);
        content.add(new JLabel("Current PW: "));
        content.add(oldPW);
        content.add(new JLabel("New PW: "));
        content.add(newPW);
        content.add(acceptButton);
        content.add(cancelButton);

        JPanel outer = new JPanel(new BorderLayout());
        outer.add(content, BorderLayout.CENTER);
        outer.add(status, BorderLayout.SOUTH);
        setContentPane(outer);
    }

    private void attemptChangePW() {
        String result = uim.changePassword(userName.getText(), Util.constructPassword(oldPW.getPassword()), Util.constructPassword(newPW.getPassword()));
        if(!"OK".equalsIgnoreCase(result)) {
            status.setText(result);
        } else {
            status.setText("");
            uim.change2Login();
        }
    }
}
