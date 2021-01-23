/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.login;

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
    // calling the controller class

    LoginController controller;

// attributes which will be accessed outside the constructor
    JLabel name = new JLabel("please enter your name");
    JTextField nameTF = new JTextField(25);
    JLabel password = new JLabel("please enter your password");
    JTextField passwordTF = new JTextField(25);

    public LoginPage(LoginController controller) {

        this.controller = controller;

        /**
         * From line 32 to line 108 I have my constructor creating the
         * attributes for my Login page
         *
         */
        this.setVisible(true);
        this.setSize(700, 500);
        this.setTitle("Barber_app_project");

        BorderLayout manager = new BorderLayout();
        this.setLayout(manager);

        JPanel topPanel = new JPanel();
        GridLayout gridTopLayout = new GridLayout(1, 2);
        topPanel.setLayout(gridTopLayout);

        JLabel appName = new JLabel("Dublin Barber Booking");
        FlowLayout appLayout = new FlowLayout();
        appName.setLayout(appLayout);
        appLayout.setAlignment(FlowLayout.CENTER);

        JButton registerButton = new JButton("Register");
        registerButton.setActionCommand("register");
        registerButton.addActionListener(controller);

        JPanel topPanel_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel_1.add(registerButton);

        topPanel.add(appName);
        topPanel.add(topPanel_1);
        this.add(topPanel, BorderLayout.PAGE_START);

        JLabel button = new JLabel("");
        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(controller);

        JPanel centerPanel = new JPanel();

        JPanel centerPanel_10 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_100 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_21 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_22 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel_31 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_32 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        centerPanel_11.add(name);
        centerPanel_12.add(nameTF);
        centerPanel_21.add(password);
        centerPanel_22.add(passwordTF);
        centerPanel_31.add(button);
        centerPanel_32.add(submitButton);

        centerPanel.add(centerPanel_10);
        centerPanel.add(centerPanel_100);
        centerPanel.add(centerPanel_11);
        centerPanel.add(centerPanel_12);
        centerPanel.add(centerPanel_21);
        centerPanel.add(centerPanel_22);
        centerPanel.add(centerPanel_31);
        centerPanel.add(centerPanel_32);

        GridLayout centerLayout = new GridLayout(5, 2);
        centerPanel.setLayout(centerLayout);
        this.add(centerPanel, BorderLayout.CENTER);

        this.validate();
        this.repaint();
    }

    LoginPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // methods to get the entered values on name and password TextFields

    public String getValueOne() {
        return nameTF.getText();
    }

    public String getValueTwo() {
        return passwordTF.getText();

    }

}
