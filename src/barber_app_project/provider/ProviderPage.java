/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.provider;

/**
 *
 * @author rael
 */
import barber_app_project.providerService.providerService.ProviderServiceController;
import barber_app_project.config.LoggedUser;
import barber_app_project.registerUser.User;
import barber_app_project.service.ServiceController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProviderPage extends JFrame implements ActionListener {
    // universal variables to be used in the class

    JTextField dateTF = new JTextField(12);
    JTextField timeTF = new JTextField(12);
    // instatiation for the user entity
    User user = new User();
    JTable requestedServiceTable = new JTable();
    JTable upComingTable = new JTable();
    // instantiation for the ServiceController class
    ServiceController serviceController = new ServiceController();

    // constructor where the provider page has been created
    public ProviderPage() {

        this.setVisible(true);
        this.setSize(900, 600);
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

        // getting and displaying the provider name
        JLabel providerName = new JLabel(LoggedUser.getLoggedProvider().getUser().getUsername());
        FlowLayout providerNameLayout = new FlowLayout();
        providerName.setLayout(providerNameLayout);
        providerNameLayout.setAlignment(FlowLayout.RIGHT);

        topPanel.add(welcome);
        topPanel.add(providerName);

        mainArea.add(topPanel, BorderLayout.PAGE_START);

        JLabel upComingEvents = new JLabel("UP COMING EVENTS");
        // update the table after the provider accepts the service
        updateUpcomingEventJtable();
        JScrollPane upComingScrollTable = new JScrollPane(upComingTable);
        upComingTable.setPreferredSize(new Dimension(300, 500));

        JLabel bookingRequest = new JLabel("You have the following booking requests");
        // update the table after the provider accepts the service 
        updateRequestedServiceJtable();

        JScrollPane myScrollPane = new JScrollPane(requestedServiceTable);
        requestedServiceTable.setPreferredSize(new Dimension(300, 500));

        JButton acceptBooking = new JButton("Accept booking");
        acceptBooking.addActionListener(this);
        acceptBooking.setActionCommand("acceptBooking");

        JPanel leftPanel = new JPanel();

        JPanel leftPanel_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel_5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        leftPanel_1.add(upComingEvents);
        leftPanel_2.add(upComingScrollTable);
        leftPanel_3.add(bookingRequest);
        leftPanel_4.add(myScrollPane);
        leftPanel_5.add(acceptBooking);

        leftPanel.add(leftPanel_1);
        leftPanel.add(leftPanel_2);
        leftPanel.add(leftPanel_3);
        leftPanel.add(leftPanel_4);
        leftPanel.add(leftPanel_5);

        GridLayout leftLayout = new GridLayout(5, 1);
        leftPanel.setLayout(leftLayout);

        JLabel setSlots = new JLabel("Set available slots");

        JLabel setDate = new JLabel("Set Date dd/mm/yy");
        JLabel setTime = new JLabel("Set Time hh:mm");
        setTime.setPreferredSize(new Dimension(100, 15));

        dateTF.setPreferredSize(new Dimension(100, 30));
        timeTF.setPreferredSize(new Dimension(100, 30));

        JButton setWorkButton = new JButton("Apply");
        setWorkButton.addActionListener(this);
        setWorkButton.setActionCommand("Apply");

        JPanel centerPanel = new JPanel();

        JPanel centerPanel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel_3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel_4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        centerPanel_1.add(setSlots);
        centerPanel_2.add(setDate);
        centerPanel_2.add(setTime);
        centerPanel_3.add(dateTF);
        centerPanel_3.add(timeTF);
        centerPanel_4.add(setWorkButton);

        centerPanel.add(centerPanel_1);
        centerPanel.add(centerPanel_2);
        centerPanel.add(centerPanel_3);
        centerPanel.add(centerPanel_4);

        GridLayout centerLayout = new GridLayout(6, 1);
        centerPanel.setLayout(centerLayout);

        JButton exitButton = new JButton("Logout");
        exitButton.addActionListener(this);
        exitButton.setActionCommand("logout");

        JPanel bottonPanel = new JPanel();

        FlowLayout exitButtonLayout = new FlowLayout();
        providerName.setLayout(exitButtonLayout);
        exitButtonLayout.setAlignment(FlowLayout.RIGHT);
        bottonPanel.add(exitButton);

        mainArea.add(leftPanel, BorderLayout.LINE_START);
        mainArea.add(centerPanel, BorderLayout.CENTER);
        mainArea.add(bottonPanel, BorderLayout.PAGE_END);

        this.validate();
        this.repaint();

    }

    // method to fill the rows of the JTable requestedService 
    private void updateRequestedServiceJtable() {
        String[] notAcceptedColumnNames = {"User name ", "service date", "id"};
        DefaultTableModel acceptedTableModel = serviceController.createFilledDataModel(notAcceptedColumnNames, LoggedUser.getLoggedProvider().getId(), false);

        requestedServiceTable.setModel(acceptedTableModel);
        requestedServiceTable.removeColumn(requestedServiceTable.getColumnModel().getColumn(2));
    }
// method to fill the rows of the JTable upComingEvents

    private void updateUpcomingEventJtable() {
        String[] acceptedColumnNames = {"User name ", "service date", "id"};
        DefaultTableModel tableModel = serviceController.createFilledDataModel(acceptedColumnNames, LoggedUser.getLoggedProvider().getId(), true);

        upComingTable.setModel(tableModel);
        upComingTable.removeColumn(upComingTable.getColumnModel().getColumn(2));
    }

    // method to get the user input
    public String getDateValue() {
        return dateTF.getText();
    }

    // method to get the user input
    public String getTimeValue() {
        return timeTF.getText();
    }
    // method to unify the inputs into one variable

    public String getavailableSlot() {
        String availableSlots = dateTF.getText() + timeTF.getText();
        return availableSlots;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // instanciates ProviderServiceController class
        ProviderServiceController controller = new ProviderServiceController();
        if (e.getActionCommand().equals("Apply")) {
            // converting user input into variable
            String date = getDateValue();
            String time = getTimeValue();
            controller.createAvaileableSpot(date, time);
        }

        // when provider accepts the service request the tables updates the values
        if (e.getActionCommand().equals("acceptBooking")) {
            int serviceId = (int) requestedServiceTable.getModel().getValueAt(requestedServiceTable.getSelectedRow(), 2);
            ServiceController serviceController = new ServiceController();
            serviceController.acceptService(serviceId);
            updateUpcomingEventJtable();
            updateRequestedServiceJtable();

        }
        // the application stops when the user logout
        if (e.getActionCommand().equals("logout")) {
            System.exit(0);
        }
    }

}
