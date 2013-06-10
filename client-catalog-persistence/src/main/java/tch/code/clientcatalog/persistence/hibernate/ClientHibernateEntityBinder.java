/*
 */
package tch.code.clientcatalog.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;
import tch.code.clientcatalog.core.service.data.model.ClientType;
import tch.code.clientcatalog.core.service.data.model.CompanyData;
import tch.code.clientcatalog.core.service.data.model.PrivatePersonData;
import tch.code.clientcatalog.persistence.hibernate.entity.client.Client;
import tch.code.clientcatalog.persistence.hibernate.entity.client.Company;
import tch.code.clientcatalog.persistence.hibernate.entity.client.PrivatePerson;

/**
 * Utility class for data binding
 *
 * @author tch
 */
public class ClientHibernateEntityBinder {

    /**
     * DTO to entity binding
     *
     * @param clientDTO
     * @return proper corresponding entity instance
     */
    protected Company buildCompanyEntity(ClientDTO clientDTO) {
        if (!ClientType.COMPANY.equals(clientDTO.getType())) {
            return null;
        }

        Company company = new Company();
        company.setCompanyName(clientDTO.getCompanyData().getCompanyName());
        company.setId(clientDTO.getClientId());
        return company;


    }

    /**
     * DTO to entity binding
     *
     * @param private person DTO
     * @return proper corresponding entity instance
     */
    protected PrivatePerson buildPrivatePersonEntity(PrivatePersonData privatePerson, Client parent) {
        PrivatePerson privatePersonEntity = new PrivatePerson();
        privatePersonEntity.setFirstName(privatePerson.getFirstName());
        privatePersonEntity.setLastName(privatePerson.getLastName());
        privatePersonEntity.setClient(parent);
        return privatePersonEntity;
    }

    /**
     * DTO to entity binding
     *
     * @param clientDTO
     * @return proper corresponding entity instance
     */
    public Client buildEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getClientId());
        client.setType(clientDTO.getType());
        if (ClientType.PRIVATE.equals(clientDTO.getType())) {
            for (PrivatePersonData privatePerson : clientDTO.getPrivatePersonData()) {
                client.getPrivatePersons().add(buildPrivatePersonEntity(privatePerson, client));
            }
        }
        if (ClientType.COMPANY.equals(clientDTO.getType())) {
            client.setCompany(new Company());
            client.getCompany().setCompanyName(clientDTO.getCompanyData().getCompanyName());

        }
        client.setDescription(clientDTO.getDescription());

        return client;
    }

    /**
     * utility method
     *
     * @param entities
     * @return copies data from dto list to entity list
     */
    public List<ClientDTO> buildDTOlist(List<Client> entities) {
        //@FIXME: is there specializesd collection utility for copying arrays?
        List<ClientDTO> result = new ArrayList<ClientDTO>();
        for (Client entity : entities) {
            result.add(bindToDTO(entity));
        }
        return result;

    }

    /**
     * entity to DTO binding
     *
     * @param clientDTO
     * @return proper corresponding DTO instance
     *
     */
    public ClientDTO bindToDTO(Client entity) {
        ClientDTO dto = new ClientDTO();
        if (entity != null) {
            dto.setClientId(entity.getId());
            dto.setType(entity.getType());
            dto.setDescription(entity.getDescription());
            if (ClientType.PRIVATE.equals(entity.getType())) {
                for (PrivatePerson privatePerson : entity.getPrivatePersons()) {
                    dto.getPrivatePersonData().add(bindToDTO(privatePerson));
                }
            }
            if (ClientType.COMPANY.equals(entity.getType())) {
                CompanyData companyData = new CompanyData();
                companyData.setCompanyName(entity.getCompanyName());
                dto.setCompanyData(companyData);
            }
        }
        return dto;
    }

    protected PrivatePersonData bindToDTO(PrivatePerson entity) {
        PrivatePersonData dto = new PrivatePersonData();
        if (entity != null) {
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
        }
        return dto;
    }

    protected CompanyData bindToDTO(Company entity) {
        CompanyData dto = new CompanyData();
        if (entity != null) {
            dto.setCompanyName(entity.getCompanyName());
        }
        return dto;
    }
}
