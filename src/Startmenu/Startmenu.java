package Startmenu;

import Cointoss.Cointoss;
import Cointoss.register;
import TexasHoldEm.TexasHoldEm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        public Startmenu(int myPoints, final String myUser) {
        
        GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup upperSideBySideGroupX = layout.createSequentialGroup();
        upperSideBySideGroupX.addComponent(register,200, 200, 200);
        upperSideBySideGroupX.addComponent(deleteUser,200, 200, 200);
        
        
        GroupLayout.SequentialGroup midSideBySideGroupX = layout.createSequentialGroup();
        midSideBySideGroupX.addComponent(Cointoss,200, 200, 200);
        midSideBySideGroupX.addComponent(RPS,200, 200, 200);
        
        GroupLayout.SequentialGroup lowMidSideBySideGroupX = layout.createSequentialGroup();
        lowMidSideBySideGroupX.addComponent(Snails,200, 200, 200);
        lowMidSideBySideGroupX.addComponent(texas,200, 200, 200);
        
        GroupLayout.SequentialGroup botSideBySideGroupX = layout.createSequentialGroup();
        botSideBySideGroupX.addComponent(Highscores,200, 200, 200);
        botSideBySideGroupX.addComponent(Quit,200, 200, 200);
        
        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addGroup(upperSideBySideGroupX);
        baseX.addGroup(midSideBySideGroupX);
        baseX.addGroup(lowMidSideBySideGroupX);
        baseX.addGroup(botSideBySideGroupX);
        
        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup();
        topRowY.addComponent(register,100, 100, 100);
        topRowY.addComponent(deleteUser,100, 100, 100);
        
        GroupLayout.ParallelGroup upperMidY = layout.createParallelGroup();
        upperMidY.addComponent(Cointoss,100, 100, 100);
        upperMidY.addComponent(RPS,100, 100, 100);
        
        GroupLayout.ParallelGroup lowerMidY = layout.createParallelGroup();
        lowerMidY.addComponent(Snails,100, 100, 100);
        lowerMidY.addComponent(texas,100, 100, 100);
        
        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(Highscores,100, 100, 100);
        botRowY.addComponent(Quit,100, 100, 100);
        
        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGroup(upperMidY);
        baseY.addGroup(lowerMidY);
        baseY.addGroup(botRowY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.setTitle("Main menu");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
         Cointoss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Cointoss(myPoints, myUser).setVisible(true);
                dispose();
            }
        });
         
          Quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
          
            texas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TexasHoldEm().setVisible(true);
                dispose();
            }
        });
       
}
//        public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Startmenu().setVisible(true);
//            }
//        });
//    }
        
}
