package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private static final String CORRECT_PASSWORD = "yourPassword";

    private JPasswordField passwordField;
    private JButton loginButton;

    private JLabel loginText;

    public LoginScreen(HomeScreen homeScreen) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginText = new JLabel("Enter Password: ");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkPassword()) {
                    setVisible(false); // Hide the login screen
                    homeScreen.setVisible(true); // Show the home screen
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Incorrect password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(new GridLayout(3, 1));
        add(loginText);
        add(passwordField);
        add(loginButton);

        customizeDarkMode();
    }

    private void customizeDarkMode() {
        Color darkBackgroundColor = new Color(82, 82, 82);
        Color darkTextColor = new Color(200, 200, 200);

        getContentPane().setBackground(darkBackgroundColor);
        passwordField.setBackground(darkBackgroundColor);
        passwordField.setForeground(darkTextColor);
        loginButton.setBackground(darkBackgroundColor);
        loginButton.setForeground(darkTextColor);
        loginText.setBackground(darkBackgroundColor);
        loginText.setForeground(darkTextColor);
    }

    private boolean checkPassword() {
        char[] enteredPassword = passwordField.getPassword();
        String enteredPasswordString = new String(enteredPassword);
        return enteredPasswordString.equals(CORRECT_PASSWORD);
    }
}
