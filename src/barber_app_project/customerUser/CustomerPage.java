/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.customerUser;

import barber_app_project.config.LoggedUser;
import barber_app_project.registerUser.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import barber_app_project.service.ServiceController;

/**
 *
 * @author rael
 */
public class CustomerPage extends JFrame implements ActionListener {
    // universal variables which will be accessed outside the constructor. 

    JTextField providerN_L = new JTextField(20);
    JTextField enterFeedbackTF = new JTextField(30);
    JTextField feedBackProviderName = new JTextField(30);

    JTable table = new JTable();
    CustomerServiceController controller;
    // instatiation of the User class
    User user = new User();

    // constructor which creates the Customer page layout
    public CustomerPage() {
        // istatiation of the CustomerServiceController class
        controller = new CustomerServiceController();

        this.setVisible(true);
        this.setSize(1000, 600);
        this.setTitle("Barber_app_project");

        BorderLayout appName_manager = new BorderLayout();
        this.setLayout(appName_manager);

        JLabel appName = new JLabel("Dublin Barber Booking");
        JPanel appNamePanel = new JPanel();
        appNamePanel.add(appName);
        this.add(appNamePanel, BorderLayout.PAGE_START);

        JPanel mainArea = new JPanel();
        BorderLayout topLayout = new BorderLayout();
        mainArea.setLayout(topLayout);
        this.add(mainArea, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        GridLayout gridTopLayout = new GridLayout(1, 2);
        topPanel.setLayout(gridTopLayout);

        JLabel welcome = new JLabel("Welcome");
        FlowLayout welcomeLayout = new FlowLayout();
        welcome.setLayout(welcomeLayout);
        welcomeLayout.setAlignment(FlowLayout.LEFT);

        JLabel customerName = new JLabel(LoggedUser.getLoggedUser().getUsername());

        FlowLayout providerNameLayout = new FlowLayout();
        customerName.setLayout(providerNameLayout);
        providerNameLayout.setAlignment(FlowLayout.RIGHT);

        topPanel.add(welcome);
        topPanel.add(customerName);

        mainArea.add(topPanel, BorderLayout.PAGE_START);

        JLabel searchProvider = new JLabel("Please enter provider name or Location");

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchButton.setActionCommand("search");

        JLabel bookingInfo = new JLabel("You have the following date booked");
        JTable accepetedServiceTable = new JTable();
        JScrollPane acceptedServiceScrollPane = new JScrollPane(accepetedServiceTable);
        accepetedServiceTable.setPreferredSize(new Dimension(300, 500));
        String[] columnNames = {"Providername", "Location", "Available Time"};
        // filling the table rows with the accepted service
        DefaultTableModel tableModel = controller.createFilledDataModelAcceptedService(columnNames, LoggedUser.getLoggedUser().getId());
        accepetedServiceTable.setModel(tableModel);

        JPanel leftPanel = new JPanel();

        JPanel leftPanel_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel leftPanel_4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        leftPanel_1.add(searchProvider);
        leftPanel_2.add(providerN_L);
        leftPanel_3.add(searchButton);
        leftPanel_4.add(bookingInfo);
        leftPanel_5.add(acceptedServiceScrollPane);

        leftPanel.add(leftPanel_1);
        leftPanel.add(leftPanel_2);
        leftPanel.add(leftPanel_3);
        leftPanel.add(leftPanel_4);
        leftPanel.add(leftPanel_5);
        GridLayout leftLayout = new GridLayout(5, 1);
        leftPanel.setLayout(leftLayout);

        JLabel availableSlots = new JLabel("Available Slots for the chosen provider");

        JButton applyBookingButton = new JButton("Apply Booking");
        applyBookingButton.addActionListener(this);
        applyBookingButton.setActionCommand(APPLY_BOOKING);

        JScrollPane myScrollPane = new JScrollPane(table);

        table.setPreferredSize(new Dimension(300, 500));

        JPanel centerPanel = new JPanel();

        JPanel centerPanel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel_3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        centerPanel_1.add(availableSlots);
        centerPanel_2.add(myScrollPane);
        centerPanel_3.add(applyBookingButton);

        centerPanel.add(centerPanel_1);
        centerPanel.add(centerPanel_2);
        centerPanel.add(centerPanel_3);

        GridLayout centerLayout = new GridLayout(5, 1);
        centerPanel.setLayout(centerLayout);

        JLabel enterFeedback = new JLabel("Please enter your feedback about the provider");
        JLabel enterFeedbackProviderName = new JLabel("Please enter provider Name");
        JButton submitFeedback = new JButton("submit");
        submitFeedback.addActionListener(this);
        submitFeedback.setActionCommand("submit");
        JButton exitButton = new JButton("exit");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("exit");

        JPanel bottonPanel = new JPanel();

        JPanel bottonPanel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottonPanel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottonPanel_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottonPanel_4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottonPanel_5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottonPanel_6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        bottonPanel_1.add(enterFeedbackProviderName);
        bottonPanel_2.add(feedBackProviderName);
        bottonPanel_3.add(enterFeedback);
        bottonPanel_4.add(enterFeedbackTF);
        bottonPanel_5.add(submitFeedback);
        bottonPanel_6.add(exitButton);

        bottonPanel.add(bottonPanel_1);
        bottonPanel.add(bottonPanel_2);
        bottonPanel.add(bottonPanel_3);
        bottonPanel.add(bottonPanel_4);
        bottonPanel.add(bottonPanel_5);
        bottonPanel.add(bottonPanel_6);

        GridLayout bottonLayout = new GridLayout(6, 1);
        bottonPanel.setLayout(bottonLayout);

        mainArea.add(leftPanel, BorderLayout.LINE_START);
        mainArea.add(centerPanel, BorderLayout.CENTER);
        mainArea.add(bottonPanel, BorderLayout.PAGE_END);

        this.validate();
        this.repaint();

    }
    // setting the setActionCommand as a constant variable
    private static final String APPLY_BOOKING = "ApplyBooking";

    // method to get the user output
    public String getSearchProvider() {
        return providerN_L.getText();
    }

    public String getProviderFeedbackName() {
        return feedBackProviderName.getText();
    }

    public String getProviderFeedback() {
        return enterFeedbackTF.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * when the customer enters the provider name or location the JTable
         * will be filled with the available slots for the particular
         * provider/location. if none provider or location is entered all
         * available slots will be displayed.
         */
        if (e.getActionCommand().equals("search")) {
            String[] columnNames = {"Providername", "Location", "Availabla Time", "id"};
            DefaultTableModel tableModel = controller.createFilledDataModelAvailableService(columnNames, getSearchProvider());

            table.setModel(tableModel);
            // hiding the column with the provider_service_id from the user as this information is no relevant for the user
            table.removeColumn(table.getColumnModel().getColumn(3));
        }

        /**
         * when the customer choose the slot it will create a service request
         * for the chosen provider. using the provider_service _id as reference
         */
        if (e.getActionCommand().equals(APPLY_BOOKING)) {
            int providerServiceId = (int) table.getModel().getValueAt(table.getSelectedRow(), 3);
            ServiceController serviceController = new ServiceController();
            serviceController.createServiceRequest(providerServiceId);
        }

        // the application stops when the user logout
        if (e.getActionCommand().equals("exit")) {
            System.exit(0);

        }
    }

}
