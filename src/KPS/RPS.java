package KPS;

import java.awt.*;
import javax.swing.*;


public class RPS extends JFrame {
    
    private JPanel basePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    private JLabel firstName = new JLabel("player 1 name");
    private JLabel secondName = new JLabel("player 2 name");
    private JLabel betText = new JLabel("Your Bet:");
    private JLabel pointsText = new JLabel("Your Points:");
     
    private String[] choises = {"Rock","Paper","Scissors"};
    
    private JComboBox firstList = new JComboBox(choises);
    private JComboBox secondList = new JComboBox(choises);
    
    private JButton playButton = new JButton("Play!");
    private JButton menuButton = new JButton("Menu");
    
    private JTextField points = new JTextField("100");
    private JTextField bet = new JTextField("0");
    private JTextField outCome = new JTextField("?");
    
    public RPS(/*int myPoints, final String myUser*/) {
        
        //points.setText(""+myPoints);
        
        basePanel.add(firstList);
        basePanel.add(outCome);
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
        
        outCome.setEditable(false);
        bet.setEditable(false);
        points.setEditable(false);
        setResizable(false);//disables window resizing
        
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RPS().setVisible(true);
            }
        });
   
        
    }
            
}
