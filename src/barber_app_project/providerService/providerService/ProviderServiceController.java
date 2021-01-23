/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.providerService.providerService;

import barber_app_project.registerUser.Provider;
import barber_app_project.config.LoggedUser;
import barber_app_project.provider.ProviderDAO;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author rael
 */
public class ProviderServiceController {

    // instatiates ProviderServiceDAO and ProviderDAO class
    private ProviderServiceDAO providerServiceDAO;
    private ProviderDAO providerDAO;

    public ProviderServiceController() {
        providerServiceDAO = new ProviderServiceDAO();
        providerDAO = new ProviderDAO();
    }

    // method which convertes the data into Timestamp format to insert into database 
    private Timestamp convertStringToTimestamp(String dateString, String hourString) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
            // you can change format of date
            java.util.Date date = formatter.parse(dateString + " - " + hourString);
            Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }

    // method which creates the available slot defined by the provider
    public void createAvaileableSpot(String date, String hour) {
        ProviderService serviceDates = new ProviderService();
        serviceDates.setDate(convertStringToTimestamp(date, hour));
        serviceDates.setProvider(getProviderByUserId(LoggedUser.getLoggedProvider().getUser().getId()));

        providerServiceDAO.insertAvailableSlot(serviceDates);

    } // gets the provider by its user id

    public Provider getProviderByUserId(int userId) {
        return providerDAO.getProviderByUserId(userId);
    }
}
