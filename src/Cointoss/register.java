package Cointoss;

import Database.Repository;
import java.awt.event.*;
import javax.swing.*;

public class register extends JFrame {
    
    private JPanel basePanel=new JPanel();
    
    private JLabel userText=new JLabel("Your username:");
    private JLabel passText=new JLabel("Your password:");
    
    private JTextField userField=new JTextField(10);
    private JPasswordField passField=new JPasswordField(10);
    
    private JButton registerButton=new JButton("Register");
    private JButton backButton=new JButton("Back");
    
    private Repository repo=new Repository();
    
    public register() {
        
        GroupLayout layout=new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup sideBySideGroupX=layout.createSequentialGroup();
        sideBySideGroupX.addComponent(userText);
        sideBySideGroupX.addComponent(userField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(passText);
        sideBySideGroupX.addComponent(passField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(registerButton);
        sideBySideGroupX.addComponent(backButton);
        
        GroupLayout.ParallelGroup baseX=layout.createParallelGroup();
        baseX.addGroup(sideBySideGroupX);
        
        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup sideBySideGroupY=layout.createParallelGroup();
        sideBySideGroupY.addComponent(userText);
        sideBySideGroupY.addComponent(userField);
        sideBySideGroupY.addComponent(passText);
        sideBySideGroupY.addComponent(passField);
        sideBySideGroupY.addComponent(registerButton);
        sideBySideGroupY.addComponent(backButton);
        
        GroupLayout.SequentialGroup baseY=layout.createSequentialGroup();
        baseY.addGroup(sideBySideGroupY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.pack();
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(registerButton);
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int successfulReg=repo.addUser(userField.getText(), new String(passField.getPassword()));
                if (successfulReg == 0) {
                    new Login().setVisible(true);
                    dispose();
                }
                else {
                    String message = "Something went wrong.";
                    JOptionPane.showMessageDialog(registerButton, message, "Registering failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });
        
    }
}
