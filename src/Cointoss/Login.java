package Cointoss;

import Database.Repository;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {
    
    private JPanel basePanel=new JPanel();
    
    private JLabel userText=new JLabel("Your username:");
    private JLabel passText=new JLabel("Your password:");
    
    private JTextField userField=new JTextField(10);
    private JTextField passField=new JTextField(10);
    
    private JButton loginButton=new JButton("Login");
    
    private Repository repo=new Repository();
    
    public Login() {
        
        GroupLayout layout=new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup sideBySideGroupX=layout.createSequentialGroup();
        sideBySideGroupX.addComponent(userText);
        sideBySideGroupX.addComponent(userField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(passText);
        sideBySideGroupX.addComponent(passField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(loginButton);
        
        GroupLayout.ParallelGroup baseX=layout.createParallelGroup();
        baseX.addGroup(sideBySideGroupX);
        
        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup sideBySideGroupY=layout.createParallelGroup();
        sideBySideGroupY.addComponent(userText);
        sideBySideGroupY.addComponent(userField);
        sideBySideGroupY.addComponent(passText);
        sideBySideGroupY.addComponent(passField);
        sideBySideGroupY.addComponent(loginButton);
        
        GroupLayout.SequentialGroup baseY=layout.createSequentialGroup();
        baseY.addGroup(sideBySideGroupY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int points=repo.loginPoints(userField.getText(), passField.getText());
                new Cointoss(points).setVisible(true);
            }
        });
        
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
