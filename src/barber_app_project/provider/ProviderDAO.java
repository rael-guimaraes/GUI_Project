/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.provider;

import barber_app_project.config.DBConnection;
import barber_app_project.providerService.providerService.ProviderServiceDAO;
import barber_app_project.registerUser.Provider;
import barber_app_project.registerUser.RegisterUserDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raelg
 */
public class ProviderDAO {

    // instatiation of the RegisterUserDAO class
    private RegisterUserDAO userDAO;

    public ProviderDAO() {
        userDAO = new RegisterUserDAO();
    }

    // method to get the provider by user_id
    public Provider getProviderByUserId(int userId) {

        // instantiation of the Provider entity
        Provider provider = new Provider();
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to get the provider by user_id
            String query = "SELECT * FROM  provider WHERE user_id = '" + userId + "';";
            // execute the query
            ResultSet rs = stmt.executeQuery(query);
            // loop through the result set
            while (rs.next()) {
                provider.setId(rs.getInt("provider_id"));
                provider.setLocation(rs.getString("location"));
                provider.setUser(userDAO.getUserById(userId));

            }
            // close the result set, the statment and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProviderServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return provider;
    }

    // method to get the provider by provider_id
    public Provider getProviderByProviderId(int providerId) {
        // instantiation of the Provider entity
        Provider provider = new Provider();
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to get the provider by provider_id
            String query = "SELECT * FROM  provider WHERE provider_id = '" + providerId + "';";
            // execute the query
            ResultSet rs = stmt.executeQuery(query);
            // loop through the result set
            while (rs.next()) {
                provider.setId(rs.getInt("provider_id"));
                provider.setLocation(rs.getString("location"));
                provider.setUser(userDAO.getUserById(rs.getInt("user_id")));

            }
            // close the result set, the statment and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProviderServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return provider;
    }
    // method to get available provider service slots

    public List<ProviderDTO> getProviderAvailableByNameOrLocation(String searchProvider) {

        List<ProviderDTO> providerList = new ArrayList<>();

        try {
            // query to get the available provider service
            String query = "select u.username, p.location,ps.provider_service_id, ps.provider_service_date "
                    + "from provider as p "
                    + "inner join user as u on p.user_id= u.user_id "
                    + "inner join provider_service as ps on ps.provider_id = p.provider_id ";
            if (searchProvider != null && !searchProvider.equals("")) {
                query += "and( u.username= '" + searchProvider + "'";
                query += "or p.location = '" + searchProvider + "')";
            }
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // execute the query
            ResultSet rs = stmt.executeQuery(query);
            // loop through the result set
            while (rs.next()) {
                ProviderDTO provider = new ProviderDTO();
                provider.setName(rs.getString("username"));
                provider.setLocation(rs.getString("location"));
                provider.setServiceDate(rs.getTimestamp("provider_service_date"));
                provider.setProviderServiceId(rs.getInt("provider_service_id"));

                providerList.add(provider);
            }
            // close the result set, the statment and the connection
            rs.close();
            stmt.close();
            conn.close();
            // loop through the SQL Exceptions
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return providerList;

    }

}
