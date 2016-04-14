package KPS;

import Cointoss.register;
import Cointoss.DelUser;
import Database.Repository;
import Startmenu.Startmenu;
import java.awt.event.*;
import javax.swing.*;

public class LoginToRps extends JFrame {
    
    private JPanel basePanel=new JPanel();
    
    private JLabel userText=new JLabel("Your username:");
    private JLabel passText=new JLabel("Your password:");
    
    private JTextField userField=new JTextField(10);
    private JPasswordField passField=new JPasswordField(10);
    
    private JButton loginButton=new JButton("Login");
    private JButton quitButton=new JButton("Quit");
    private JButton botPlayer=new JButton("Single player");
    
    private Repository repo=new Repository();
    
    public LoginToRps(int myPoints, String myUser) {
        
        GroupLayout layout=new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup sideBySideGroupX=layout.createSequentialGroup();
        sideBySideGroupX.addComponent(userText);
        sideBySideGroupX.addComponent(userField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(passText);
        sideBySideGroupX.addComponent(passField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(loginButton);
        
        GroupLayout.SequentialGroup extraButtonGroupX=layout.createSequentialGroup();
        extraButtonGroupX.addComponent(quitButton);
        extraButtonGroupX.addComponent(botPlayer);
        
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
        extraButtonGroupY.addComponent(quitButton);
        extraButtonGroupY.addComponent(botPlayer);
        
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
                int otherPoints=repo.loginPoints(userField.getText(),new String(passField.getPassword()));
                //This tells the main class what user is currently playing.
                final String otherUser=userField.getText();
                final int myPoints1 = myPoints;
                final String myUser1 = myUser;
                
                if (otherPoints > -1 && !otherUser.equals(myUser)){
                    new RPS(myPoints1, myUser1, otherPoints, otherUser).setVisible(true);
                    dispose();
                }
                else {
                    String message = "Invalid username or password. Try again.";
                    JOptionPane.showMessageDialog(loginButton, message, "Login failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        botPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
