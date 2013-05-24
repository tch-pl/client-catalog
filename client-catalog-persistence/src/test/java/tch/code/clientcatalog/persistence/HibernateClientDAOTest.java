/*
 */
package tch.code.clientcatalog.persistence;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;
import tch.code.clientcatalog.core.service.data.dao.ClientDAO;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.core.service.data.model.ClientType;
import tch.code.clientcatalog.core.service.data.model.CompanyData;
import tch.code.clientcatalog.persistence.mock.MockedClientDAO;

/**
 *
 * @author tch
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test/persistence-application-context.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "customTransactionManager")
public class HibernateClientDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ClientDAO clientDAO = null;

    @Test    
    public void mockTest() {
        MockedClientDAO mockedDAO = new MockedClientDAO();
        mockedDAO.addClient(new ClientDTO());
    }
    
    // Tests to run only when database is working
    
    //@Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void findClientsTest() {
        List<ClientDTO> clients = clientDAO.findClients();
        assertTrue(clients.size() == 2);
    }

    //@Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void addAndRemoveClientsTest() {
        ClientDTO newOne = new ClientDTO();
        newOne.setType(ClientType.PRIVATE);
        newOne.setDescription("123");
        newOne.getPrivatePersonData().setFirstName("ALI");
        newOne.getPrivatePersonData().setFirstName("BABA");
        clientDAO.addClient(newOne);
        assertNotNull(newOne.getClientId());
        logger.info(newOne.getClientId());

       List<ClientDTO> clients = clientDAO.findClients();
       assertTrue(clients.size() == 1);
        clientDAO.removeClient(newOne);
        assertNull(newOne.getClientId());
       clients = clientDAO.findClients();
       assertTrue(clients.size() == 0);
       newOne = new ClientDTO();
       newOne.setCompanyData(new CompanyData());
       newOne.getCompanyData().setCompanyName("BIG COMPANY");
       clientDAO.addClient(newOne);
       assertTrue(clients.size() == 1);
       clientDAO.removeClient(newOne);
       clients = clientDAO.findClients();
       assertTrue(clients.size() == 0);

    }
}
