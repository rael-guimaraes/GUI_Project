/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.providerService.providerService;

import barber_app_project.registerUser.Provider;
import barber_app_project.config.DBConnection;
import barber_app_project.provider.ProviderDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author rael
 */
public class ProviderServiceDAO {

    private ProviderDAO providerDAO;

    public ProviderServiceDAO() {
        providerDAO = new ProviderDAO();
    }

    public void insertAvailableSlot(ProviderService serviceDates) {
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to insert available provider_service_dates into database table
            String query = "INSERT INTO provider_service (provider_id, provider_service_date) VALUES  ('" + serviceDates.getProvider().getId() + "','" + serviceDates.getDate() + "');";
            // execute the query
            boolean rs = stmt.execute(query);

            // close the result set, the statment and the connection
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public ProviderService getProviderServiceByProviderServiceId(int providerServiceId) {
        ProviderService providerService = new ProviderService();
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to get the available provider_service by service_id
            String query = "SELECT * FROM  provider_service WHERE provider_service_id = '" + providerServiceId + "';";
            // execute the query
            ResultSet rs = stmt.executeQuery(query);
            // loop through the result set
            while (rs.next()) {
                providerService.setId(rs.getInt("provider_service_id"));
                providerService.setDate(rs.getTimestamp("provider_service_date"));
                providerService.setProvider(providerDAO.getProviderByProviderId(rs.getInt("provider_id")));

            }
            // close the result set, the statment and the connection

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProviderServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return providerService;
    }

}
