package controller;

import manager.NavigationManager;
import model.UserModel;
import model.manager.TeamEntityManager;
import view.HomeScreen;
import view.LoginScreen;

import javax.swing.*;

public class LoginController {
    private UserModel userModel;
    private LoginScreen loginScreen;

    public LoginController(UserModel userModel, LoginScreen loginScreen) {
        this.userModel = userModel;
        this.loginScreen = loginScreen;

        setupListeners();
    }

    private void setupListeners() {
        this.loginScreen.getLoginButton().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = loginScreen.getUsername();
        String password = loginScreen.getPassword();

        if (isValidCredentials(username, password)) {
            userModel.setUsername(username);
            userModel.setPassword(password);

            loginScreen.clearInputFields();

            JOptionPane.showMessageDialog(null, "Login successful!");
            navigateToHomeScreen();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials, Please try again.");
        }
    }

    private boolean isValidCredentials(String username, String password){
        return username.equals("admin") && password.equals("admin");
    }

    private void navigateToHomeScreen() {
        TeamEntityManager teamManager = new TeamEntityManager();
        teamManager.addTeam("1.FC Köln");
        teamManager.addTeam("Bayern München");
        HomeScreen homeScreen = new HomeScreen(teamManager);

        NavigationManager.getInstance().navigateTo(homeScreen);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserModel userModel = new UserModel();
            LoginScreen loginScreen = new LoginScreen();
            LoginController loginController = new LoginController(userModel, loginScreen);

            loginScreen.setVisible(true);
        });
    }

}
