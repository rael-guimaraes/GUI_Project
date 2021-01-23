/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_app_project.providerService.providerService;

import barber_app_project.registerUser.Provider;
import java.sql.Timestamp;

/**
 *
 * @author rael
 */
public class ProviderService {

    private int id;
    private Provider provider;
    private Timestamp date;                // entity for provider service

    public ProviderService() {

    }

    public ProviderService(int id, Provider provider, Timestamp date) {
        this.id = id;
        this.provider = provider;
        this.date = date;
    }

    public ProviderService(Provider provider, Timestamp date) {
        this.provider = provider;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
