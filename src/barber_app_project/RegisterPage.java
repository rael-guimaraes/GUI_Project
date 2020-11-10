/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rael
 */
public class RegisterPage extends JFrame implements ActionListener{
    String[] registrationOptions = {"customer", "provider"};
    JComboBox myCmb = new JComboBox(registrationOptions);
    JLabel text = new JLabel();
    
        
        public RegisterPage(){
        
        
        
     
        
        
        myCmb.setSelectedIndex(0);
        myCmb.addActionListener(this);
        add(myCmb);
        add(text);
        
        this.setVisible(true);
        this.setSize(700, 500);
        this.setTitle("My first Project");
        
        
       BorderLayout manager = new BorderLayout();
       this.setLayout(manager);
       
        JLabel appName = new JLabel("App name goes here");

        
       JPanel topPanel = new JPanel();
       topPanel.add(appName);
       topPanel.add(myCmb);
       topPanel.add(text);
       this.add(topPanel, BorderLayout.PAGE_START);
       
        JPanel centerPanel = new JPanel();
         
        JLabel name = new JLabel("please enter your name");
        JTextField nameTF = new JTextField(20);
        JLabel phone = new JLabel("please enter your phone number");
        JTextField phoneTF = new JTextField(20);
        JLabel email = new JLabel("please enter your e-mail");
        JTextField emailTF = new JTextField(20);
        JLabel location = new JLabel("please enter your location");
        JTextField locationTF = new JTextField(20);
        JLabel password = new JLabel("please enter your password");
        JTextField passwordTF = new JTextField(20);
        JLabel confirmPass = new JLabel("please confirm password");
        JTextField confirmPassTF = new JTextField(20);
        JLabel button = new JLabel("  ");
        JButton submitButton = new JButton("Submit");
        
        centerPanel.add(name);
        centerPanel.add(nameTF);
        centerPanel.add(phone);
        centerPanel.add(phoneTF);
        centerPanel.add(email);
        centerPanel.add(emailTF);
        centerPanel.add(location);
        centerPanel.add(locationTF);
        centerPanel.add(password);
        centerPanel.add(passwordTF);
        centerPanel.add(confirmPass);
        centerPanel.add(confirmPassTF);
        centerPanel.add(button);
        centerPanel.add(submitButton);
        
        GridLayout centerLayout = new GridLayout(7, 2);
        centerPanel.setLayout(centerLayout);
        this.add(centerPanel, BorderLayout.CENTER);
       
       this.validate();
       this.repaint();
        
        
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== myCmb ){
       
           JComboBox cb = (JComboBox)e.getSource();
           String msg = (String)cb.getSelectedItem();
           switch (msg){
           
               case "customer": text.setText("you are costumer");
                   break;
                case "provider": text.setText("you are provider");
                       break;
                default: text.setText("its not working");
                    
                
           }
       }
    }
        
        
        
        
        
        
    }
    
    
    

