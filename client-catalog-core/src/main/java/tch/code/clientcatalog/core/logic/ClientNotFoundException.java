/*
 */
package tch.code.clientcatalog.core.logic;

import tch.code.clientcatalog.core.service.data.model.ClientDTO;

/**
 * Use when finding/identyfying client is not possible.
 *
 * @author tch
 */
public final class ClientNotFoundException extends Exception {

    private final ClientDTO notFoundCientData;

    public ClientNotFoundException(final ClientDTO notFoundCientData) {
        this.notFoundCientData = notFoundCientData;
    }
    
    public ClientNotFoundException(final Long notFoundCientId) {
        this.notFoundCientData = new ClientDTO();
        this.notFoundCientData.setClientId(notFoundCientId);
    }

    @Override
    public String toString() {
        StringBuffer exceptionString = new StringBuffer("Client Data caused a problem:");
        if (notFoundCientData != null && notFoundCientData.getClientId() != null) {
        } else {
            exceptionString.append("-Client data not present and is " + notFoundCientData);
        }
        return exceptionString.toString();
    }
}