/*
 */
package tch.code.clientcatalog.core.service.data.dao;

import java.util.List;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 *
 * @author tch
 */
public interface ClientDAO {

    /*
     *
     *
     */
    List<ClientDTO> findClients();

    void removeClient(ClientDTO client);

    /*
     * returns id
     *
     */    
    void addClient(ClientDTO client);

    void modifyClient(ClientDTO client);
}
