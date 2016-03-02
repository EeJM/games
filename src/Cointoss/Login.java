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
    private JButton registerButton=new JButton("Register");
    
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
        
        GroupLayout.SequentialGroup extraButtonGroupX=layout.createSequentialGroup();
        extraButtonGroupX.addComponent(registerButton);
        
        GroupLayout.ParallelGroup baseX=layout.createParallelGroup();
        baseX.addGroup(sideBySideGroupX);
        baseX.addGroup(extraButtonGroupX);
        
        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup sideBySideGroupY=layout.createParallelGroup();
        sideBySideGroupY.addComponent(userText);
        sideBySideGroupY.addComponent(userField);
        sideBySideGroupY.addComponent(passText);
        sideBySideGroupY.addComponent(passField);
        sideBySideGroupY.addComponent(loginButton);
        
        GroupLayout.ParallelGroup extraButtonGroupY=layout.createParallelGroup();
        extraButtonGroupY.addComponent(registerButton);
        
        GroupLayout.SequentialGroup baseY=layout.createSequentialGroup();
        baseY.addGroup(sideBySideGroupY);
        baseY.addGroup(extraButtonGroupY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.pack();
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(loginButton);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int points=repo.loginPoints(userField.getText(), passField.getText());
                //This tells the main class what user is currently playing.
                final String myUser=userField.getText();
                if (points > -1){
                    new Cointoss(points, myUser).setVisible(true);
                    dispose();
                }
                else {
                    String message = "Invalid username or password. Try again.";
                    JOptionPane.showMessageDialog(loginButton, message, "Login failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new register().setVisible(true);
                dispose();
            }
        });
        
    }
}
