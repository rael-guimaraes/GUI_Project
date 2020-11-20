/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
       JPanel topPanel_11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
       JPanel topPanel_12 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
       
       topPanel_11.add(appName);
       topPanel_12.add(myCmb);
       topPanel.add(text);
       
       topPanel.add(topPanel_11);
       topPanel.add(topPanel_12);
       
       GridLayout topLayout = new GridLayout(1, 2);
       topPanel.setLayout(topLayout);
       this.add(topPanel, BorderLayout.PAGE_START);

         
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
        
                JPanel centerPanel = new JPanel();
        
        JPanel centerPanel_11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_21 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_22 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_31 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_32 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_41 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_42 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_51 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_52 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_61 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_62 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_71 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_72 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        centerPanel_11.add(name);
        centerPanel_12.add(nameTF);
        centerPanel_21.add(phone);
        centerPanel_22.add(phoneTF);
        centerPanel_31.add(email);
        centerPanel_32.add(emailTF);
        centerPanel_41.add(location);
        centerPanel_42.add(locationTF);
        centerPanel_51.add(password);
        centerPanel_52.add(passwordTF);
        centerPanel_61.add(confirmPass);
        centerPanel_62.add(confirmPassTF);
        centerPanel_71.add(button);
        centerPanel_72.add(submitButton);
        
            centerPanel.add(centerPanel_11);
            centerPanel.add(centerPanel_12);
            centerPanel.add(centerPanel_21);
            centerPanel.add(centerPanel_22);
            centerPanel.add(centerPanel_31);
            centerPanel.add(centerPanel_32);
            centerPanel.add(centerPanel_41);
            centerPanel.add(centerPanel_42);
            centerPanel.add(centerPanel_51);
            centerPanel.add(centerPanel_52);
            centerPanel.add(centerPanel_61);
            centerPanel.add(centerPanel_62);
            centerPanel.add(centerPanel_71);
            centerPanel.add(centerPanel_72);
           
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
    
    
    

