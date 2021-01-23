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
public class RegisterUserController {
    // method to register user
    public void register(User user){
        RegisterUserDAO dao = new RegisterUserDAO();
        dao.register(user);
    }
    // method to registrer provider
    public void register(Provider provider){
        RegisterUserDAO dao = new RegisterUserDAO();
        dao.register(provider);
    } 
    
}
