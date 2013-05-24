package tch.code.clientcatalog.core.logic;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
     * gives a map that contains as a key page index and as value list of size
     * given in pageCapacity parameter
     *
     * @return client data collection that match for given range
     */
    Map<Integer, List> pageClients(int pageCapacity, Collection<ClientDTO> clients);

    /**
     * gives a list that contains pages with page content
     * given in pageCapacity parameter
     *
     * @return client data collection that match for given range
     */
    List<Page> listPages(int pageCapacity, Collection<ClientDTO> clients);
            
    /**
     * search for concrete client in data source
     *
     * @param clientId
     * @return client by id
     */
    ClientDTO findClientById(int clientId

    );
    
    /**
     * saves or updates client data
     * @param clientData 
     */
    void saveOrUpdateClient(ClientDTO clientData);
}
