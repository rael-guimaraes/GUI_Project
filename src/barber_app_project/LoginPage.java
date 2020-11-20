/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rael
 */
public class LoginPage extends JFrame {
    
Controller controller;
JLabel email = new JLabel("please enter your e-mail");
        JTextField emailTF = new JTextField(25);
        JLabel password = new JLabel("please enter your password");
        JTextField passwordTF = new JTextField(25);


    public LoginPage(Controller controller) {
        
        this.controller = controller;

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

        
        JLabel button = new JLabel("");
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(controller);

        JPanel centerPanel = new JPanel();

        JPanel centerPanel_11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_21 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_22 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_31 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_32 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        centerPanel_11.add(email);
        centerPanel_12.add(emailTF);
        centerPanel_21.add(password);
        centerPanel_22.add(passwordTF);
        centerPanel_31.add(button);
        centerPanel_32.add(submitButton);

        centerPanel.add(centerPanel_11);
        centerPanel.add(centerPanel_12);
        centerPanel.add(centerPanel_21);
        centerPanel.add(centerPanel_22);
        centerPanel.add(centerPanel_31);
        centerPanel.add(centerPanel_32);

        GridLayout centerLayout = new GridLayout(3, 2);
        centerPanel.setLayout(centerLayout);
        this.add(centerPanel, BorderLayout.CENTER);

        this.validate();
        this.repaint();
    }

    LoginPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
       public String getValueOne(){
        return emailTF.getText();
    }
    public String getValueTwo(){
        return passwordTF.getText();
    

    }

}
