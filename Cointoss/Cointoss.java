package Cointoss;
//By: Eero, Niko & Thien
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import static javax.swing.GroupLayout.Alignment.BASELINE;

public class Cointoss extends JFrame {

    private JPanel basePanel = new JPanel();
    
    private JLabel flipText = new JLabel("Flip");
    private JLabel betText = new JLabel("Your bet: ");
    private JLabel fundsText = new JLabel("Your funds: ");

    private String[] choices = {"Heads", "Tails"};

    private JComboBox coinList = new JComboBox(choices);

    private JButton playButton = new JButton("Play!");

    private JTextField moneyLeft = new JTextField("100");
    private JTextField betAmount = new JTextField("");
    private JTextField coinSide = new JTextField("");
    
    private JRadioButton allIn = new JRadioButton("All in!");
    
    
    
    public Cointoss() {
        GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup upperSideBySideGroupX = layout.createSequentialGroup();
        upperSideBySideGroupX.addComponent(flipText);
        upperSideBySideGroupX.addComponent(coinSide);

        GroupLayout.SequentialGroup midSideBySideGroupX = layout.createSequentialGroup();
        midSideBySideGroupX.addComponent(betText);
        midSideBySideGroupX.addComponent(betAmount);
        midSideBySideGroupX.addComponent(coinList);
        midSideBySideGroupX.addComponent(playButton);
        midSideBySideGroupX.addComponent(allIn);

        GroupLayout.SequentialGroup botSideBySideGroupX = layout.createSequentialGroup();
        botSideBySideGroupX.addComponent(fundsText);
        botSideBySideGroupX.addComponent(moneyLeft);

        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addGroup(upperSideBySideGroupX);
        baseX.addGroup(midSideBySideGroupX);
        baseX.addGroup(botSideBySideGroupX);

        layout.setHorizontalGroup(baseX);

        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(flipText);
        botRowY.addComponent(coinSide);

        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup(BASELINE);
        topRowY.addComponent(betText);
        topRowY.addComponent(betAmount);
        topRowY.addComponent(coinList);
        topRowY.addComponent(playButton);
        topRowY.addComponent(allIn);

        GroupLayout.ParallelGroup midRowY = layout.createParallelGroup(BASELINE);
        midRowY.addComponent(fundsText);
        midRowY.addComponent(moneyLeft);

        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGroup(midRowY);
        baseY.addGroup(botRowY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        //this.pack();
        this.setTitle("Coin Tossing Game");
        this.setLocationRelativeTo(null);
        this.setSize(500,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        moneyLeft.setEditable(false);
        coinSide.setEditable(false);
        
        allIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (allIn.isSelected()) {
                betAmount.setText(moneyLeft.getText());
                betAmount.setEditable(false);
                break;
                }
                while (!allIn.isSelected()) {
                    betAmount.setEditable(true);
                    break;
                }
            }
        });
        
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int intMoneyLeft= Integer.parseInt(moneyLeft.getText());
                int intBetAmount= Integer.parseInt(betAmount.getText());
                
                int updatedMoney= intMoneyLeft-intBetAmount;
                String stringUpdatedMoney= Integer.toString(updatedMoney);
                
                moneyLeft.setText(stringUpdatedMoney);
                
                flipTheCoin();
                if (finalCoin == coinList.getSelectedItem()){
                    int winAmount= Integer.parseInt(betAmount.getText())*2;
                    String message="You won "+winAmount+"!";
                    String title="Winner!";
                    JOptionPane.showMessageDialog(playButton,message,title,JOptionPane.INFORMATION_MESSAGE);
                    
                    int newMoneyLeft= Integer.parseInt(moneyLeft.getText())+winAmount;//sick skills 
                    String stringMoneyLeft=Integer.toString(newMoneyLeft);
                    moneyLeft.setText(stringMoneyLeft);
                }
                else {
                    int lostAmount = Integer.parseInt(betAmount.getText());
                    String message="You lost "+lostAmount+"!";
                    String title="Loser!";
                    JOptionPane.showMessageDialog(playButton,message,title,JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }//Konstruktorin loppu
    
    String finalCoin;
    int result;
    
    private void flipTheCoin() {
        
        Random random=new Random();
        
        result = random.nextInt(2);
        if(result == 0){
            finalCoin = "Heads";
        }
        else {
            finalCoin = "Tails";
        }
        
        coinSide.setText(finalCoin);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Cointoss().setVisible(true);
            }
        });
    }
}
