package gui;

import model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeamItem extends JPanel {
    private static final Dimension TEAM_ITEM_SIZE = new Dimension(300, 80); // Adjust the size as needed
    private Team team;

    public TeamItem(Team team) {
        this.team = team;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(TEAM_ITEM_SIZE); // Set preferred size

        // Create a JPanel to hold the image and text
        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the team name label


        // Add an image to the left side
        ImageIcon teamIcon = new ImageIcon("src/main/images/FcLogo.png"); // Adjust the path
        JLabel iconLabel = new JLabel(teamIcon);
        contentPanel.add(iconLabel);

        JLabel teamNameLabel = new JLabel(team.getTeamName());
        contentPanel.add(teamNameLabel);

        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2,true));

        // Add the content panel to the TeamItem
        add(contentPanel);

        // Add MouseListener for click event
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleTeamItemClick();
            }
        });
    }

    private void handleTeamItemClick() {
        // Define the action to be performed when a TeamItem is clicked
        System.out.println("Team clicked: " + team.getTeamName());
        // You can open a new window, show details, etc.
    }

    @Override
    public String toString() {
        return this.team.getTeamName();
    }
}
