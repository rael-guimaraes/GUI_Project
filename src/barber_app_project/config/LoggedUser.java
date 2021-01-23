
package barber_app_project.config;

import barber_app_project.registerUser.Provider;
import barber_app_project.registerUser.User;

/**
 *
 * @author rael
 */

//  static fields to hold the imformation about the logged user


public  class LoggedUser {
    private static User loggedUser;   // holds the logged customer information
    private static Provider loggedProvider;  //  holds the logged provider information
    
    private LoggedUser(){
        
    }

    public static Provider getLoggedProvider() {
        return loggedProvider;
    }

    public static void setLoggedProvider(Provider loggedProvider) { 
        LoggedUser.loggedProvider = loggedProvider;
    }
    

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User user) {
        loggedUser = user;
    }
}
 
