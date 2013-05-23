/*
 */
package tch.code.clientcatalog.persistence;

import java.util.List;
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

    // TODO add test methods here. The name must begin with 'test'. For example:
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void findClientsTest() {
        List<ClientDTO> clients = clientDAO.findClients();

    }
}
