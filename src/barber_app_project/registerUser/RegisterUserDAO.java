/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.registerUser;

import barber_app_project.config.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rael
 */
public class RegisterUserDAO {

    public void register(User user) {
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to register user by inserting his information into database
            String query = "INSERT INTO user (username, phone, email, password) VALUES  ('" + user.getUsername() + "','" + user.getPhone() + "','" + user.getEmail() + "','" + user.getPassword() + "');";
            // execute the query
            boolean rs = stmt.execute(query);
            // close the result set, the statment and the connection
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public void register(Provider provider) {
        try {

            this.register(provider.getUser());
            User user = this.getUserByName(provider.getUser().getUsername());
            // query to register provider by inserting his information into database
            String query = "INSERT INTO provider (user_id,location) VALUES  ('" + user.getId() + "','" + provider.getLocation() + "');";
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // execute the query
            boolean rs = stmt.execute(query);
            // close the result set, the statment and the connection
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public User getUserByName(String name) {
        User user = new User();
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to get user information by username
            String query = "SELECT * FROM user WHERE username = '" + name + "'";
            // execute the query
            ResultSet rs = stmt.executeQuery(query);
            // loop through the result set
            while (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("user_id"));

            }
            // close the result set, the statment and the connection
            conn.close();
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User getUserById(int id) {
        User user = new User();
        try {
            // get connection to the database
            Connection conn = DBConnection.getConnection();
            // get a statment from the connection
            Statement stmt = conn.createStatement();
            // query to get user information by user_id
            String query = "SELECT * FROM user WHERE user_id = '" + id + "'";
            // execute the query
            ResultSet rs = stmt.executeQuery(query);
            // loop through the result set
            while (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("user_id"));

            }
            // close the result set, the statment and the connection
            conn.close();
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

}
