/*
 */
package tch.code.clientcatalog.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import org.springframework.transaction.annotation.Transactional;
import tch.code.clientcatalog.core.logic.ClientNotFoundException;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.core.service.data.model.ClientType;
import tch.code.clientcatalog.core.service.data.model.CompanyData;
import tch.code.clientcatalog.persistence.hibernate.HibernateClientDAO;
import tch.code.clientcatalog.persistence.mock.MockedClientDAO;

/**
 *
 * @author tch
 */
@ContextConfiguration(locations = "classpath:test/persistence-application-context.xml")
@TransactionConfiguration(defaultRollback = false, transactionManager = "customTransactionManager")
public class HibernateClientDAOTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private HibernateClientDAO hibernateClientDAO;

    //@Test
    public void mockTest() {
        MockedClientDAO mockedDAO = new MockedClientDAO();
        mockedDAO.addClient(new ClientDTO());
    }

    public HibernateClientDAO getHibernateClientDAO() {
        return hibernateClientDAO;
    }

    public void setHibernateClientDAO(HibernateClientDAO hibernateClientDAO) {
        this.hibernateClientDAO = hibernateClientDAO;
    }

    // Tests to run only when database is working
    @Test
    @Transactional
    public void findClientsTest() {
        List<ClientDTO> clients = getHibernateClientDAO().findClients();
        //assertTrue(clients.size() == 2);
    }

    @Test
    @Transactional
    public void addAndRemoveClientsTest() {

        String[] ctx = this.applicationContext.getBeanNamesForType(HibernateClientDAO.class);
        ctx.toString();
        //this.hibernateClientDAO = (HibernateClientDAO) this.applicationContext.getBean("hibernateClientDAO");
        getHibernateClientDAO().deleteAll();

        ClientDTO newOne = new ClientDTO();
        newOne.setType(ClientType.PRIVATE);
        newOne.setDescription("123");
        newOne.getPrivatePersonData().setFirstName("ALI");
        newOne.getPrivatePersonData().setLastName("BABA");
        getHibernateClientDAO().addClient(newOne);
        assertNotNull(newOne.getClientId());
        logger.info(newOne.getClientId());

        List<ClientDTO> clients = getHibernateClientDAO().findClients();
        assertTrue(clients.size() == 1);
        getHibernateClientDAO().removeClient(newOne);
        assertNull(newOne.getClientId());
        clients = getHibernateClientDAO().findClients();
        assertTrue(clients.isEmpty());
        newOne = new ClientDTO();
        newOne.setCompanyData(new CompanyData());
        newOne.getCompanyData().setCompanyName("BIG COMPANY");
        getHibernateClientDAO().addClient(newOne);
        try {
            getHibernateClientDAO().findClient(new ClientDTO());

        } catch (ClientNotFoundException ex) {
            Logger.getLogger(HibernateClientDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //        PrivatePerson newPrivatePerson = new PrivatePerson();
        //        newPrivatePerson.setClient(new Client()); 
        //        newPrivatePerson.getClientId()
        //        
        //        clients = clientDAO.findClients();
        //        assertTrue(clients.size() == 1);
        //clientDAO.removeClient(newOne);
        //clients = clientDAO.findClients();
        //assertTrue(clients.size() == 0);

    }
}
