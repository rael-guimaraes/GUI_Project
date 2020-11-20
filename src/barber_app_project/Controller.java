/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rael
 */
    
public class Controller implements ActionListener{

    LoginPage loginpage;
    DataBase_connection dataBase_connection;
    
    public Controller(){
        this.loginpage = new LoginPage(this);
        this.dataBase_connection = new DataBase_connection();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String un = loginpage.getValueOne();
        String pw = loginpage.getValueTwo();
        
        User user = new User(un, pw);
                
        boolean result = dataBase_connection.login(user);
        
        String resultMessage = "Try again with valid credentials";
        
        if(result){
           // ProviderPage providerPage = new ProviderPage ();
            System.out.println("wellcome");
        }else{
        
        System.out.println(resultMessage);
        }
    }
    

} 

