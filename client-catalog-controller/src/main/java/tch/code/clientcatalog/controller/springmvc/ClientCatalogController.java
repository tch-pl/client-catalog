/*
 */
package tch.code.clientcatalog.controller.springmvc;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import tch.code.clientcatalog.core.logic.ClientService;

/**
 *
 * @author tch
 */
@Controller(value = "ClientCatalogController")
public class ClientCatalogController {
    
    private ClientService clientService;

    @RequestMapping(value="/client_list.html", method=GET)
    public String listClients(Map<String, Object> model) {
        model.put("client_list", clientService.findAllClients());
        return "home";
    }

    public ClientService getClientService() {
        return clientService;
    }

    @Autowired
    @Qualifier("ClientService")
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
