/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.provider;

import java.sql.Timestamp;

/**
 *
 * @author rael
 */
public class ProviderDTO {
    
    private int providerServiceId;
    private String name;
    private String location;
    private Timestamp serviceDate;                      // Etity for the availeable_provider_service

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Timestamp serviceDate) {
        this.serviceDate = serviceDate;
    }

    public int getProviderServiceId() {
        return providerServiceId;
    }

    public void setProviderServiceId(int providerServiceId) {
        this.providerServiceId= providerServiceId;
    }
    
    
    
    
}
