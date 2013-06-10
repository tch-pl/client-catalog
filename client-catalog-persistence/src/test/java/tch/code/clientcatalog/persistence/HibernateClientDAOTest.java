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
import tch.code.clientcatalog.core.service.data.model.PrivatePersonData;
import tch.code.clientcatalog.persistence.hibernate.HibernateClientDAO;
import tch.code.clientcatalog.persistence.hibernate.entity.client.Client;
import tch.code.clientcatalog.persistence.hibernate.entity.client.PrivatePerson;
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
    public void addAndRemoveClientsTest() {
        getHibernateClientDAO().deleteAll();
        ClientDTO newOne = new ClientDTO();
        newOne.setType(ClientType.PRIVATE);
        newOne.setDescription("123");

        PrivatePersonData privatePersonDTO = new PrivatePersonData();
        privatePersonDTO.setFirstName("ALI");
        privatePersonDTO.setLastName("BABA");
        newOne.getPrivatePersonData().add(privatePersonDTO);

        getHibernateClientDAO().addClient(newOne);
        assertNotNull(newOne.getClientId());
        logger.info(newOne.getClientId());

        List<ClientDTO> clients = getHibernateClientDAO().findClients();
        assertTrue(clients.size() == 1);
        assertTrue(clients.get(0).getPrivatePersonData().size() == 1);
        //getHibernateClientDAO().delete(newOne.getClientId());
//        assertNull(newOne.getClientId());
//        clients = getHibernateClientDAO().findClients();
//        assertTrue(clients.isEmpty());
//        newOne = new ClientDTO();
//        newOne.setCompanyData(new CompanyData());
//        newOne.getCompanyData().setCompanyName("BIG COMPANY");
//        getHibernateClientDAO().addClient(newOne);
    }

    //@Test
    @Transactional
    public void findClientsTest() {
        List<ClientDTO> clients = getHibernateClientDAO().findClients();
        assertTrue(clients.size() > 0);
    }

    @Test(expectedExceptions = ClientNotFoundException.class)
    @Transactional
    public void clientExceptionTest() throws ClientNotFoundException {
        try {
            getHibernateClientDAO().findClient(new ClientDTO());
        } catch (ClientNotFoundException ex) {
            Logger.getLogger(HibernateClientDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        ClientDTO newOne = new ClientDTO();
        newOne.setType(ClientType.PRIVATE);
        newOne.setDescription("123");
        PrivatePersonData privatePersonDTO = new PrivatePersonData();
        privatePersonDTO.setFirstName("ALI");
        privatePersonDTO.setLastName("BABA");
        newOne.getPrivatePersonData().add(privatePersonDTO);
        getHibernateClientDAO().addClient(newOne);
        assertNotNull(newOne.getClientId());
        getHibernateClientDAO().removeClient(newOne);
        try {
            getHibernateClientDAO().findClient(newOne);
        } catch (ClientNotFoundException ex) {
            Logger.getLogger(HibernateClientDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Test
    @Transactional
    public void addAndRemovePrivatePersonTest() throws ClientNotFoundException {
        getHibernateClientDAO().deleteAll();
        PrivatePersonData newPrivatePerson = new PrivatePersonData();
        newPrivatePerson.setFirstName("Tomasz");
        newPrivatePerson.setLastName("Tomasz");

        ClientDTO client = new ClientDTO();

        client.setType(ClientType.UNKNOWN);
        getHibernateClientDAO().addClient(client);
        client.getPrivatePersonData().add(newPrivatePerson);

        getHibernateClientDAO().modifyClient(client);

        List<ClientDTO> clients = getHibernateClientDAO().findClients();
        assertTrue("" + clients.size(), clients.size() == 1);
        getHibernateClientDAO().removeClient(client);
        clients = getHibernateClientDAO().findClients();
        assertTrue("" + clients.size(), clients.isEmpty());

    }
}