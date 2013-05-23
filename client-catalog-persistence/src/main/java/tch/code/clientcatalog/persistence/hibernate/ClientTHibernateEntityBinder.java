/*
 */
package tch.code.clientcatalog.persistence.hibernate;

import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.core.service.data.model.ClientType;
import tch.code.clientcatalog.persistence.hibernate.entity.client.Company;
import tch.code.clientcatalog.persistence.hibernate.entity.client.PrivatePerson;

/**
 *
 * @author tch
 */
public class ClientTHibernateEntityBinder {

    public static Company buildCompanyEntity(ClientDTO clientDTO) {
        if (ClientType.COMPANY.equals(clientDTO.getType())) {
            Company company = new Company();
            company.setCompanyName(clientDTO.getCompanyData().getCompanyName());
            company.setId(clientDTO.getClientId());
            
                    
            return company;
        }

        throw new IllegalStateException("Improper DTO type is specified");
    }

    public static PrivatePerson buildPrivatePersonEntity(ClientDTO clientDTO) {
        if (ClientType.COMPANY.equals(clientDTO.getType())) {
            return new PrivatePerson();
        }

        throw new IllegalStateException("Improper DTO type is specified");
    }

    protected static Company buildClientDTO(Company company) {
        return null;
    }
}
