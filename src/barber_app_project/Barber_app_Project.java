/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;


/**
 *
 * @author rael
 */
public class Barber_app_Project  extends JFrame{

    /**public class Year2FirstProject extends JFrame {
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
              ProviderPage myPage = new ProviderPage();
             
    }
    public Barber_app_Project (){
        
        this.setVisible(true);
        this.setSize(700, 500);
        this.setTitle("My first Project");
        
       BorderLayout manager = new BorderLayout();
       this.setLayout(manager);
       
        JLabel appName = new JLabel("App name goes here");
        JButton registerButton = new JButton("Register");
        
       JPanel topPanel = new JPanel();
       topPanel.add(appName);
       topPanel.add(registerButton);
       this.add(topPanel, BorderLayout.PAGE_START);
       
        JPanel centerPanel = new JPanel();
         
        JLabel email = new JLabel("please enter your e-mail");
        JTextField emailTF = new JTextField(25);
        JLabel password = new JLabel("please enter your password");
        JTextField passwordTF = new JTextField(25);
        JButton submitButton = new JButton("Submit");
        
        centerPanel.add(email);
        centerPanel.add(emailTF);
        centerPanel.add(password);
        centerPanel.add(passwordTF);
        centerPanel.add(submitButton);
        
        GridLayout centerLayout = new GridLayout(3, 2);
        centerPanel.setLayout(centerLayout);
        this.add(centerPanel, BorderLayout.CENTER);
       
       this.validate();
       this.repaint();
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}

 

  
