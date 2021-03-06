package TexasHoldEm;

import Startmenu.Startmenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Stack;
import javax.swing.*;

public class TexasHoldEm extends JFrame {

    private JPanel basePanel = new JPanel();

    private JLabel aiCard1 = new JLabel("hidden");
    private JLabel aiCard2 = new JLabel("hidden");

    private JLabel currentPot = new JLabel("0");

    private JLabel table1 = new JLabel("hidden");
    private JLabel table2 = new JLabel("hidden");
    private JLabel table3 = new JLabel("hidden");
    private JLabel table4 = new JLabel("hidden");
    private JLabel table5 = new JLabel("hidden");

    private JLabel pCard1 = new JLabel("hidden");
    private JLabel pCard2 = new JLabel("hidden");

    private JTextField fundsLeft = new JTextField("Error");
    private JTextField betAmount = new JTextField("10");

    private JButton mainMenu = new JButton("Main menu");
    private JButton match = new JButton("Match");
    private JButton checkFold = new JButton("Check/fold");
    private JButton raise = new JButton("Raise");

    private JLabel aiAction = new JLabel("");

    private JLabel fundsText = new JLabel("Funds:");
    private JLabel betText = new JLabel("Bet:");

    private int laskuri = 0;

    private int bet;

    private boolean raised = false;

    private int raiseAmount;

    private Stack<Card> deck = new Stack<>();
    
    private Hand playerHand = new Hand();
    
    private Hand botHand = new Hand();

    private Timer kello = new Timer(3000,
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resetCards();
                }
            });

    public TexasHoldEm(final int myPoints, final String myUser) {

        shuffleDeck();

        GroupLayout layout = new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup topRowX = layout.createSequentialGroup();
        topRowX.addComponent(aiCard1, 100, 100, 100);
        //topRowX.addGap(30);
        topRowX.addComponent(aiCard2, 100, 100, 100);
        topRowX.addComponent(mainMenu);
        topRowX.addComponent(currentPot);

        GroupLayout.SequentialGroup midRowX = layout.createSequentialGroup();
        midRowX.addComponent(table1, 100, 100, 100);
        midRowX.addComponent(table2, 100, 100, 100);
        midRowX.addComponent(table3, 100, 100, 100);
        midRowX.addComponent(table4, 100, 100, 100);
        midRowX.addComponent(table5, 100, 100, 100);

        GroupLayout.SequentialGroup botRowX = layout.createSequentialGroup();
        botRowX.addComponent(fundsText);
        botRowX.addComponent(fundsLeft, 100, 100, 100);
        botRowX.addComponent(pCard1, 100, 100, 100);
        botRowX.addComponent(pCard2, 100, 100, 100);
        botRowX.addComponent(betText);
        botRowX.addComponent(betAmount);

        GroupLayout.SequentialGroup extraButtonGroupX = layout.createSequentialGroup();
        extraButtonGroupX.addComponent(match);
        extraButtonGroupX.addComponent(checkFold);
        extraButtonGroupX.addComponent(raise);
        extraButtonGroupX.addComponent(aiAction);

        GroupLayout.ParallelGroup baseX = layout.createParallelGroup();
        baseX.addGroup(topRowX);
        baseX.addGroup(midRowX);
        baseX.addGroup(botRowX);
        baseX.addGroup(extraButtonGroupX);

        layout.setHorizontalGroup(baseX);

        GroupLayout.ParallelGroup topRowY = layout.createParallelGroup();
        topRowY.addComponent(aiCard1, 50, 50, 50);
        topRowY.addComponent(aiCard2, 50, 50, 50);
        topRowY.addComponent(mainMenu, 50, 50, 50);
        topRowY.addComponent(currentPot, 50, 50, 50);

        GroupLayout.ParallelGroup midRowY = layout.createParallelGroup();
        midRowY.addComponent(table1, 50, 50, 50);
        midRowY.addComponent(table2, 50, 50, 50);
        midRowY.addComponent(table3, 50, 50, 50);
        midRowY.addComponent(table4, 50, 50, 50);
        midRowY.addComponent(table5, 50, 50, 50);

        GroupLayout.ParallelGroup botRowY = layout.createParallelGroup();
        botRowY.addComponent(fundsText, 50, 50, 50);
        botRowY.addComponent(fundsLeft, 50, 50, 50);
        botRowY.addComponent(pCard1, 50, 50, 50);
        botRowY.addComponent(pCard2, 50, 50, 50);
        botRowY.addComponent(betText, 50, 50, 50);
        botRowY.addComponent(betAmount, 50, 50, 50);

        GroupLayout.ParallelGroup extraButtonGroupY = layout.createParallelGroup();
        extraButtonGroupY.addComponent(match);
        extraButtonGroupY.addComponent(checkFold);
        extraButtonGroupY.addComponent(raise);
        extraButtonGroupY.addComponent(aiAction);

        GroupLayout.SequentialGroup baseY = layout.createSequentialGroup();
        baseY.addGroup(topRowY);
        baseY.addGroup(midRowY);
        baseY.addGroup(botRowY);
        baseY.addGroup(extraButtonGroupY);

        layout.setVerticalGroup(baseY);

        this.add(basePanel);
        this.setSize(500, 300);
        this.setTitle("Texas hold em");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        fundsLeft.setEditable(false);

        String myPointsString = Integer.toString(myPoints);
        fundsLeft.setText(myPointsString);

        dealPlayerCards();

        mainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Startmenu(myPoints, myUser).setVisible(true);
                dispose();
            }
        });
        match.setEnabled(false);
        
        match.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //match the current bet
                aiAction.setText("You matched the opponents bet.");
                bet();
            }
        });

        checkFold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (raised) {
                    resetCards();
                    aiAction.setText("You folded.");
                } else {
                    aiAction.setText("You checked.");
                    bet();
                }
            }
        });

        raise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new window that asks you how much you want to raise
                bet = bet + Integer.parseInt(betAmount.getText());
                raised = true;
                aiAction.setText("You raised "+betAmount.getText());
                bet();
            }
        });
    }

    private void bet() {

        if (raised) {
            bet = bet + Integer.parseInt(betAmount.getText());
            raised = false;
            //random one of these
            //small chance for fold
            //big chance for paying
            //a decent chance for raising raised = true;
        } else {
            //random one of these
            //big chance for check
            //small chance for raising raised = true;
            raiseAmount = 10;
            bet = bet + raiseAmount;
            currentPot.setText(Integer.toString(bet));
            raised = true;
            aiAction.setText("Opponent raised: " + raiseAmount);
        }

        match.setEnabled(raised);

        if (raised) {
            return;
        }

        if (laskuri == 0) {
            laskuri++;
            dealFirstTable();
        } else if (laskuri == 1) {
            laskuri++;
            dealSecondTable();
        } else if (laskuri == 2) {
            laskuri++;
            dealLastTable();
        } else if (laskuri == 3) {
            laskuri++;
            match.setEnabled(false);
            checkFold.setEnabled(false);
            raise.setEnabled(false);
            showAiCards();
            //dealPoints();
            laskuri = 0;
        }
    }

    private void dealPlayerCards() {

        Card card = deck.pop();
        
        playerHand.addCard(card);

        pCard1.setText(card.toString());
        pCard1.setForeground(card.getColour());

        card = deck.pop();
        
        playerHand.addCard(card);
        
        pCard2.setText(card.toString());
        pCard2.setForeground(card.getColour());
    }

    private void shuffleDeck() {

        for (int i = 1; i < 14; i++) {

            deck.add(new Card(i, "spades"));
            deck.add(new Card(i, "hearts"));
            deck.add(new Card(i, "clubs"));
            deck.add(new Card(i, "diamonds"));
        }

        Collections.shuffle(deck);
        Collections.shuffle(deck);
        Collections.shuffle(deck);
    }

    private void dealFirstTable() {

        currentPot.setText(Integer.toString(bet));

        Card card = deck.pop();
        
        playerHand.addCard(card);
        botHand.addCard(card);

        table1.setText(card.toString());
        table1.setForeground(card.getColour());

        card = deck.pop();
        
        playerHand.addCard(card);
        botHand.addCard(card);
        
        table2.setText(card.toString());
        table2.setForeground(card.getColour());

        card = deck.pop();
        
        playerHand.addCard(card);
        botHand.addCard(card);
        
        table3.setText(card.toString());
        table3.setForeground(card.getColour());
    }

    private void dealSecondTable() {

        currentPot.setText(Integer.toString(bet));
        
        Card card = deck.pop();
        
        playerHand.addCard(card);
        botHand.addCard(card);
        
        table4.setText(card.toString());
        table4.setForeground(card.getColour());
    }

    private void dealLastTable() {

        currentPot.setText(Integer.toString(bet));
        
        Card card = deck.pop();
        
        playerHand.addCard(card);
        botHand.addCard(card);
        
        table5.setText(card.toString());
        table5.setForeground(card.getColour());
    }

    private void showAiCards() {
        currentPot.setText(Integer.toString(bet));

        Card card = deck.pop();
        
        botHand.addCard(card);
        
        aiCard1.setText(card.toString());
        aiCard1.setForeground(card.getColour());

        card = deck.pop();
        
        botHand.addCard(card);
        
        aiCard2.setText(card.toString());
        aiCard2.setForeground(card.getColour());
        
        System.out.println(playerHand);
        System.out.println(botHand);

        kello.start();
    }

    private void resetCards() {

        aiCard1.setText("hidden");
        aiCard1.setForeground(Color.black);
        aiCard2.setText("hidden");
        aiCard2.setForeground(Color.black);

        table1.setText("hidden");
        table1.setForeground(Color.black);
        table2.setText("hidden");
        table2.setForeground(Color.black);
        table3.setText("hidden");
        table3.setForeground(Color.black);
        table4.setText("hidden");
        table4.setForeground(Color.black);
        table5.setText("hidden");
        table5.setForeground(Color.black);
        
        playerHand.reset();
        botHand.reset();

        bet = 0;
        currentPot.setText("0");

        laskuri = 0;

        raised = false;

        shuffleDeck();

        Card card = deck.pop();
        
        playerHand.addCard(card);
        
        pCard1.setText(card.toString());
        pCard1.setForeground(card.getColour());

        card = deck.pop();
        
        playerHand.addCard(card);
        
        pCard2.setText(card.toString());
        pCard2.setForeground(card.getColour());

        kello.stop();
        aiAction.setText("");
        match.setEnabled(raised);
        checkFold.setEnabled(true);
        raise.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TexasHoldEm(1000, "Test").setVisible(true);
            }
        });
    }

}
