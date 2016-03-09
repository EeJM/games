package Startmenu;

import java.awt.*;
import javax.swing.*;


public class Startmenu extends JFrame {
    
        private JPanel basePanel = new JPanel(new GridLayout(3,2));
        
        private JButton register = new JButton("register");
        private JButton deleteUser = new JButton("delete User");
        
        private JButton Cointoss = new JButton("Cointoss");
        private JButton RPS = new JButton("rock/paper/scissors");
        
        private JButton Snails = new JButton("Snails");
        private JButton texas = new JButton("Texas Hold'em");
        
        private JButton Highscores = new JButton("Highscores");
        private JButton Quit = new JButton("Quit");
        
        public Startmenu() {
        
        GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup upperSideBySideGroupX = layout.createSequentialGroup();
        upperSideBySideGroupX.addComponent(register);
        upperSideBySideGroupX.addComponent(deleteUser);
        upperSideBySideGroupX.addComponent(Cointoss);
        upperSideBySideGroupX.addComponent(RPS);
        
        
        GroupLayout.SequentialGroup midSideBySideGroupX = layout.createSequentialGroup();
        midSideBySideGroupX.addComponent(Cointoss);
        midSideBySideGroupX.addComponent(RPS);
        
        GroupLayout.SequentialGroup lowMidSideBySideGroupX = layout.createSequentialGroup();
        lowMidSideBySideGroupX.addComponent(Snails);
        lowMidSideBySideGroupX.addComponent(texas);
        
        GroupLayout.SequentialGroup botSideBySideGroupX = layout.createSequentialGroup();
        botSideBySideGroupX.addComponent(Highscores);
        botSideBySideGroupX.addComponent(Quit);
        
        GroupLayout.SequentialGroup baseX = layout.createSequentialGroup();
        baseX.addGroup(upperSideBySideGroupX);
        baseX.addGroup(midSideBySideGroupX);
        baseX.addGroup(lowMidSideBySideGroupX);
        baseX.addGroup(botSideBySideGroupX);
        
        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup();
        topRowY.addComponent(register);
        topRowY.addComponent(deleteUser);
        
        GroupLayout.ParallelGroup upperMidY = layout.createParallelGroup();
        upperMidY.addComponent(Cointoss);
        upperMidY.addComponent(RPS);
        
        GroupLayout.ParallelGroup lowerMidY = layout.createParallelGroup();
        lowerMidY.addComponent(Snails);
        lowerMidY.addComponent(texas);
        
        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(Highscores);
        botRowY.addComponent(Quit);
        
        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGroup(upperMidY);
        baseY.addGroup(lowerMidY);
        baseY.addGroup(botRowY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.setTitle("Main menu");
        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
        
        
        
        
        
                
        
}
        public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Startmenu().setVisible(true);
            }
        });
    }
        
}
