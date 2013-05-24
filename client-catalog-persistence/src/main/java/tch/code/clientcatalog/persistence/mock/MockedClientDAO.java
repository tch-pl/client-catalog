/*
 */
package tch.code.clientcatalog.persistence.mock;

import java.util.ArrayList;
import java.util.List;
import tch.code.clientcatalog.core.service.data.dao.ClientDAO;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.core.service.data.model.ClientDTOBuilder;

/**
 *
 * @author tch
 */
public class MockedClientDAO implements ClientDAO {

    List<ClientDTO> clients = new ArrayList<ClientDTO>();
    
    public List<ClientDTO> findClients() {
        
        ClientDTO client = ClientDTOBuilder.companyTypeClient();
        clients.add(client);
        return clients;
    }

    public void removeClient(ClientDTO client) {
        this.clients.remove(client);
    }

    public void addClient(ClientDTO client) {
        this.clients.add(client);
    }

    public void modifyClient(ClientDTO client) {
        this.clients.contains(client);
    }
}
