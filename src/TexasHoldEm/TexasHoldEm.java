package TexasHoldEm;

import javax.swing.*;


public class TexasHoldEm extends JFrame{
    
    private JPanel basePanel = new JPanel();
    
    private JTextArea aiCard1 = new JTextArea("");
    private JTextArea aiCard2 = new JTextArea("");
    
    private JTextArea table1 = new JTextArea("");
    private JTextArea table2 = new JTextArea("");
    private JTextArea table3 = new JTextArea("");
    private JTextArea table4 = new JTextArea("");
    private JTextArea table5 = new JTextArea("");
    
    private JTextArea pCard1 = new JTextArea("");
    private JTextArea pCard2 = new JTextArea("");
    
    private JTextArea fundsLeft = new JTextArea("100");
    private JTextArea betAmount = new JTextArea("10");
    
    private JButton mainMenu = new JButton("Main menu");
    private JButton match = new JButton("Match");
    private JButton checkFold = new JButton("Check/fold");
    private JButton raise = new JButton("Raise");
    
    private JLabel fundsText = new JLabel("Funds:");
    private JLabel betText = new JLabel("Bet:");
    
    public TexasHoldEm() {
        
        GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);

        GroupLayout.SequentialGroup topRowX = layout.createSequentialGroup();
        topRowX.addComponent(aiCard1);
        topRowX.addComponent(aiCard2);
        topRowX.addComponent(mainMenu);

        GroupLayout.SequentialGroup midRowX = layout.createSequentialGroup();
        midRowX.addComponent(table1);
        midRowX.addComponent(table2);
        midRowX.addComponent(table3);
        midRowX.addComponent(table4);
        midRowX.addComponent(table5);

        GroupLayout.SequentialGroup botRowX = layout.createSequentialGroup();
        botRowX.addComponent(fundsText);
        botRowX.addComponent(fundsLeft);
        botRowX.addComponent(pCard1);
        botRowX.addComponent(pCard2);
        botRowX.addComponent(betText);
        botRowX.addComponent(betAmount);
        
        GroupLayout.SequentialGroup extraButtonGroupX = layout.createSequentialGroup();
        extraButtonGroupX.addComponent(match);
        extraButtonGroupX.addComponent(checkFold);
        extraButtonGroupX.addComponent(raise);

        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addGroup(topRowX);
        baseX.addGroup(midRowX);
        baseX.addGroup(botRowX);
        baseX.addGroup(extraButtonGroupX);

        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup();
        topRowY.addComponent(aiCard1);
        topRowY.addComponent(aiCard2);
        topRowY.addComponent(mainMenu);

        GroupLayout.ParallelGroup midRowY = layout.createParallelGroup();
        midRowY.addComponent(table1);
        midRowY.addComponent(table2);
        midRowY.addComponent(table3);
        midRowY.addComponent(table4);
        midRowY.addComponent(table5);

        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(fundsText);
        botRowY.addComponent(fundsLeft);
        botRowY.addComponent(pCard1);
        botRowY.addComponent(pCard2);
        botRowY.addComponent(betText);
        botRowY.addComponent(betAmount);
        
        GroupLayout.ParallelGroup extraButtonGroupY = layout.createParallelGroup();
        extraButtonGroupY.addComponent(match);
        extraButtonGroupY.addComponent(checkFold);
        extraButtonGroupY.addComponent(raise);

        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGroup(midRowY);
        baseY.addGroup(botRowY);
        baseY.addGroup(extraButtonGroupY);

        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.pack();
        this.setTitle("Texas hold em");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        aiCard1.setEditable(false);
        aiCard2.setEditable(false);
        
        table1.setEditable(false);
        table2.setEditable(false);
        table3.setEditable(false);
        table4.setEditable(false);
        table5.setEditable(false);
        
        pCard1.setEditable(false);
        pCard2.setEditable(false);
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TexasHoldEm().setVisible(true);
            }
        });
    }
    
}
