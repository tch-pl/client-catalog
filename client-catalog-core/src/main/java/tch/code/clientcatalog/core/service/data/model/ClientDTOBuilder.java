/*
 */
package tch.code.clientcatalog.core.service.data.model;

/**
 *
 * @author tch
 */
public class ClientDTOBuilder {
    /**
     * @return predefinied private client
     */
    public static ClientDTO privateTypeClient() {
        ClientDTO dto = rawTypeClient();        
        dto.setType(ClientType.PRIVATE);
        dto.setPrivatePersonData(new PrivatePersonData());
        return dto;
    }
    
    public static ClientDTO companyTypeClient() {
        ClientDTO dto = rawTypeClient();        
        dto.setType(ClientType.COMPANY);
        dto.setCompanyData(new CompanyData());
        return dto;        
    }
    
    public static ClientDTO rawTypeClient() {
        return  new ClientDTO();
    }
    
}
