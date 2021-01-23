/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.registerUser;

import barber_app_project.registerUser.User;

/**
 *
 * @author rael
 */
public class Provider {
    private String location;
    private User user;
    private int id;

    public void setUser(User user) {
        this.user = user;
    }

    public Provider() {
                                     // provider entity to set add get provider information
    }

    public Provider(User user, String location) {
        this.location = location;
        this.user = user;
    }
    public Provider(String location){
        this.location = location;
        
    }
    
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    

    public User getUser() {
        return user;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
  
}
