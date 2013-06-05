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
import org.springframework.web.bind.annotation.RequestParam;
import tch.code.clientcatalog.core.logic.ClientService;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 *
 * @author tch
 */
@Controller(value = "ClientCatalogController")
public class ClientCatalogController {
    private final int PAGE_SIZE = 1;
    private final int DEFAULT_PAGE_INDEX = 0;
    
    private final String CLIENT_LIST_PATH = "/client_list.html";
    
    private ClientService clientService;

    @RequestMapping({"/","/home"})
    public String home(Map<String, Object> model) {
        return "redirect:"+CLIENT_LIST_PATH;
    }
    
    @RequestMapping(method=GET, value="/client-catalog")
    public String redirect(Map<String, Object> model) {
        return "redirect:"+CLIENT_LIST_PATH;
    }
    
    @RequestMapping(method=GET, value="/index.html")
    public String mainPage(Map<String, Object> model) {
        return "redirect:"+CLIENT_LIST_PATH;
    }
    
    @RequestMapping(value=CLIENT_LIST_PATH, method=GET)
    public String listClients(Map<String, Object> model, @RequestParam(value="page",required=false) Integer page, @RequestParam(value="mode",required=false) String mode) {               
        Map<Integer, List> paged_client_data = clientService.pageClients(PAGE_SIZE, clientService.findAllClients());
        Integer current_index = page != null && page < paged_client_data.size() ? page : DEFAULT_PAGE_INDEX;
        List<ClientDTO> clientsToView = paged_client_data.get(current_index);
        model.put("client_list", clientsToView);
        model.put("page_count", paged_client_data.size());
        model.put("current_index", current_index);
        
        return "home";
    }

    @RequestMapping(value="/ajax"+CLIENT_LIST_PATH, method=GET)
    public String listClientsAjax(Map<String, Object> model, @RequestParam(value="page",required=false) Integer page, @RequestParam(value="mode",required=false) String mode) {               
        this.listClients(model, page, mode);
        return "client_list_table";        
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
