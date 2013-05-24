/*
 */
package tch.code.clientcatalog.core.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.core.service.data.model.ClientDTOBuilder;
import tch.code.clientcatalog.core.service.data.model.ClientType;

/**
 *
 * @author tch
 */
public class ClientServiceTest {
    
    @Test
    public void builderTest() {            
        assertEquals(ClientDTOBuilder.companyTypeClient().getType(), ClientType.COMPANY);
        assertEquals(ClientDTOBuilder.privateTypeClient().getType(), ClientType.PRIVATE);
        assertEquals(ClientDTOBuilder.rawTypeClient().getType(), ClientType.UNKNOWN);
    }
    
    @Test
    public void clientServiceTest() {
        ClientService clientService = new ClientServiceImpl();
        List<ClientDTO> clients = new ArrayList<ClientDTO>();
        
        Map<Integer, List> pagedClients = clientService.pageClients(1, clients);
        assertEquals(pagedClients.size(), 0);
        
        pagedClients.clear();
        
        ClientDTO client1 = new ClientDTO();
        client1.setClientId(1l);
        ClientDTO client2 = new ClientDTO();
        client1.setClientId(2l);
         ClientDTO client3 = new ClientDTO();
        client1.setClientId(2l);
         ClientDTO client4 = new ClientDTO();
        client1.setClientId(2l);
         ClientDTO client5 = new ClientDTO();
        client1.setClientId(2l);
         ClientDTO client6 = new ClientDTO();
        client1.setClientId(2l);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
        
        pagedClients = clientService.pageClients(50, clients);
        assertEquals(pagedClients.size(), 1, pagedClients.toString() + " clients:" + clients.size());
        
        pagedClients.clear();
                
        List<Page> pages = clientService.listPages(50, clients);
        assertEquals(pages.size(), 1, pagedClients.toString() + " clients:" + clients.size());
        
        pages.clear();
        
        pages = clientService.listPages(1, clients);
        assertEquals(pages.size(), 6, pagedClients.toString() + " clients:" + clients.size());
        
        pages.clear();
        
        pages = clientService.listPages(6, clients);
        assertEquals(pages.size(), 1, pagedClients.toString() + " clients:" + clients.size());
        
        pages.clear();
    }
    
}
