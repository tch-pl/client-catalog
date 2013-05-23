package tch.code.clientcatalog.persistence.hibernate;

import java.util.List;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Repository;
import tch.code.clientcatalog.core.service.data.dao.ClientDAO;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.persistence.hibernate.entity.client.Company;

/**
 * hibernate based implementation of tch.code.clientcatalog.core.service.data.dao.
 * @author tch
 */
@Repository
public class HibernateClientDAO extends GenericHibernateDAO<Company> implements ClientDAO {
    private Logger LOGGER = Logger.getLogger("HibernateCompanyDAO.class");
    
    public HibernateClientDAO() {        
        super(Company.class);
    }
    

    public HibernateClientDAO(Class<Company> clazz) {
        super(Company.class);
    }
    public List<ClientDTO> findClients() {
        List<Company> clients = this.findAll();
        
        return null;
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
