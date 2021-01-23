/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.login;

import barber_app_project.config.DBConnection;
import barber_app_project.registerUser.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rael
 */
public class LoginDAO {


    public User login(User user) {

        try {
                    // query to check if the user is a registered member
            String query = "SELECT * FROM user WHERE username = '" + user.getUsername() + "' AND password = '" + user.getPassword() + "';";
                  // get a connection to the database
            Connection conn = DBConnection.getConnection();
            
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            
             // execute the query
            ResultSet rs = stmt.executeQuery(query);

            user = new User();
            // loop throught the result set
            while (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
            }
             // close the result set, the statment and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            // loop through the SQL Exceptions 
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
   
}
