package Startmenu;

import Cointoss.Cointoss;
import Cointoss.Login;
import Cointoss.register;
import KPS.LoginToRps;
import KPS.RPS;
import TexasHoldEm.TexasHoldEm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Startmenu extends JFrame {
    
    private JLabel userLabel = new JLabel("something went wrong.");
    private JLabel pointsLabel = new JLabel("Something is wrong.");
    
    private JPanel basePanel = new JPanel(new GridLayout(3, 2));

    private JButton Cointoss = new JButton("Cointoss");
    private JButton RPS = new JButton("rock/paper/scissors");

    private JButton Snails = new JButton("Snails");
    private JButton texas = new JButton("Texas Hold'em");

    private JButton Highscores = new JButton("Highscores");
    private JButton Quit = new JButton("Quit");

    public Startmenu(final int myPoints, final String myUser) {
        
        userLabel.setFont(new Font(Font.SERIF,Font.BOLD,20));
        pointsLabel.setFont(new Font(Font.SERIF,Font.BOLD,20));
        
        userLabel.setText("User: "+myUser);
        pointsLabel.setText("Your points: "+myPoints);

        GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup topRowX = layout.createSequentialGroup();
        topRowX.addComponent(Cointoss, 200, 200, 200);
        topRowX.addComponent(RPS, 200, 200, 200);

        GroupLayout.SequentialGroup midRowX = layout.createSequentialGroup();
        midRowX.addComponent(Snails, 200, 200, 200);
        midRowX.addComponent(texas, 200, 200, 200);

        GroupLayout.SequentialGroup botRowX = layout.createSequentialGroup();
        botRowX.addComponent(Highscores, 200, 200, 200);
        botRowX.addComponent(Quit, 200, 200, 200);

        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addComponent(userLabel, GroupLayout.Alignment.CENTER);
        baseX.addComponent(pointsLabel, GroupLayout.Alignment.CENTER);
        baseX.addGroup(topRowX);
        baseX.addGroup(midRowX);
        baseX.addGroup(botRowX);

        layout.setHorizontalGroup(baseX);

        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup();
        topRowY.addComponent(Cointoss, 100, 100, 100);
        topRowY.addComponent(RPS, 100, 100, 100);

        GroupLayout.ParallelGroup midRowY = layout.createParallelGroup();
        midRowY.addComponent(Snails, 100, 100, 100);
        midRowY.addComponent(texas, 100, 100, 100);

        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(Highscores, 100, 100, 100);
        botRowY.addComponent(Quit, 100, 100, 100);

        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addComponent(userLabel);
        baseY.addComponent(pointsLabel);
        baseY.addGap(10);
        baseY.addGroup(topRowY);
        baseY.addGroup(midRowY);
        baseY.addGroup(botRowY);

        layout.setVerticalGroup(baseY);

        this.add(basePanel);
        this.setTitle("Main menu");
        this.setLocation(450, 130);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Cointoss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Cointoss(myPoints, myUser).setVisible(true);
                dispose();
            }
        });
        
        RPS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginToRps(myPoints, myUser).setVisible(true);
                dispose();
            }
        });

        texas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TexasHoldEm(myPoints, myUser).setVisible(true);
                dispose();
            }
        });
        
        Quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

}
