package KPS;

import Startmenu.Startmenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class RPS extends JFrame {
    
    private JPanel basePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    private JLabel firstName = new JLabel("player 1 name");
    private JLabel secondName = new JLabel("player 2 name");
    private JLabel betText = new JLabel("Your Bet:");
    private JLabel pointsText = new JLabel("Points:");
     
    private String[] choises = {"","Rock","Paper","Scissors"};
    
    private JComboBox firstList = new JComboBox(choises);
    private JComboBox secondList = new JComboBox(choises);
    
    private JButton playButton = new JButton("Play!");
    private JButton menuButton = new JButton("Menu");
    
    private JTextField points = new JTextField("100");
    private JTextField bet = new JTextField("1");
    //private JTextField outCome = new JTextField("?");
    
    public RPS(final int myPoints, final String myUser) {
        
        points.setText(""+myPoints);
        
        basePanel.add(firstList);
        //basePanel.add(outCome);
        basePanel.add(secondList);
        basePanel.add(firstName);
        basePanel.add(secondName);
        basePanel.add(betText);
        basePanel.add(bet);
        basePanel.add(playButton);
        basePanel.add(menuButton);
        basePanel.add(pointsText);
        basePanel.add(points);
        
        this.add(basePanel);
        
        this.setTitle("Rock,Paper,Scissors");
        this.setSize(200,170);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //outCome.setEditable(false);
        bet.setEditable(false);
        points.setEditable(false);
        setResizable(false);//disables window resizing
        
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Startmenu(myPoints, myUser).setVisible(true);
                dispose();
            }
        });
        
    }
    
    String Answer;
    int result;
    private void Randomize() {

        Random random = new Random();

        result = random.nextInt(3);
        if (result == 0) {
            Answer = "Rock";
        } else if (result == 1) {
            Answer = "Paper";
        } else {
            Answer = "Scissors";
        }

        //outCome.setText(Answer);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RPS(1000,"Testi").setVisible(true);
            }
        });
   
        
    }
            
}
