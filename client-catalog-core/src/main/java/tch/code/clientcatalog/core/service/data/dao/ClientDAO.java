/*
 */
package tch.code.clientcatalog.core.service.data.dao;

import java.util.List;
import tch.code.clientcatalog.core.logic.ClientNotFoundException;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 *
 * @author tch
 */
public interface ClientDAO {

    /*
     * retrieves collection of all clients, default order is ascending by id, you can use utilities from this project to execute sort/page types of activities
     *
     */
    List<ClientDTO> findClients();

    
    /*
     * retrieves specified client, by default client should be looked up at least by id which is meant as its unique identyfier
     * 
     */
    ClientDTO findClient(ClientDTO client) throws ClientNotFoundException;
    
    /*
     * retrieves specified client by id as its unique identyfier 
     *
     */
    ClientDTO findClient(Long clientId) throws ClientNotFoundException;
    
    /**
     * removes client form repository, dto's id property will be nulled on successfylly deleted instance
     */
    void removeClient(ClientDTO client);

    /*
     * puts new client data into repository
     * returns id
     *
     */
    void addClient(ClientDTO client);

    
    /*
     * modyfies existing client data 
     * returns id
     *
     */    
    void modifyClient(ClientDTO client) throws ClientNotFoundException;
}
