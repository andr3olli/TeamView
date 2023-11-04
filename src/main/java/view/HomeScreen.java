package view;

import controller.TeamController;
import model.Team;

import model.manager.TeamEntityManager;
import model.observer.TeamObserver;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HomeScreen extends JFrame implements TeamObserver {


    private JPanel teamPanel;
    private JScrollPane teamScrollPane;
    private JButton addButton;
    private TeamEntityManager teamManager;
    private TeamController teamController;
    public HomeScreen(){
        initializeFrame();
        initializeComponents();
    }

    public void setTeamManager(TeamEntityManager teamManager){
        this.teamManager = teamManager;
        this.teamManager.addObserver(this);
        updateTeamList();
    }
    public void setTeamController(TeamController teamController){
        this.teamController = teamController;
    }
    private void initializeFrame(){
        setTitle("Football Team Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
    private void initializeComponents() {

        teamPanel = new JPanel();
        teamPanel.setLayout(new BoxLayout(teamPanel, BoxLayout.Y_AXIS));
        teamScrollPane = new JScrollPane(teamPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        this.addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // handle in controller
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(teamScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        this.add(mainPanel);
    }



    public void updateTeamList() {
        List<Team> teams = teamManager.getAllTeams();
        teamPanel.removeAll();

        // Set the layout manager to BoxLayout
        teamPanel.setLayout(new BoxLayout(teamPanel, BoxLayout.Y_AXIS));

        for (Team team : teams) {
            TeamItem teamItem = new TeamItem(team);
            teamPanel.add(teamItem);

            // Add rigid area for vertical spacing
            teamPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Adjust the spacing as needed
        }

        teamPanel.revalidate();
        teamPanel.repaint();
    }

    @Override
    public void update() {
        updateTeamList();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setTeamManager(new TeamEntityManager());
            homeScreen.setVisible(true);
        });
    }
}
