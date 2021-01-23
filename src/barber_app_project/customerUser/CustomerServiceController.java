/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.customerUser;

import barber_app_project.provider.ProviderDAO;
import barber_app_project.provider.ProviderDTO;
import barber_app_project.service.ServiceDAO;
import barber_app_project.service.Service;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rael
 */
public class CustomerServiceController {
     // instanciating ProviderDAO and ServiceDAO class
    private ProviderDAO providerDAO;
    private ServiceDAO serviceDAO;

    public CustomerServiceController() {
        providerDAO = new ProviderDAO();
        serviceDAO = new ServiceDAO();
    }
  
            // loading CustomerPage
    private CustomerServiceController getController(CustomerPage customerPage) {
        if (customerPage.controller == null) {
            customerPage.controller = new CustomerServiceController();
        }
        return customerPage.controller;
    }         
                     // method to fill the Jtable table with the available slots by savind the date into tableModel
    public DefaultTableModel createFilledDataModelAvailableService(String[] columnNames, String searchProvider){
         DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
         
         List<ProviderDTO> listProvider = providerDAO.getProviderAvailableByNameOrLocation(searchProvider);

            for (ProviderDTO iten : listProvider) {
                Object[] tableItens = {iten.getName(), iten.getLocation(), iten.getServiceDate(), iten.getProviderServiceId()};

                tableModel.addRow(tableItens);

            }
        return tableModel;
    }
    // method to fill the Jtable acceptedServiceTable with the accepted request by the user by savind the date into tableModel
     public DefaultTableModel createFilledDataModelAcceptedService(String[] columnNames, int userId){
         DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
         
         List<Service> listService = serviceDAO.getRequestedServiceByUser(userId, true);

            for (Service iten : listService) {
                Object[] tableItens = {iten.getProviderName(), iten.getProviderLocation(), iten.getServiceDate()};

                tableModel.addRow(tableItens);

            }
        return tableModel;
    }
      

}
