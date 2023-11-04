package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JLabel loginText;

    public LoginScreen() {
        initializeFrame();
        initializeComponents();
        setupLayout();
    }

    private void initializeFrame() {
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }
    private void initializeComponents() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // handle in controller
            }
        });
    }

    private void setupLayout(){
        this.setLayout( new GridLayout(3,2));
        add(new JLabel("Username:"));
        add(usernameField);

        add(new JLabel("Password: "));
        add(passwordField);

        add(new JLabel());
        add(loginButton);
    }

    public String getUsername(){
        return usernameField.getText();
    }

    public String getPassword(){
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }
    public void clearInputFields(){
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
        });
    }
}
