/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.login;

import barber_app_project.config.LoggedUser;
import barber_app_project.customerUser.CustomerPage;
import barber_app_project.provider.ProviderDAO;
import barber_app_project.provider.ProviderPage;
import barber_app_project.registerUser.RegisterUserPage;
import barber_app_project.registerUser.User;
import barber_app_project.registerUser.Provider;
import barber_app_project.providerService.providerService.ProviderServiceController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rael
 */
public class LoginController implements ActionListener {
// instatiation of the LoginPage, LoginDAO and ProviderDAO
    private LoginPage loginPage;
    private LoginDAO loginDAO;
    private ProviderDAO providerDAO;

    public LoginController() {
        this.loginPage = new LoginPage(this);
        this.loginDAO = new LoginDAO();
        this.providerDAO = new ProviderDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // brings the user to registratinPage 
        if (e.getActionCommand().equals("register")) {
            new RegisterUserPage();
        }

        if (e.getActionCommand().equals("Submit")) {
              // gets the user input and validate if the user is registered by consulting the database
            String un = loginPage.getValueOne();
            String pw = loginPage.getValueTwo();

            User user = new User(un, pw);

            user = loginDAO.login(user);

            String resultMessage = "Try again with valid credentials";
                   // if the user is a member he will be redirected to the corresponding page
            if (user != null && user.getId() != 0) {
                Provider provider = providerDAO.getProviderByUserId(user.getId());
                if (provider.getId() != 0) {
                    LoggedUser.setLoggedProvider(provider);
                    ProviderPage providerpage = new ProviderPage();
                } else {

                    LoggedUser.setLoggedUser(user);
                    CustomerPage providerpage = new CustomerPage();
                }
            } else {
                       
                System.out.println(resultMessage);
            }
        }

    }
}
