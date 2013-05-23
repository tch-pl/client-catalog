package tch.code.clientcatalog.core.logic;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import tch.code.clientcatalog.core.service.data.dao.ClientDAO;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 *
 * @author tch
 */
@Qualifier(value="ClientService")
public class ClientServiceImpl implements ClientService {

    private final static Logger logger = Logger.getLogger(ClientServiceImpl.class);
        
    private ClientDAO clientDAO = null;

    public ClientServiceImpl() {
    }
    
    public ClientServiceImpl(ClientDAO dao) {
        this.setClientDAO(clientDAO);
    }
    
    
    
    public Collection<ClientDTO> findAllClients() {
        return clientDAO.findClients();        
    }

    public Collection<ClientDTO> findClients(int offset, int capacity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ClientDTO findClientById(int clientId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdateClient(ClientDTO clientData) {
        if (clientData.getClientId() != null) {
        } else {
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    protected ClientDAO getClientDAO() {
        return clientDAO;
    }

    protected void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}