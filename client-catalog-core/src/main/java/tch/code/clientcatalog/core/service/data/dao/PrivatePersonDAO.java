/*
 */
package tch.code.clientcatalog.core.service.data.dao;

import java.util.List;
import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 *
 * @author tch
 */
public interface PrivatePersonDAO {

    List<ClientDTO> findPersons();

    void removePerson(ClientDTO client);

    void addPerson(ClientDTO client);

    void modifyPerson(ClientDTO client);
}
