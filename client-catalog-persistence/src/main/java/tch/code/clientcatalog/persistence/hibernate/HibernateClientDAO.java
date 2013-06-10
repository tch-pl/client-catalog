package tch.code.clientcatalog.persistence.hibernate;

import java.util.List;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tch.code.clientcatalog.core.logic.ClientNotFoundException;
import tch.code.clientcatalog.core.service.data.dao.ClientDAO;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.persistence.hibernate.entity.client.Client;

/**
 * hibernate based implementation of
 * tch.code.clientcatalog.core.service.data.dao.
 *
 * @author tch
 */
@Repository
@Transactional
public class HibernateClientDAO extends GenericHibernateDAO<Client> implements ClientDAO {

    private static final ClientHibernateEntityBinder binder = new ClientHibernateEntityBinder();

    public HibernateClientDAO() {
        super(Client.class);
    }

    public HibernateClientDAO(Class<Client> clazz) {
        super(Client.class);
    }

    public List<ClientDTO> findClients() {
        List<Client> clients = this.findAll();

        return binder.buildDTOlist(clients);
    }

    public void removeClient(ClientDTO client) {
        this.delete(client.getClientId());
        logger.info("Client " + client.getClientId() + " removed");
        client.setClientId(null);
    }

    public void addClient(ClientDTO client) {
        Long id = this.save(binder.buildEntity(client));
        logger.info("Client " + id + " added");
        client.setClientId(id);
    }

    public void modifyClient(ClientDTO client) {
        this.update(binder.buildEntity(client));
        logger.info("Client " + client.getClientId() + " updated");        
    }

    public void deleteAllClients() {
        this.deleteAll();

    }

    public ClientDTO findClient(ClientDTO client) throws ClientNotFoundException {
        throw new ClientNotFoundException(client);
    }

    public ClientDTO findClient(Long clientId) throws ClientNotFoundException {
        return binder.bindToDTO(this.getById(clientId));
        
    }
}
