package c;

import javax.swing.*;

class UIManager {

    private LoginView loginView;
    private FileIO fileIO;
    private RegisterView regView;
    private LoggedIn loggedIn;
    private ChangePW changePW;

    UIManager() {
        (loginView = new LoginView(this)).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        (regView = new RegisterView(this)).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        (loggedIn = new LoggedIn()).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        (changePW = new ChangePW(this)).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fileIO = new FileIO();
    }

    void start() {
        loginView.setVisible(true);
    }

    String validateLogin(String userName, String password) {
        String result = fileIO.validateUser(userName, password);
        if(!result.equalsIgnoreCase("OK")) {
            return result;
        }

        return result;
    }

    void goToRegisterPanel() {
        loginView.setVisible(false);
        regView.setVisible(true);
    }

    void change2Login() {
        regView.setVisible(false);
        changePW.setVisible(false);
        loginView.setVisible(true);
    }

    void addUser(String userName, String password) {
        fileIO.addUser(userName, password);
    }

    boolean userExists(String userName) {
        return fileIO.userExists(userName);
    }

    void goToChangePWPanel() {
        loggedIn.setVisible(false);
        changePW.setVisible(true);
    }

    public String changePassword(String text, String s, String s1) {
        return fileIO.changePassword(text, s, s1);
    }
}
