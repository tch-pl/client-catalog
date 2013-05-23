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

    public List<ClientDTO> findClients() {
        List<ClientDTO> clients = new ArrayList<ClientDTO>();
        ClientDTO client = ClientDTOBuilder.companyTypeClient();
        clients.add(client);
        return clients;
    }

    public void removeClient(ClientDTO client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addClient(ClientDTO client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modifyClient(ClientDTO client) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
