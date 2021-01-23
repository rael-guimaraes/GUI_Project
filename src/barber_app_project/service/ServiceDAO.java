/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.service;

import barber_app_project.config.DBConnection;
import barber_app_project.providerService.providerService.ProviderServiceDAO;
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
public class ServiceDAO {

    private ProviderServiceDAO providerServiceDAO;
    private RegisterUserDAO userDAO;

    public ServiceDAO() {
        providerServiceDAO = new ProviderServiceDAO();
        userDAO = new RegisterUserDAO();
    }

    // method to creat service request
    public void createServiceRequest(int userId, int providerServiceId) {
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to insert service into the database
            String query = "INSERT INTO service (user_id, provider_service_Id) VALUES  ('" + userId + "','" + providerServiceId + "');";
            // execute the query
            boolean rs = stmt.execute(query);

            // close the result set, the statment and the connection
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }
    // method to get the requested service by provider

    public List<Service> getRequestedServiceByProvider(int providerId, boolean acctive) {
        List<Service> serviceList = new ArrayList<>();

        try {
            // query to get the get the requested service by provider
            String query = "SELECT userProvider.username as providerName, u.username as userName, ps.provider_service_id, s.service_id, ps.provider_service_date, p.location "
                    + "FROM service AS s "
                    + "INNER JOIN provider_service AS ps ON ps.provider_service_id = s.provider_service_id "
                    + "INNER JOIN provider AS p ON p.provider_id = ps.provider_id "
                    + "INNER JOIN user AS userProvider ON p.user_id = userProvider.user_id "
                    + "INNER JOIN user AS u ON s.user_id = u.user_id "
                    + "WHERE p.provider_id = " + providerId + " "
                    + "AND s.accepted= " + acctive + ";";

            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // execute the query
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Service service = new Service();
                service.setUsername(rs.getString("userName"));
                service.setProviderName(rs.getString("providerName"));
                service.setId(rs.getInt("service_id"));
                service.setServiceDate(rs.getTimestamp("provider_service_date"));
                service.setProviderLocation(rs.getString("location"));

                serviceList.add(service);
            }
            // close the result set, the statment and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serviceList;
    }
    // method to accept the service

    public void acceptService(int serviceId) {

        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to update the service when accepted by provider
            String query = "UPDATE service SET accepted = true WHERE service_id = " + serviceId + ";";
            // execute the query
            stmt.execute(query);

            // close the result set, the statment and the connection
            conn.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // method to get the get the requested service by user
    public List<Service> getRequestedServiceByUser(int userId, boolean acctive) {
        List<Service> serviceList = new ArrayList<>();

        try {
            // query to get the get the requested service by user
            String q = "SELECT userProvider.username as providerName, u.username as userName, ps.provider_service_id, s.service_id, ps.provider_service_date, p.location "
                    + "FROM service AS s "
                    + "INNER JOIN provider_service AS ps ON ps.provider_service_id = s.provider_service_id "
                    + "INNER JOIN provider AS p ON p.provider_id = ps.provider_id "
                    + "INNER JOIN user AS userProvider ON p.user_id = userProvider.user_id "
                    + "INNER JOIN user AS u ON s.user_id = u.user_id "
                    + "WHERE u.user_id = " + userId + " "
                    + "AND s.accepted= " + acctive + ";";
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // execute the query
            ResultSet rs = stmt.executeQuery(q);

            while (rs.next()) {

                Service service = new Service();
                service.setUsername(rs.getString("userName"));
                service.setProviderName(rs.getString("providerName"));
                service.setId(rs.getInt("service_id"));
                service.setServiceDate(rs.getTimestamp("provider_service_date"));
                service.setProviderLocation(rs.getString("location"));

                serviceList.add(service);
            }
            // close the result set, the statment and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serviceList;
    }

}
