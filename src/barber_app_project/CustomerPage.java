/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author rael
 */
public class CustomerPage extends JFrame {
    
    String[] mondayTimes = {"Monday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbMonday = new JComboBox(mondayTimes);
    String[] tuesdayTimes = {"Tuesday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbTuesday = new JComboBox(tuesdayTimes);
    String[] wednesdayTimes = {"Wednesday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbWednesday = new JComboBox(wednesdayTimes);
    String[] thursdayTimes = {"Thursday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbThursday = new JComboBox(thursdayTimes);
    String[] fridayTimes = {"Friday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbFriday = new JComboBox(fridayTimes);
    String[] saturdayTimes = {"Saturday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbSaturday = new JComboBox(saturdayTimes);
    String[] sundayTimes = {"Sunday", "9am", "10am", "11am", "12pm", "1pm", "2pm","3pm"};
    JComboBox cbSunday = new JComboBox(sundayTimes);
    
    
    public CustomerPage (){
        
        
    this.setVisible(true);
    this.setSize(700, 500);
    this.setTitle("My first Project");
    
    JLabel appName = new JLabel("App name goes here");
    JPanel appNamePanel = new JPanel();
    appNamePanel.add(appName);
    this.add(appNamePanel);
    
    BorderLayout manager = new BorderLayout();
    this.setLayout(manager);
    
    JLabel welcome = new JLabel("Welcome");
    JLabel customerName = new JLabel("Customer Name");
    
       JPanel topPanel = new JPanel();
       topPanel.setBackground(Color.red);
       topPanel.add(welcome);
       topPanel.add(customerName);
       
       JLabel searchProvider = new JLabel("Please enter provider name or Location");
       JTextField providerN_L = new JTextField(20);
       JButton searchButton = new JButton("Search");
       JLabel bookingInfo = new JLabel("You have the following date booked");
       JTextField bookingDetails = new JTextField(25);
       JButton cancelButton = new JButton("Cancel Booking");
       
       JPanel leftPanel = new JPanel();
       leftPanel.setBackground(Color.blue);
       leftPanel.add(searchProvider);
       leftPanel.add(providerN_L);
       leftPanel.add(searchButton);
       leftPanel.add(bookingInfo);
       leftPanel.add(bookingDetails);
       leftPanel.add(cancelButton);
       GridLayout leftLayout = new GridLayout(6, 1);
       leftPanel.setLayout(leftLayout);
       
       
       JLabel availableSlots = new JLabel("Availeable Slots for the chosen provider");
       JLabel showFeedback = new JLabel("feed back about the chosen provider");
       JTextField showFeedbackTF = new JTextField(30);
       
       
       cbMonday.setSelectedIndex(0);
       cbTuesday.setSelectedIndex(0);
       cbWednesday.setSelectedIndex(0);
       cbThursday.setSelectedIndex(0);
       cbFriday.setSelectedIndex(0);
       cbSaturday.setSelectedIndex(0);
       cbSunday.setSelectedIndex(0);
       
       
       
    
   
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.yellow);
    centerPanel.add(availableSlots);
    centerPanel.add(cbMonday);
    centerPanel.add(cbTuesday);
    centerPanel.add(cbWednesday);
    centerPanel.add(cbThursday);
    centerPanel.add(cbFriday);
    centerPanel.add(cbSaturday);
    centerPanel.add(cbSunday);
    centerPanel.add(showFeedback);
    centerPanel.add(showFeedbackTF);
    
    GridLayout centerLayout = new GridLayout(10, 1);
    centerPanel.setLayout(centerLayout);
    
    
    JLabel enterFeedback = new JLabel("Please enter your feedbac about the provider");
    JTextField enterFeedbackTF = new JTextField(30);
    JButton submitFeedback = new JButton("submit");
    JButton exitButton = new JButton("exit");
    
    JPanel bottonPanel = new JPanel();
    bottonPanel.setBackground(Color.green);
    bottonPanel.add(enterFeedback);
    bottonPanel.add(enterFeedbackTF);
    bottonPanel.add(submitFeedback);
    bottonPanel.add(exitButton);
    
    GridLayout bottonLayout = new GridLayout(4, 1);
    bottonPanel.setLayout(bottonLayout);
    
    
    
    this.add(topPanel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(bottonPanel, BorderLayout.PAGE_END);



    this.validate();
    this.repaint();
    
}
}
