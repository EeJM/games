package Cointoss;

import Database.Repository;
import java.awt.event.*;
import javax.swing.*;

public class DelUser extends JFrame {
    
    private JPanel basePanel=new JPanel();
    
    private JLabel userText=new JLabel("Your username:");
    private JLabel passText=new JLabel("Your password:");
    
    private JTextField userField=new JTextField(10);
    private JPasswordField passField=new JPasswordField(10);
    
    private JButton deleteButton=new JButton("Delete");
    
    private Repository repo=new Repository();
    
    public DelUser() {
        
        GroupLayout layout=new GroupLayout(basePanel);
        basePanel.setLayout(layout);
        
        GroupLayout.SequentialGroup sideBySideGroupX=layout.createSequentialGroup();
        sideBySideGroupX.addComponent(userText);
        sideBySideGroupX.addComponent(userField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(passText);
        sideBySideGroupX.addComponent(passField,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE);
        sideBySideGroupX.addComponent(deleteButton);
        
        GroupLayout.ParallelGroup baseX=layout.createParallelGroup();
        baseX.addGroup(sideBySideGroupX);
        
        layout.setHorizontalGroup(baseX);
        
        GroupLayout.ParallelGroup sideBySideGroupY=layout.createParallelGroup();
        sideBySideGroupY.addComponent(userText);
        sideBySideGroupY.addComponent(userField);
        sideBySideGroupY.addComponent(passText);
        sideBySideGroupY.addComponent(passField);
        sideBySideGroupY.addComponent(deleteButton);
        
        GroupLayout.SequentialGroup baseY=layout.createSequentialGroup();
        baseY.addGroup(sideBySideGroupY);
        
        layout.setVerticalGroup(baseY);
        
        this.add(basePanel);
        this.pack();
        this.setTitle("Delete a user");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getRootPane().setDefaultButton(deleteButton);
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int successfulDel=repo.removeUser(userField.getText(), new String(passField.getPassword()));
                if (successfulDel == 1) {
                    new Login().setVisible(true);
                    dispose();
                }
                else {
                    String message = "Deleting the user failed.";
                    JOptionPane.showMessageDialog(deleteButton, message, "User doesn't exist or the password is wrong.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
    }
}
