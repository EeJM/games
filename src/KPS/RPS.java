package KPS;

import Database.Repository;
import Startmenu.Startmenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;


public class RPS extends JFrame {
    
    private JPanel basePanel = new JPanel();
    
    private JLabel firstName = new JLabel("Player 1 Choise");
    private JLabel secondName = new JLabel("Player 2 Choise");
    private JLabel betText = new JLabel("Your Bet:");
    private JLabel pointsText = new JLabel("getName+ points:");
    private JLabel secondPointsText = new JLabel("getName+ points:");
     
    private String[] choises = {"Choose your element","Rock","Paper","Scissors"};
    
    private JComboBox firstList = new JComboBox(choises);
    private JComboBox secondList = new JComboBox(choises);
    
    private JButton playButton = new JButton("Play!");
    private JButton menuButton = new JButton("Menu");
    private JButton lock1 = new JButton("");
    private JButton lock2 = new JButton("");
    
    private JTextField points = new JTextField("0");
    private JTextField secondPoints = new JTextField("0");
    private JTextField bet = new JTextField("1");
    
    private Repository repo=new Repository();
    
    private boolean lock1visible=true;
    private boolean lock2visible=true;
    
    public RPS(final int myPoints,final String myUser, final int otherPoints, final String otherUser) {
        
        lock1.setText(myUser+" Lock");
        lock2.setText(otherUser+" Lock");
        
        lock1.setBackground(Color.GREEN);
        lock2.setBackground(Color.ORANGE);
        firstList.setForeground(Color.GREEN);
        secondList.setForeground(Color.ORANGE);
        
        
        points.setText(""+myPoints);
        
    GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup upperSideBySideGroupX = layout.createSequentialGroup();
        upperSideBySideGroupX.addComponent(firstList,200,200,200);
        upperSideBySideGroupX.addGap(10);
        upperSideBySideGroupX.addComponent(secondList);

        GroupLayout.SequentialGroup midSideBySideGroupX = layout.createSequentialGroup();
        midSideBySideGroupX.addComponent(firstName,100,100,200);
        midSideBySideGroupX.addComponent(lock1);
        midSideBySideGroupX.addGap(10);
        midSideBySideGroupX.addComponent(secondName,100,100,200);
        midSideBySideGroupX.addComponent(lock2);

        GroupLayout.SequentialGroup botSideBySideGroupX = layout.createSequentialGroup();
        botSideBySideGroupX.addComponent(betText);
        botSideBySideGroupX.addComponent(bet);
        botSideBySideGroupX.addGap(10);
        botSideBySideGroupX.addComponent(playButton);
        botSideBySideGroupX.addComponent(menuButton);
        
        GroupLayout.SequentialGroup lowerBotSideBySideGroupX = layout.createSequentialGroup();
        lowerBotSideBySideGroupX.addComponent(pointsText);
        lowerBotSideBySideGroupX.addComponent(points);
        lowerBotSideBySideGroupX.addGap(10);
        lowerBotSideBySideGroupX.addComponent(secondPointsText);
        lowerBotSideBySideGroupX.addComponent(secondPoints);
        
        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addGroup(upperSideBySideGroupX);
        baseX.addGroup(midSideBySideGroupX);
        baseX.addGroup(botSideBySideGroupX);
        baseX.addGroup(lowerBotSideBySideGroupX);

        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup lowerRowY = layout.createParallelGroup(BASELINE);
        lowerRowY.addComponent(pointsText);
        lowerRowY.addComponent(points,25,25,25);
        lowerRowY.addComponent(secondPointsText);
        lowerRowY.addComponent(secondPoints,25,25,25);

        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(firstList,50,50,50);
        botRowY.addComponent(secondList,50,50,50);

        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup(BASELINE);
        topRowY.addComponent(betText);
        topRowY.addComponent(bet);
        topRowY.addComponent(playButton);
        topRowY.addComponent(menuButton);

        GroupLayout.ParallelGroup midRowY = layout.createParallelGroup(BASELINE);
        midRowY.addComponent(firstName);
        midRowY.addComponent(lock1);
        midRowY.addComponent(secondName);
        midRowY.addComponent(lock2);

        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGap(10);
        baseY.addGroup(midRowY);
        baseY.addGap(10);
        baseY.addGroup(botRowY);
        baseY.addGap(10);
        baseY.addGroup(lowerRowY);

        layout.setVerticalGroup(baseY);
        
        this.add(basePanel); 
        this.setTitle("RPS");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(playButton);
        
        points.setEditable(false);
        secondPoints.setEditable(false);
        setResizable(false);
        
        firstList.setFont(new Font(Font.SERIF,Font.BOLD,18));
        secondList.setFont(new Font(Font.SERIF,Font.BOLD,18));
        
        firstName.setText(myUser+"´s Choise");
        secondName.setText(otherUser+"´s Choise");
        
        pointsText.setText(myUser+" Points:");
        secondPointsText.setText(otherUser+ " Points:");
        
        points.setText(myPoints+"");
        secondPoints.setText(otherPoints+"");
        
        
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strMyPoints = points.getText();
                int intMyPoints = Integer.parseInt(strMyPoints);
                new Startmenu(intMyPoints, myUser).setVisible(true);
                dispose();
            }
        });
            
         lock1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int koko=18;
                if(lock1visible) koko=0; 
                firstList.setFont(new Font(Font.SERIF,Font.BOLD,koko));
                firstList.setEnabled(!lock1visible);
                
                lock1visible=!lock1visible;
           }
        });
                  lock2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int koko=18;
                if(lock2visible) koko=0;
                secondList.setFont(new Font(Font.SERIF,Font.BOLD,koko));
                secondList.setEnabled(!lock2visible);
                
                lock2visible=!lock2visible;
           }
        });
        
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                values(myUser, otherUser);
                firstList.setFont(getFont());
                firstList.setEnabled(true);
                firstList.setSelectedItem("Choose your element");
                secondList.setFont(getFont());
                secondList.setEnabled(true);
                secondList.setSelectedItem("Choose your element");
                
            }
        });
        
    }
    private void values(String myUser, String otherUser) {
        
        int intMoneyLeft1 = Integer.parseInt(points.getText());
        int intMoneyLeft2 = Integer.parseInt(secondPoints.getText());
                
        int intBetAmount = Integer.parseInt(bet.getText());
                
        if (intBetAmount <= intMoneyLeft1 && intBetAmount <= intMoneyLeft2 && intBetAmount>0) {        
                
                intMoneyLeft1 = intMoneyLeft1 - intBetAmount;
                intMoneyLeft2 = intMoneyLeft2 - intBetAmount;
        
        if((firstList.getSelectedItem()=="Rock")&&(secondList.getSelectedItem()=="Rock")){
            JOptionPane.showMessageDialog(playButton, "Both chose Rock!", "Tie", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount;
        }
        else if((firstList.getSelectedItem()=="Paper")&&(secondList.getSelectedItem()=="Paper")){
            JOptionPane.showMessageDialog(playButton, "Both chose Paper!", "Tie", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount;
        }
        else if((firstList.getSelectedItem()=="Scissors")&&(secondList.getSelectedItem()=="Scissors")){
            JOptionPane.showMessageDialog(playButton, "Both chose Scissors!","Tie",JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount;
        }
        else if((firstList.getSelectedItem()=="Paper")&&(secondList.getSelectedItem()=="Rock")){
            JOptionPane.showMessageDialog(playButton, "Player "+myUser+" wins!\nPaper beats Rock!", "Winner",JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Scissors")&&(secondList.getSelectedItem()=="Paper")){
            JOptionPane.showMessageDialog(playButton,"Player "+myUser+" wins!\nScissors beats Paper!","Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Rock")&&(secondList.getSelectedItem()=="Scissors")){
            JOptionPane.showMessageDialog(playButton,"Player "+myUser+" wins!\nRock beats Scissors !","Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Scissors")&&(secondList.getSelectedItem()=="Rock")){
            JOptionPane.showMessageDialog(playButton,"Player "+otherUser+" wins!\nRock beats Scissor!", "Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount * 2;
        }
        else if ((firstList.getSelectedItem()=="Paper")&&(secondList.getSelectedItem()=="Scissors")){
            JOptionPane.showMessageDialog(playButton,"Player "+otherUser+" wins!\nScissor beats Paper!", "Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount * 2;
        }
        else if((firstList.getSelectedItem()=="Rock")&&(secondList.getSelectedItem()=="Paper")){
            JOptionPane.showMessageDialog(playButton,"Player "+otherUser+" wins!\nPaper beats Rock!", "Winner", JOptionPane.INFORMATION_MESSAGE);
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount * 2;
        }
        else{
            Error("Both players must choose an element.");
            intMoneyLeft1 = intMoneyLeft1 + intBetAmount;
            intMoneyLeft2 = intMoneyLeft2 + intBetAmount;
        }
        
        String strMoneyLeft1 = Integer.toString(intMoneyLeft1);
        String strMoneyLeft2 = Integer.toString(intMoneyLeft2);
        
        int success1=repo.updatePoints(strMoneyLeft1,myUser);
        if (success1==1){
            Error("Something went wrong.");
        }
        
        int success2=repo.updatePoints(strMoneyLeft2,otherUser);
        if (success2==1){
            Error("Something went wrong.");
        }
        
        points.setText(strMoneyLeft1);
        secondPoints.setText(strMoneyLeft2);
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
                new RPS(1000,"Testi", 2000, "testi2").setVisible(true);
            }
        });
   
        
    }
            
}
