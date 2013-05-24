/*
 */
package tch.code.clientcatalog.controller.springmvc;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import tch.code.clientcatalog.core.logic.ClientService;
import tch.code.clientcatalog.core.service.data.dao.ClientDAO;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 *
 * @author tch
 */
@Controller(value = "ClientCatalogController")
public class ClientCatalogController {
    private final int PAGE_SIZE = 50;
    
    private ClientService clientService;

    @RequestMapping(method=GET, value="/client-catalog")
    public String redirect(Map<String, Object> model) {
        return "redirect:/client-catalog/client-list.html";
    }
    
    @RequestMapping(value="/client_list.html", method=GET)
    public String listClients(Map<String, Object> model) {
        // always get first page
        List<ClientDTO> clientsToView = clientService.pageClients(PAGE_SIZE, clientService.findAllClients()).get(0);
        model.put("client_list", clientsToView);
        return "home";
    }
    
    @RequestMapping(value="/client_add_form.html", method=GET)
    public String addClient(Map<String, Object> model) {        
        return "edition";
    }
    
    @RequestMapping(value="/client_edit_form.html", method=GET)
    public String editClient(Map<String, Object> model) {
        return "edition";
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
