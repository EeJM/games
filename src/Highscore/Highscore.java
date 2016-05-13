package Highscore;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;


public class Highscore extends JFrame{
    
    private JTextArea highScores= new JTextArea();
    
//    private JPanel basePanel=new JPanel(new BorderLayout());
//    private JPanel pointPanel=new JPanel(new GridLayout(6,2));
//    
//    private JLabel name1=new JLabel();
//    private JLabel name2=new JLabel();
//    private JLabel name3=new JLabel();
//    private JLabel name4=new JLabel();
//    private JLabel name5=new JLabel();
//    private JLabel points1=new JLabel();
//    private JLabel points2=new JLabel();
//    private JLabel points3=new JLabel();
//    private JLabel points4=new JLabel();
//    private JLabel points5=new JLabel();
//    
//    private JButton menuButton=new JButton();

    
    public Highscore() {
        
        
        
        //this.add(basePanel);
        //this.pack();
        //this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Highscore().setVisible(true);
            }
        });
    }
    
}
