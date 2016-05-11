package KPS;

import Database.Repository;
import Startmenu.Startmenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;


public class SinglePlayerRPS extends JFrame {
    
    private JPanel basePanel = new JPanel();
    
    private JLabel betText = new JLabel("Your Bet:");
    private JLabel pointsText = new JLabel("getName+ points:");
     
    private String[] choises = {"Choose your element","Rock","Paper","Scissors"};
    
    private JComboBox firstList = new JComboBox(choises);
    
    private String botSelection="";
    
    private JButton playButton = new JButton("Play!");
    private JButton menuButton = new JButton("Menu");
    
    private JTextField points = new JTextField("0");
    private JTextField bet = new JTextField("1");
    
    private Repository repo=new Repository();
    
    private boolean lock1visible=true;
    
    public SinglePlayerRPS(final int myPoints,final String myUser) {
        
        firstList.setForeground(Color.RED);
        
        points.setText(""+myPoints);
        
    GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup upperSideBySideGroupX = layout.createSequentialGroup();
        upperSideBySideGroupX.addComponent(firstList);

        GroupLayout.SequentialGroup botSideBySideGroupX = layout.createSequentialGroup();
        botSideBySideGroupX.addComponent(betText);
        botSideBySideGroupX.addComponent(bet);
        botSideBySideGroupX.addComponent(playButton);
        botSideBySideGroupX.addComponent(menuButton);
        
        GroupLayout.SequentialGroup lowerBotSideBySideGroupX = layout.createSequentialGroup();
        lowerBotSideBySideGroupX.addComponent(pointsText);
        lowerBotSideBySideGroupX.addComponent(points);
        
        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addGroup(upperSideBySideGroupX);
        baseX.addGroup(botSideBySideGroupX);
        baseX.addGroup(lowerBotSideBySideGroupX);

        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup lowerRowY = layout.createParallelGroup(BASELINE);
        lowerRowY.addComponent(pointsText);
        lowerRowY.addComponent(points);

        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup(BASELINE);
        botRowY.addComponent(firstList,50,50,50);

        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup(BASELINE);
        topRowY.addComponent(betText);
        topRowY.addComponent(bet);
        topRowY.addComponent(playButton);
        topRowY.addComponent(menuButton);

        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGap(15);
        baseY.addGroup(botRowY);
        baseY.addGap(15);
        baseY.addGroup(lowerRowY);

        layout.setVerticalGroup(baseY);
        
        this.add(basePanel); 
        this.setTitle("Single player RPS");
        this.setVisible(true);
        this.pack();
        this.setSize(270, 180);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(playButton);
        
        points.setEditable(false);
        setResizable(false);
        
        firstList.setFont(new Font(Font.SERIF,Font.BOLD,18));
        
//        firstName.setText(myUser+"´s Choise");
        
        pointsText.setText(myUser+" Points:");
        
        points.setText(myPoints+"");
        
        
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strMyPoints = points.getText();
                int intMyPoints = Integer.parseInt(strMyPoints);
                new Startmenu(intMyPoints, myUser).setVisible(true);
                dispose();
            }
        });
        
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Random random = new Random();

                int result = random.nextInt(3);
            if (result == 0) {
                botSelection = "Scissors";
            }
            else if (result == 1) {
                botSelection = "Paper";
            }
            else {
                botSelection = "Rock";
            }
                
                values(myUser);
                firstList.setFont(getFont());
                firstList.setEnabled(true);
                firstList.setSelectedItem("Choose your element");               
            }
        });
    }
    private void values(String myUser) {
        
        int intMoneyLeft1 = Integer.parseInt(points.getText());
                
        int intBetAmount = Integer.parseInt(bet.getText());
                
        if (intBetAmount <= intMoneyLeft1&& intBetAmount>0) {        
                
                intMoneyLeft1 = intMoneyLeft1 - intBetAmount;

        
        if((firstList.getSelectedItem()=="Rock")&&(botSelection.equals("Rock"))){
            JOptionPane.showMessageDialog(playButton, "Both chose Rock!", "Tie", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
        }
        else if((firstList.getSelectedItem()=="Paper")&&(botSelection.equals("Paper"))){
            JOptionPane.showMessageDialog(playButton, "Both chose Paper!", "Tie", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
        }
        else if((firstList.getSelectedItem()=="Scissors")&&(botSelection.equals("Scissors"))){
            JOptionPane.showMessageDialog(playButton, "Both chose Scissors!","Tie",JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
        }
        else if((firstList.getSelectedItem()=="Paper")&&(botSelection.equals("Rock"))){
            JOptionPane.showMessageDialog(playButton, "Player "+myUser+" wins!\nPaper beats Rock!", "Winner",JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Scissors")&&(botSelection.equals("Paper"))){
            JOptionPane.showMessageDialog(playButton,"Player "+myUser+" wins!\nScissors beats Paper!","Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Rock")&&(botSelection.equals("Scissors"))){
            JOptionPane.showMessageDialog(playButton,"Player "+myUser+" wins!\nRock beats Scissors !","Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Scissors")&&(botSelection.equals("Rock"))){
            JOptionPane.showMessageDialog(playButton,"Bot wins!\nRock beats Scissor!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        }
        else if ((firstList.getSelectedItem()=="Paper")&&(botSelection.equals("Scissors"))){
            JOptionPane.showMessageDialog(playButton,"Bot wins!\nScissor beats Paper!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        }
        else if((firstList.getSelectedItem()=="Rock")&&(botSelection.equals("Paper"))){
            JOptionPane.showMessageDialog(playButton,"Bot wins!\nPaper beats Rock!", "Winner", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Error("You must choose an element.");
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
        }
        
        String strMoneyLeft1 = Integer.toString(intMoneyLeft1);
        
        int success1=repo.updatePoints(strMoneyLeft1,myUser);
        if (success1==1){
            Error("Something went wrong.");
        }
        
        points.setText(strMoneyLeft1);
        }
        else {
            Error("Invalid bet.");
        }
        
    }
    private void Error(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SinglePlayerRPS(1000,"Testi").setVisible(true);
            }
        });
   
        
    }
            
}
