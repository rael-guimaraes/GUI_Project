/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.registerUser;

import barber_app_project.login.LoginController;
import barber_app_project.registerUser.RegisterUserController;
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
import javax.swing.WindowConstants;

/**
 *
 * @author rael
 */
public class RegisterUserPage extends JFrame implements ActionListener {

    // instantiates RegisterUserController class
    RegisterUserController controller;
    // universal variables to be used in the class
    JComboBox myComboBox = new JComboBox();
    JTextField userNameTF = new JTextField(20);
    JTextField phoneTF = new JTextField(20);
    JTextField emailTF = new JTextField(20);
    JTextField userpasswordTF = new JTextField(20);
    JLabel jlabel_location = new JLabel("please enter your location");
    JTextField locationTF = new JTextField(20);

    // constructor where the RegisterPage layout has been defined
    public RegisterUserPage() {

        this.controller = new RegisterUserController();

        myComboBox.setEditable(true);
        myComboBox.addItem("choose service type");
        myComboBox.addItem("customer");
        myComboBox.addItem("provider");

        myComboBox.setSelectedIndex(0);
        myComboBox.addActionListener(this);
        myComboBox.setActionCommand("myComboBox");
        add(myComboBox);

        this.setVisible(true);
        this.setSize(700, 500);
        this.setTitle("Barber_app_project");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout manager = new BorderLayout();
        this.setLayout(manager);

        JLabel appName = new JLabel("Dublin Barber Booking");

        JPanel topPanel = new JPanel();
        JPanel topPanel_11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel topPanel_12 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        topPanel_11.add(appName);
        topPanel_12.add(myComboBox);

        topPanel.add(topPanel_11);
        topPanel.add(topPanel_12);

        GridLayout topLayout = new GridLayout(1, 2);
        topPanel.setLayout(topLayout);
        this.add(topPanel, BorderLayout.PAGE_START);

        JLabel name = new JLabel("please enter your name");

        JLabel phone = new JLabel("please enter your phone number");

        JLabel email = new JLabel("please enter your e-mail");

        JLabel password = new JLabel("please enter your password");

        JLabel confirmPass = new JLabel("please confirm password");
        JTextField confirmPassTF = new JTextField(20);
        JLabel button = new JLabel("  ");
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitButton.setActionCommand("submit");

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
        centerPanel_12.add(userNameTF);
        centerPanel_21.add(phone);
        centerPanel_22.add(phoneTF);
        centerPanel_31.add(email);
        centerPanel_32.add(emailTF);
        centerPanel_41.add(jlabel_location);
        centerPanel_42.add(locationTF);
        centerPanel_51.add(password);
        centerPanel_52.add(userpasswordTF);
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
        // if a customer is registering location fields will be hidden as customer is not required to enter location
        Object selected = myComboBox.getSelectedItem();
        if (selected.toString().equals("customer")) {
            locationTF.setVisible(false);
            jlabel_location.setVisible(false);
            // if a provider the location fields will appear as providers are required to enter location
        } else {
            locationTF.setVisible(true);
            jlabel_location.setVisible(true);
        }
        if (e.getActionCommand().equals("submit")) {
            /**
             * when the user submit he will be register as customer or he will
             * be register as provider based on what he selected
             */
            String username = getValueOne();
            String phone = getValueTwo();
            String email = getValueThree();
            String password = getValueFive();

            User user = new User(username, phone, email, password);

            if (selected.toString().equals("provider")) {

                String location = getValueFour();

                Provider provider = new Provider(user, location);

                controller.register(provider);

            } else {
                controller.register(user);
            }
            new LoginController();

        }
    }
    // method to get user input

    public String getValueOne() {
        return userNameTF.getText();
    }

    public String getValueTwo() {
        return phoneTF.getText();
    }

    public String getValueThree() {
        return emailTF.getText();
    }

    public String getValueFour() {
        return locationTF.getText();
    }

    public String getValueFive() {
        return userpasswordTF.getText();
    }

}
