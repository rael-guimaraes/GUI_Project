/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.registerUser;

/**
 *
 * @author rael
 */
public class User{
    private int id;
    private String username;
    private String phone;
    private String email;
    private String password;
    
    
    public User(){   
                                             // user entity. in this class the user information is setted and can be 
    }                                        // getted whenever its needed
                                               
    public User(String username, String phone, String email, String password ){
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
     public String getPhone() {
        return phone;
    }
      public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
