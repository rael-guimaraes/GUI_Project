/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.service;

import barber_app_project.config.LoggedUser;
import barber_app_project.provider.ProviderDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raelg
 */
public class ServiceController {
    // instatiates ServiceDAO class
    private ServiceDAO dao; 

    public ServiceController() {
        dao= new ServiceDAO();
    }
    // method to create a service request
    public void createServiceRequest(int serviceId){
        Service service = new Service();
        dao.createServiceRequest(LoggedUser.getLoggedUser().getId(),serviceId);
    }
     // method to fill the rows in  JTable accepetedServioceTable
     public DefaultTableModel createFilledDataModel(String[] columnNames, int providerId, boolean accepted){
         DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
         
         List<Service> serviceList = dao.getRequestedServiceByProvider(providerId, accepted);

            for (Service iten : serviceList) {
                Object[] tableItens = {iten.getUsername(), iten.getServiceDate(), iten.getId()};

                tableModel.addRow(tableItens);

            }
        return tableModel;
    }
     public void acceptService(int serviceId){
         dao.acceptService(serviceId);
     }
   
}
