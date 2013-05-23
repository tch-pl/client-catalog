package tch.code.clientcatalog.core.logic;

import java.util.Collection;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 * 
 * @author tch
 */
public interface ClientService {

    /**
     * search for complete collection of clients records in data source
     *
     * @return all available client data
     */
    Collection<ClientDTO> findAllClients();

    /**
     * search for part of collection with given bonduaries, the sort order is dependent on service implementation
     *
     * @return client data collection that match for given range
     */
    Collection<ClientDTO> findClients(int offset, int capacity);

    /**
     * search for concrete client in data source
     *
     * @param clientId
     * @return client by id
     */
    ClientDTO findClientById(int clientId);
    
    /**
     * saves or updates client data
     * @param clientData 
     */
    void saveOrUpdateClient(ClientDTO clientData);
    
}
