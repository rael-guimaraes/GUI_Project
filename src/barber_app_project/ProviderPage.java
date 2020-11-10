/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;

/**
 *
 * @author rael
 */

import java.awt.*;
import javax.swing.*;


public class ProviderPage extends JFrame {
    
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
    


public ProviderPage(){

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
    JLabel providerName = new JLabel("Provider Name");
    
       JPanel topPanel = new JPanel();
       topPanel.setBackground(Color.red);
       topPanel.add(welcome);
       topPanel.add(providerName);

       
       
       JTextField upComimgEvents1 = new JTextField(20);
       JTextField upComimgEvents2 = new JTextField(20);
       JTextField upComimgEvents3 = new JTextField(20);
       JTextField upComimgEvents4 = new JTextField(20);
       JTextField upComimgEvents5 = new JTextField(20);
       JLabel bookingRequest = new JLabel("You have the following booking request");
       JTextField requestinfo = new JTextField(20);
       JButton acceptBooking = new JButton("Accept booking");
       JButton cancelBooking = new JButton("cancel Booking");

       
       JPanel leftPanel = new JPanel();
       leftPanel.setBackground(Color.blue);
       leftPanel.add(bookingRequest);
       leftPanel.add(upComimgEvents1);
       leftPanel.add(upComimgEvents2);
       leftPanel.add(upComimgEvents3);
       leftPanel.add(upComimgEvents4);
       leftPanel.add(upComimgEvents5);
       leftPanel.add(acceptBooking);
       leftPanel.add(cancelBooking);
       
       GridLayout leftLayout = new GridLayout(8, 1);
       leftPanel.setLayout(leftLayout);
       
       
       JLabel setSlots = new JLabel("Set available slots");
       
       cbMonday.setSelectedIndex(0);
       cbTuesday.setSelectedIndex(0);
       cbWednesday.setSelectedIndex(0);
       cbThursday.setSelectedIndex(0);
       cbFriday.setSelectedIndex(0);
       cbSaturday.setSelectedIndex(0);
       cbSunday.setSelectedIndex(0);
       
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.yellow);
    centerPanel.add(setSlots);
    centerPanel.add(cbMonday);
    centerPanel.add(cbTuesday);
    centerPanel.add(cbWednesday);
    centerPanel.add(cbThursday);
    centerPanel.add(cbFriday);
    centerPanel.add(cbSaturday);
    centerPanel.add(cbSunday);
    
    GridLayout centerLayout = new GridLayout(8, 1);
    centerPanel.setLayout(centerLayout);
    
    JButton exitButton = new JButton("exit");
    
    JPanel bottonPanel = new JPanel();
    bottonPanel.setBackground(Color.green);
    
    bottonPanel.add(exitButton);
    
    
       
       this.add(topPanel, BorderLayout.PAGE_START);
       this.add(leftPanel, BorderLayout.LINE_START);
       this.add(centerPanel, BorderLayout.CENTER);
       this.add(bottonPanel, BorderLayout.PAGE_END);
       
    this.validate();
    this.repaint();
               






}


}
