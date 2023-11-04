package view;

import model.Team;
import model.manager.TeamEntityManager;
import model.observer.TeamObserver;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeScreen extends JFrame implements TeamObserver {


    private JPanel teamPanel;

    private JScrollPane teamScrollPane;
    private TeamEntityManager teamManager;
    public HomeScreen(TeamEntityManager teamManager){
        this.teamManager = teamManager;
        this.teamManager.addObserver(this);

        setTitle("Football Team Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        teamPanel = new JPanel();
        teamPanel.setLayout(new BoxLayout(teamPanel, BoxLayout.Y_AXIS));
        teamScrollPane = new JScrollPane(teamPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton addButton = new JButton("+");
        addButton.addActionListener(e -> showAddTeamDialog());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(teamScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        add(mainPanel);
        updateTeamList();

    }

    private void updateTeamList() {
        List<Team> teams = teamManager.getAllTeams();
        teamPanel.removeAll();

        // Set the layout manager to BoxLayout
        teamPanel.setLayout(new BoxLayout(teamPanel, BoxLayout.Y_AXIS));

        for (Team team : teams) {
            TeamItem teamItem = new TeamItem(team);
            teamPanel.add(teamItem);

            // Add rigid area for vertical spacing
            teamPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Adjust the spacing as needed
        }

        teamPanel.revalidate();
        teamPanel.repaint();
    }

    private void showAddTeamDialog(){
        String teamName = JOptionPane.showInputDialog(this, "Enter the team name:", "Add Team", JOptionPane.PLAIN_MESSAGE);
        if (teamName != null && !teamName.trim().isEmpty()) {
            // User entered a valid team name
            teamManager.addTeam(teamName.trim());
        }
    }

    @Override
    public void update() {
        updateTeamList();
    }
}
